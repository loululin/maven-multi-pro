package com.lulin.demo.comm.sysconfig;

import org.aeonbits.owner.ConfigCache;

/**
 * description 系统配置工具类
 *
 * @author LouLvLin
 * @version 1.0
 * @date 2019年02月13日 11:00
 */
public final class ServerConfigUtil {
	/**
	 * <p>Title: ServerConfigUtil </p>
	 * <p>Description: Constructor </p>
	 */
	private ServerConfigUtil() {
	}
	/**
	 *
	 * <p>Title: getServerConf </p>
	 * <p>Description: 获取系统配置单例 </p>
	 * @return
	 */
	public static ServerConfig getServerConf (){
		return ConfigCache.getOrCreate(ServerConfig.class);
	}
}


