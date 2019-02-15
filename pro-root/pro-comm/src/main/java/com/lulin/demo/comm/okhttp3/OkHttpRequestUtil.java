/**
 * 
 */
package com.lulin.demo.comm.okhttp3;

import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
* description  OkHttpRequestUtil
* @author LouLvLin
* @date  2019/2/1  16:54
* @param 
* @return 
**/
public class OkHttpRequestUtil {
	private static final MediaType TYPE_JSON = MediaType
			.parse("application/json;charset=utf-8");

	private OkHttpRequestUtil() {
	}

	/**
	 * @param url
	 * @param jsonStr
	 * @return
	 */
	public static Request buildPostJsonRequest(String url, String jsonStr) {
		RequestBody requestBody = RequestBody.create(TYPE_JSON, jsonStr);
		Request request = new Request.Builder().url(url).post(requestBody)
				.build();
		return request;
	}

	/**
	 * @param url
	 * @return
	 */
	public static Request buildGetRequest(String url) {
		return new Request.Builder()
				.url(url).get().build();
	}

}
