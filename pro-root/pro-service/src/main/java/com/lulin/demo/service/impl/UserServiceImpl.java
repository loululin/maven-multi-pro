package com.lulin.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.lulin.demo.dao.UserMapper;
import com.lulin.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * description user operation impl class
 *
 * @author LouLvLin
 * @version 1.0
 * @date 2019年02月01日 16:21
 */
@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserMapper userMapper;

	/**
	 * 获取所有用户,走ehcache缓存
	 */
	@Override
	public List<Map<String, Object>> getAllUsers() {
		return userMapper.getUsers();
	}

	/**
	 * 获取所有用户,不走ehcache缓存
	 */
	@Override
	public List<Map<String, Object>> getUsersWithOutCache() {
		return userMapper.getUsersWithOutCache();
	}

	/**
	 * 分页获取用户信息
	 */
	@Override
	public Map<String, Object> getAllUsersWithPageHelper(int currentPage, int pageSize) {
		Map<String, Object> resultMap = Maps.newHashMapWithExpectedSize(2);

		//开启分页插件并设置分页初始化参数，当前页码和每页显示记录数
		PageHelper.startPage(currentPage, pageSize);
		//查询数据库拿到结果
		//紧跟着的第一个select方法会被分页（会自动注入分页信息到sql，建议查看执行的sql便于理解，详询PageHelper作者文档解释）
		List<Map<String, Object>> resutlList = userMapper.getUsers();
		//把查询结果封装进分页对象里面
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(resutlList);

		//封装成前端需要的数据结构
		List<Map<String, Object>> list = pageInfo.getList();
		resultMap.put("resourceList", list);
		Map<String, Object> pageInfoMap = Maps.newHashMapWithExpectedSize(3);
		pageInfoMap.put("totalPage", pageInfo.getPages());
		pageInfoMap.put("totalCount", pageInfo.getTotal());
		pageInfoMap.put("currentPage", pageInfo.getPageNum());
		resultMap.put("pageInfo", pageInfoMap);

		return resultMap;
	}

	/**
	 * 获取除法结果
	 */
	@Override
	public Integer getDivisionResult(int numerator, int denominator) {
		// TODO Auto-generated method stub
		return numerator/denominator;
	}
}


