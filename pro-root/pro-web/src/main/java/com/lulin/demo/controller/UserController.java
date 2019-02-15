package com.lulin.demo.controller;

import com.lulin.demo.comm.exception.ServiceException;
import com.lulin.demo.comm.util.RestUrlConstants;
import com.lulin.demo.entity.ResultBuilder;
import com.lulin.demo.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * description 用户管理Controller
 *
 * @author LouLvLin
 * @version 1.0
 * @date 2019年02月13日 9:54
 */
@RestController
@Api(tags="用户管理")
public class UserController {
	/** logger */
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private IUserService userService;


	/**
	 * <p>Title: getAllUsers </p>
	 * <p>Description: 获取所有用户 </p>
	 * @return
	 */
	@ApiOperation(value="获取所有用户列表", httpMethod = "GET",produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = RestUrlConstants.ALL_USERS, method = RequestMethod.GET)
	public ResultBuilder getAllUsers() {
		return ResultBuilder.success().build(userService.getAllUsers());
	}

	/**
	 * <p>Title: getUsersWithOutCache </p>
	 * <p>Description: 获取所有用户，不走ehcache缓存 </p>
	 * @return
	 */
	@ApiOperation(value="获取所有用户列表，不走缓存", httpMethod = "GET",produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = RestUrlConstants.ALL_USERS_NO_CACHE, method = RequestMethod.GET)
	public ResultBuilder getUsersWithOutCache() {
		return ResultBuilder.success().build(userService.getUsersWithOutCache());
	}

	/**
	 * <p>Title: getUsersWithPage </p>
	 * <p>Description: 分页获取所有用户 </p>
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	@ApiOperation(value="分页获取用户列表", httpMethod = "GET",produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = RestUrlConstants.GET_USERS_WITH_PAGE, method = RequestMethod.GET)
	public ResultBuilder getUsersWithPage(@PathVariable("currentPage") Integer currentPage,
	                                      @PathVariable("pageSize") Integer pageSize) {
		LOGGER.info("coming into UserController.getUsersWithPage,and params is : currentPage : {} ,pageSize : {}",currentPage,pageSize);
		return ResultBuilder.success().build(userService.getAllUsersWithPageHelper(currentPage, pageSize));
	}

	/**
	 * <p>Title: getServiceException </p>
	 * <p>Description: 测试serviceException </p>
	 * @return
	 */
	@ApiOperation(value="测试serviceException", httpMethod = "GET",produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = RestUrlConstants.TEST_SERVICE_EXCEPTION, method = RequestMethod.GET)
	public ResultBuilder getServiceException() {
		LOGGER.info("coming into UserController.getServiceException");
		throw new ServiceException("test service exception");
	}

	/**
	 * <p>Title: getServiceException </p>
	 * <p>Description: 测试serviceException </p>
	 * @return
	 */
	@ApiOperation(value="测试非serviceException", httpMethod = "GET",produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = RestUrlConstants.TEST_OTHER_EXCEPTION, method = RequestMethod.GET)
	public ResultBuilder getOtherException(@PathVariable("numerator") Integer numerator,
	                                       @PathVariable("denominator") Integer denominator) {
		LOGGER.info("coming into UserController.getOtherException");
		return ResultBuilder.success().build(userService.getDivisionResult(numerator, denominator));
	}

}


