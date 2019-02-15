package com.lulin.demo.comm.util;

/**
 * description RUI接口定义
 *
 * @author LouLvLin
 * @version 1.0
 * @date 2019年02月01日 16:40
 */
public class RestUrlConstants {

	/**
	 * <p>Title: LangChaoRestURIConstants </p>
	 * <p>Description: Constructor </p>
	 */
	private RestUrlConstants() {
	}


	/**
	 * 获取所有用户
	 */
	public static final String ALL_USERS = "/users/all";
	/**
	 * 获取所有用户,不走ehcache缓存
	 */
	public static final String ALL_USERS_NO_CACHE = "/users/all/nochache";
	/**
	 * 分页获取用户信息
	 */
	public static final String GET_USERS_WITH_PAGE = "/users/{currentPage}/{pageSize}";
	/**
	 * 测试serviceException
	 */
	public static final String TEST_SERVICE_EXCEPTION = "/test/serviceException";
	/**
	 * 测试非serviceException
	 */
	public static final String TEST_OTHER_EXCEPTION = "/test/otherException/{numerator}/{denominator}";
	/**
	 * 测试spring线程池
	 */
	public static final String TEST_EXECUTOR_POOL = "/execute";

}


