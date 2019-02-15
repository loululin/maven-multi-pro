package com.lulin.demo.entity;

import java.io.Serializable;

/**
 * description 后端返回结果封装
 *
 * @author LouLvLin
 * @version 1.0
 * @date 2019年02月01日 14:48
 */
public class ResultBuilder implements Serializable {

	private static final long serialVersionUID = 7530473297456144575L;
	public static final String MSG_SUCCESS = "success";
	public static final String MSG_FAIL = "failure";
	public static final int CODE_SUCCESS = 1;
	public static final int CODE_FAIL = 0;
	/**
	* description  返回结果数字标识
	**/
	private int code;
	/**
	 * description  返回结果字符串标识
	 **/
	private String msg;
	/**
	 * description  返回结果内容
	 **/
	private Object result;
	/**
	* description  私有构造方法
	* @author LouLvLin
	* @date  2019/2/1  14:55
	**/
	private ResultBuilder() {
	}

	/**
	 * <p>Title: success </p>
	 * <p>Description: TODO </p>
	 * @return
	 */
	public static ResultBuilder success() {
		ResultBuilder result = new ResultBuilder();
		result.code = CODE_SUCCESS;
		result.msg = MSG_SUCCESS;
		return result;
	}
	/**
	 * <p>Title: fail </p>
	 * <p>Description: TODO </p>
	 * @return
	 */
	public static ResultBuilder fail() {
		ResultBuilder result = new ResultBuilder();
		result.code = CODE_FAIL;
		result.msg = MSG_FAIL;
		return result;
	}

	/**
	 * <p>Title: build </p>
	 * <p>Description: TODO </p>
	 * @param result
	 * @return
	 */
	public ResultBuilder build(Object result) {
		if (null != result) {
			this.result = result;
		} else {
			this.result = null;
		}
		return this;
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("Result{");
		sb.append(", 'code':'").append(code).append('\'');
		sb.append(", 'message':'").append(msg).append('\'');
		sb.append(", 'result':").append(result);
		sb.append('}');
		return sb.toString();
	}

	/**
	 * Gets the value of code
	 *
	 * @return the value of code
	 */
	public int getCode() {
		return code;
	}

	/**
	 * Sets the code
	 * <p>You can use getCode() to get the value of code</p>
	 *
	 * @param code code
	 */
	public void setCode(int code) {
		this.code = code;
	}

	/**
	 * Gets the value of msg
	 *
	 * @return the value of msg
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * Sets the msg
	 * <p>You can use getMsg() to get the value of msg</p>
	 *
	 * @param msg msg
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

	/**
	 * Gets the value of result
	 *
	 * @return the value of result
	 */
	public Object getResult() {
		return result;
	}

	/**
	 * Sets the result
	 * <p>You can use getResult() to get the value of result</p>
	 *
	 * @param result result
	 */
	public void setResult(Object result) {
		this.result = result;
	}
}


