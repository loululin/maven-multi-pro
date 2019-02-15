package com.lulin.demo.dao;

import java.util.List;
import java.util.Map;

/**
 * description user operation db
 *
 * @author LouLvLin
 * @date 2019年02月01日 15:30
 * @vversion 1.0
 */
public interface UserMapper {

	/**
	 * <p>Title: getUsers </p>
	 * <p>Description: 获取所有用户</p>
	 * @return
	 */
	List<Map<String, Object>> getUsers();

	/**
	 * <p>Title: getUsersWithOutCache </p>
	 * <p>Description: 获取所有用户,不走ehcache缓存</p>
	 * @return
	 */
	List<Map<String, Object>> getUsersWithOutCache();

}
