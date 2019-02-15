package com.lulin.demo.quartz;

import com.lulin.demo.comm.util.ProConstants;
import com.lulin.demo.service.IUserService;
import com.lulin.demo.websocket.WebSocketServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * description 定时任务类
 *
 * @author LouLvLin
 * @version 1.0
 * @date 2019年02月14日 17:17
 */
public class ScheduleTask {

	@Autowired
	private IUserService iUserService;

	/**
	 * logger
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(ScheduleTask.class);

	public void websocketTask() {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
		//获取WebSocketServer对象的映射。
		ConcurrentHashMap<String, WebSocketServer> map = WebSocketServer.getWebSocketMap();
		if (map.size() != 0) {
			String messageString = ProConstants.COMM_GSON.toJson(iUserService.getAllUsers());
			for (Map.Entry<String, WebSocketServer> entry : map.entrySet()) {
				WebSocketServer webSocketServer = entry.getValue();
				try {
					//向客户端推送消息
					webSocketServer.getSession().getBasicRemote().sendText(messageString);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else {
			System.out.println("WebSocket未连接");
		}
	}

}


