/**
 * 
 */
package com.lulin.demo.comm.okhttp3;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
* description  OkHttpUtil
* @author LouLvLin
* @date  2019/2/1  16:54
* @param 
* @return 
**/
public class OkHttpUtil {
	private static OkHttpClient singleton;
	private static final Logger LOGGER = LoggerFactory.getLogger(OkHttpUtil.class);
	private OkHttpUtil() {
	}
	
	/**
	 * <p>Title: getInstance </p>
	 * <p>Description: TODO </p>
	 * @return
	 */
	public static OkHttpClient getInstance() {
		if (null == singleton) {
			synchronized (OkHttpUtil.class) {
				if (null == singleton) {
					singleton = new OkHttpClient.Builder()
							.connectTimeout(10, TimeUnit.SECONDS)
							.readTimeout(120, TimeUnit.SECONDS).build();
				}
			}
		}
		return singleton;
	}
	/**
	 * <p>Title: getStringFromServer </p>
	 * <p>Description: 通过 url获取string  get请求 </p>
	 * @param url
	 * @return
	 */
	public static String getStringFromServer(String url) {
		String result = "";
		try {
			Response response = getInstance()
					.newCall(OkHttpRequestUtil.buildGetRequest(url)).execute();
			
			if (!response.isSuccessful()) {
				throw new IOException("服务器端错误:" + response);
			}
			result = response.body().string();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			LOGGER.error("getDongHuanInfo error: ",e);
		}
		return result;
	}
	
	/**
	 * <p>Title: getStringFromServerByPost </p>
	 * <p>Description: 通过 url和parameterJsonType获取string  post请求 </p>
	 * @param url
	 * @param parameterJsonType
	 * @return
	 */
	public static String getStringFromServerByPost(String url,String parameterJsonType) {
		String result = "";
		try {
			Response response = getInstance()
					.newCall(OkHttpRequestUtil.buildPostJsonRequest(url,parameterJsonType)).execute();
			
			if (!response.isSuccessful()) {
				throw new IOException("服务器端错误:" + response);
			}
			result = response.body().string();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			LOGGER.error("getDongHuanInfo error: ",e);
		}
		return result;
	}

}
