package com.lulin.demo.comm.okhttp3;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.*;

public class OkHttpUtilTest {
	
	/** logger */
	private static final Logger LOGGER = LoggerFactory.getLogger(OkHttpUtilTest.class);

	@Test
	public void getStringFromServer() {
		String getResult = OkHttpUtil.getStringFromServer("https://www.baidu.com/");
		LOGGER.info("OKHttpUtil TEST ：" + getResult.substring(0, 30));
		Assert.assertThat(getResult, Matchers.containsString("STATUS OK"));
	}
}