package com.lulin.demo.service;

import java.util.List;
import java.util.Map;

/**
 * description user operation service interface
 *
 * @author LouLvLin
 * @date 2019年02月01日 16:19
 * @vversion 1.0
 */
public interface IUserService {
	/**
	 * <p>Title: getAllUsers </p>
	 * <p>Description: 获取所有用户 </p>
	 * @return
	 */
	List<Map<String, Object>> getAllUsers();

	/**
	 * <p>Title: getUsersWithOutCache </p>
	 * <p>Description: 获取所有用户,不走ehcache缓存 </p>
	 * @return
	 */
	List<Map<String, Object>> getUsersWithOutCache();

	/**
	 * <p>Title: getAllUsersWithPageHelper </p>
	 * <p>Description: 分页获取用户信息  </p>
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	Map<String, Object> getAllUsersWithPageHelper(int currentPage, int pageSize);
	/**
	 * <p>Title: getDivisionResult </p>
	 * <p>Description: 获取除法结果 </p>
	 * @param numerator
	 * @param denominator
	 * @return
	 */
	Integer getDivisionResult(int numerator, int denominator);
}
