package com.lulin.demo.comm.exception;

import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * description 自定义异常
 *
 * @author LouLvLin
 * @version 1.0
 * @date 2019年02月01日 16:44
 */
public class BaseException extends RuntimeException {

	private static final long serialVersionUID = 523791649311201795L;

	/**
	 * 未知错误code
	 */
	public static final int UNKNOWN_ERROR_CODE = 3;
	/**
	 * 异常
	 */
	private Throwable cause;
	/**
	 * 错误code
	 */
	private int errorCode;
	/**
	 * 追踪id
	 */
	private String traceId;

	/**
	 * <p>Title: BaseException </p>
	 * <p>Description: Constructor </p>
	 * @param errorMsg
	 */
	public BaseException(String errorMsg){
		this(null, errorMsg);
	}
	/**
	 * <p>Title: BaseException </p>
	 * <p>Description: Constructor </p>
	 * @param cause
	 */
	public BaseException(Throwable cause){
		this(cause, "");
	}
	/**
	 * <p>Title: BaseException </p>
	 * <p>Description: Constructor </p>
	 * @param errorCode
	 * @param errorMsg
	 */
	public BaseException(int errorCode, String errorMsg) {
		this(null, errorCode, errorMsg);
	}

	/**
	 * <p>Title: BaseException </p>
	 * <p>Description: Constructor </p>
	 * @param cause
	 * @param errorMsg
	 */
	public BaseException(Throwable cause, String errorMsg){
		this(cause, BaseException.UNKNOWN_ERROR_CODE, errorMsg);
	}
	/**
	 * <p>Title: BaseException </p>
	 * <p>Description: Constructor </p>
	 * @param cause
	 * @param errorCode
	 * @param errorMsg
	 */
	public BaseException(Throwable cause, int errorCode, String errorMsg){
		this(cause, errorCode, errorMsg, null);
	}
	/**
	 * <p>Title: BaseException </p>
	 * <p>Description: Constructor </p>
	 * @param cause
	 * @param errorCode
	 * @param errorMsg
	 * @param traceId
	 */
	public BaseException(Throwable cause, int errorCode, String errorMsg, String traceId){
		super(errorMsg);
		this.cause = cause;
		this.errorCode = errorCode;
		this.traceId = traceId;
	}

	/**
	 *
	 */
	@Override
	public void printStackTrace() {
		this.printStackTrace(System.err);
	}
	/**
	 *
	 */
	@Override
	public void printStackTrace(PrintStream ps){
		if(null == getCause()){
			super.printStackTrace(ps);
		}else{
			ps.println(this);
			getCause().printStackTrace(ps);
		}
	}
	/**
	 *
	 */
	@Override
	public void printStackTrace(PrintWriter pw){
		if(null == getCause()){
			super.printStackTrace(pw);
		}else{
			pw.println(this);
			getCause().printStackTrace(pw);
		}
	}
	/**
	 *
	 */
	@Override
	public Throwable getCause(){
		return this.cause == this ? null : this.cause;
	}

	/**
	 *
	 */
	@Override
	public String getMessage(){
		if (getCause() == null) {
			return super.getMessage();
		}
		return super.getMessage() + getCause().getMessage();
	}
	/**
	 * <p>Title: getErrorCode </p>
	 * <p>Description: TODO </p>
	 * @return
	 */
	public int getErrorCode() {
		return errorCode;
	}
	/**
	 * <p>Title: getTraceId </p>
	 * <p>Description: TODO </p>
	 * @return
	 */
	public String getTraceId() {
		return traceId;
	}
}


