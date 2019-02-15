package com.lulin.demo.comm.sysconfig;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.HotReload;
import org.aeonbits.owner.Config.Sources;

import java.util.List;

/**
 * description 系统配置接口
 *
 * @author LouLvLin
 * @date 2019年02月13日 10:57
 * @vversion 1.0
 */
@HotReload(10)
@Sources({"classpath:ServerConfig.properties" })
public interface ServerConfig extends Config {
	/**
	 * <p>Title: getIntDemo </p>
	 * <p>Description: 获取int型值 </p>
	 * @return
	 */
	@Key("int.demo")
	int getIntDemo();

	/**
	 * <p>Title: getZhucheng </p>
	 * <p>Description: 获取List<String>型值 </p>
	 * @return
	 */
	@Key("zhucheng")
	List<String> getZhucheng();

	/**
	 * <p>Title: getHelloMr </p>
	 * <p>Description: 获取带参数的string值  </p>
	 * @param mr
	 * @return
	 */
	@Key("helloMr")
	String getHelloMr(String mr);

	/**
	 * <p>Title: getFruit </p>
	 * <p>Description: 获取String[]型值 </p>
	 * @return
	 */
	@Key("fruit")
	public String[] getFruit();

	/**
	 * <p>Title: getFibonacci </p>
	 * <p>Description: 获取指定分隔符号的int[]型值  </p>
	 * @return
	 */
	@Separator(";")
	@Key("fibonacci")
	public int[] getFibonacci();
}
