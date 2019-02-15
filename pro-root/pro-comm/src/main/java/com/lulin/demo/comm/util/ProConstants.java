package com.lulin.demo.comm.util;

import com.google.gson.Gson;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * description 常量配置类
 *
 * @author LouLvLin
 * @version 1.0
 * @date 2019年02月01日 15:51
 */
public final class ProConstants {

	/**
	 * <p>Title: LangChaoConstants </p>
	 * <p>Description: Constructor </p>
	 */
	private ProConstants() {
	}

	public static final String MSG_BASE_EXCEPTION = "服务端发生自定义异常，信息如下: ";
	public static final String MSG_OTHER_EXCEPTION = "服务端发生非自定义异常，信息如下: ";
	public static final Gson COMM_GSON = new Gson();

	/**
	 * <p>Title: getPageInfo </p>
	 * <p>Description: 获取分页返回信息 </p>
	 * @param params
	 * @return
	 */
	public static Map<String, Object> getPageInfo(Map<String, Object> params){
		Map<String, Object> userInfo = new LinkedHashMap<>();

		int totalPage = 0;
		int allRows = (int) params.get("totalCount");
		int pageSize = (int) params.get("pageSize");
		if (allRows % pageSize > 0) {
			totalPage = allRows / pageSize + 1;
		} else if (allRows % pageSize == 0) {
			totalPage = allRows / pageSize;
		}
		userInfo.put("totalPage", totalPage);
		userInfo.put("totalCount", allRows);
		userInfo.put("currentPage", params.get("currentPage"));
		return userInfo;
	}
}


