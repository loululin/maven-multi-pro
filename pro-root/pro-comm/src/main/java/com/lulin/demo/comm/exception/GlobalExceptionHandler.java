package com.lulin.demo.comm.exception;

import com.lulin.demo.comm.util.ProConstants;
import com.lulin.demo.entity.ResultBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;



/**
* description  GlobalExceptionHandler
* @author LouLvLin
* @date  2019/2/1  16:59
* @param 
* @return 
**/
@RestControllerAdvice
public class GlobalExceptionHandler {
	private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(Exception.class)
	public ResultBuilder handleException(Exception ex) {
		LOGGER.error("spring统一异常处理捕获Controller层异常： ", ex);
		return (ex instanceof BaseException) ? ResultBuilder.fail().build(ProConstants.MSG_BASE_EXCEPTION + ex.getMessage())
				: ResultBuilder.fail().build(ProConstants.MSG_OTHER_EXCEPTION + ex.getMessage());
	}
}
