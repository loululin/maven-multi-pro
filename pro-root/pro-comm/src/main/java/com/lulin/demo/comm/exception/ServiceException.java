package com.lulin.demo.comm.exception;

/**
 * description service层自定义异常
 *
 * @author LouLvLin
 * @version 1.0
 * @date 2019年02月01日 16:45
 */
public class ServiceException extends BaseException {

	private static final long serialVersionUID = -2009035095916699986L;

	/**
	 * <p>Title: ServiceException </p>
	 * <p>Description: Constructor </p>
	 * @param errorCode
	 * @param errorMsg
	 */
	public ServiceException(int errorCode, String errorMsg) {
		super(errorCode, errorMsg);
	}
	/**
	 *
	 * <p>Title: ServiceException </p>
	 * <p>Description: Constructor </p>
	 * @param errorMsg
	 */
	public ServiceException(String errorMsg) {
		super(errorMsg);
	}
	/**
	 *
	 * <p>Title: ServiceException </p>
	 * <p>Description: Constructor </p>
	 * @param cause
	 * @param errorCode
	 * @param errorMsg
	 * @param traceId
	 */
	public ServiceException(Throwable cause, int errorCode, String errorMsg,
	                        String traceId) {
		super(cause, errorCode, errorMsg, traceId);
	}
	/**
	 *
	 * <p>Title: ServiceException </p>
	 * <p>Description: Constructor </p>
	 * @param cause
	 * @param errorCode
	 * @param errorMsg
	 */
	public ServiceException(Throwable cause, int errorCode, String errorMsg) {
		super(cause, errorCode, errorMsg);
	}
	/**
	 *
	 * <p>Title: ServiceException </p>
	 * <p>Description: Constructor </p>
	 * @param cause
	 * @param errorMsg
	 */
	public ServiceException(Throwable cause, String errorMsg) {
		super(cause, errorMsg);
	}
	/**
	 *
	 * <p>Title: ServiceException </p>
	 * <p>Description: Constructor </p>
	 * @param cause
	 */
	public ServiceException(Throwable cause) {
		super(cause);
	}
}


