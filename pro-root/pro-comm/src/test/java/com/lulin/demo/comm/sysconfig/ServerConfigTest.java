package com.lulin.demo.comm.sysconfig;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.junit.Assert.*;

public class ServerConfigTest {
	/** logger */
	private static final Logger LOGGER = LoggerFactory.getLogger(ServerConfigTest.class);

	@Test
	public void getIntDemo() {
		int intDemo = ServerConfigUtil.getServerConf().getIntDemo();
		LOGGER.info("getIntDemo: " + intDemo);
		Assert.assertThat(intDemo, Matchers.equalTo(10000));
	}

	@Test
	public void getZhucheng() {
		List<String> getZhucheng = ServerConfigUtil.getServerConf().getZhucheng();
		LOGGER.info("getZhucheng list size : " + getZhucheng);
		Assert.assertThat(getZhucheng.size(), Matchers.equalTo(11));
	}

	@Test
	public void getHelloMr() {
		LOGGER.info("getHelloMr  : " + ServerConfigUtil.getServerConf().getHelloMr("loulvlin"));
	}

	@Test
	public void getFruit() {
		int getFruit = ServerConfigUtil.getServerConf().getFruit().length;
		LOGGER.info("getFruit array length : " + getFruit);
		Assert.assertThat(getFruit, Matchers.equalTo(3));
	}

	@Test
	public void getFibonacci() {
		int[] getFibonacci = ServerConfigUtil.getServerConf().getFibonacci();
		LOGGER.info("getFibonacci array length : " + getFibonacci.toString());
		Assert.assertThat(getFibonacci.length, Matchers.equalTo(11));
	}
}