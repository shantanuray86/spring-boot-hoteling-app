package com.hoteling.util;

public class Status {
	
	private String status ="Ok";
	private String errMsg;
	private String statusCode;
	
	public Status() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Status(String status, String errMsg, String statusCode) {
		super();
		this.status = status;
		this.errMsg = errMsg;
		this.statusCode = statusCode;
	}


	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getErrMsg() {
		return errMsg;
	}
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	
	
	
	

}
