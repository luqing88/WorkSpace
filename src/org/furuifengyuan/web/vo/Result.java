package org.furuifengyuan.web.vo;

public class Result<T> {
	private boolean success;
	private String message;
	private Integer code;
	private T module;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public T getModule() {
		return module;
	}

	public void setModule(T module) {
		this.module = module;
	}

	public Result() {
		super();
		// TODO Auto-generated constructor stub
		this.success=false;
	}
	public Result(boolean success) {
		super();
		// TODO Auto-generated constructor stub
		this.success=success;
	}
}
