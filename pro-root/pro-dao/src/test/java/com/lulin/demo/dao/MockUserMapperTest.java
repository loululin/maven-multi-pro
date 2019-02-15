package com.lulin.demo.dao;

import com.google.common.collect.Maps;
import com.lulin.demo.comm.util.ProConstants;
import org.easymock.EasyMock;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * description EasyMock UT Demo
 *
 * @author LouLvLin
 * @version 1.0
 * @date 2019年02月13日 11:34
 */
public class MockUserMapperTest {

	/** logger */
	private static final Logger LOGGER = LoggerFactory.getLogger(MockUserMapperTest.class);

	private UserMapper userMapper;


	@Before
	public void before(){
		userMapper = EasyMock.createMock(UserMapper.class);
		List<Map<String, Object>> users = new ArrayList<>();
		Map<String, Object> user1 = Maps.newHashMapWithExpectedSize(2);
		user1.put("name", "leilei");
		user1.put("age", 20);
		users.add(user1);
		Map<String, Object> user2 = Maps.newHashMapWithExpectedSize(2);
		user2.put("name", "huihui");
		user2.put("age", 30);
		users.add(user2);
		Map<String, Object> user3 = Maps.newHashMapWithExpectedSize(2);
		user3.put("name", "lili");
		user3.put("age", 30);
		users.add(user3);
		//录制Mock对象预期行为，andReturn方法表示返回的预期结果
		EasyMock.expect(userMapper.getUsers()).andReturn(users);
		//重放Mock对象，测试时以录制的对象预期行为代替真实对象的行为
		EasyMock.replay(userMapper);

	}

	@Test
	public void getUsersTest(){
		List<Map<String, Object>> result = userMapper.getUsers();
		LOGGER.info("getUsers IS 用户信息:   ---"  + ProConstants.COMM_GSON.toJson(result));
		//左边实际值，右边括号里面是期望值
		Assert.assertThat(result.size(), Matchers.equalTo(3));
	}

	@After
	public void after(){
		LOGGER.info("测试完之后释放资源");
	}

}


