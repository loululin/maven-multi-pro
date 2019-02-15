package com.lulin.demo.service;

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
* description  IUserServiceTest
* @author LouLvLin
* @date  2019/2/1  16:31
* @param
* @return
**/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:config/application-*.xml"})
@WebAppConfiguration
public class IUserServiceTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(IUserServiceTest.class);

	@Autowired
	private IUserService userService;

	@Test
	public void getAllUsers() {
		List<Map<String, Object>> result = userService.getAllUsers();
		Assert.assertThat(result.size(), Matchers.greaterThanOrEqualTo(0));
		LOGGER.info("getAllUsers IS :   ---"  + ProConstants.COMM_GSON.toJson(result));
	}

	@Test
	public void getUsersWithOutCache() {
		List<Map<String, Object>> result = userService.getUsersWithOutCache();
		Assert.assertThat(result.size(), Matchers.greaterThanOrEqualTo(0));
		LOGGER.info("getAllUsers IS :   ---"  + ProConstants.COMM_GSON.toJson(result));
	}

	@Test
	public void getAllUsersWithPageHelper() {
		Map<String, Object> result = userService.getAllUsersWithPageHelper(2,3);
		Assert.assertThat(result.size(), Matchers.greaterThanOrEqualTo(0));
		LOGGER.info("getAllUsersWithPageHelper IS :   ---"  + ProConstants.COMM_GSON.toJson(result));
	}

	@Test
	public void getDivisionResult() {
		int reslut = userService.getDivisionResult(10, 5);
		Assert.assertThat(2, Matchers.equalTo(reslut));
	}
}