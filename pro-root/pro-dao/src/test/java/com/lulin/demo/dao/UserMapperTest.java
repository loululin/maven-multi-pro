package com.lulin.demo.dao;

import com.lulin.demo.comm.util.ProConstants;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
/**
* description  UserMapperTest
* @author LouLvLin
* @date  2019/2/1  15:48
* @param 
* @return 
**/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:config/application-dao.xml"})
@WebAppConfiguration
public class UserMapperTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserMapperTest.class);

	@Autowired
	private UserMapper userMapper;

	@Test
	public void getUsers() {
		List<Map<String, Object>> result = userMapper.getUsers();
		Assert.assertThat(result.size(), Matchers.greaterThanOrEqualTo(0));
		LOGGER.info("getUsersTest IS :   ---"  + ProConstants.COMM_GSON.toJson(result));
	}

	@Test
	public void getUsersWithOutCache() {
		List<Map<String, Object>> result = userMapper.getUsersWithOutCache();
		Assert.assertThat(result.size(), Matchers.greaterThanOrEqualTo(0));
		LOGGER.info("getUsersWithOutCache IS :   ---"  + ProConstants.COMM_GSON.toJson(result));
	}
}