package com.webservice.response;

public class BaseResponse<T> {
	
	private Integer statuscode;
	private String msg;
	private T responsedata;
	public Integer getStatuscode() {
		return statuscode;
	}
	public void setStatuscode(Integer statuscode) {
		this.statuscode = statuscode;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public T getResponsedata() {
		return responsedata;
	}
	public void setResponsedata(T responsedata) {
		this.responsedata = responsedata;
	}
	public BaseResponse(Integer statuscode, String msg, T responsedata) {
		super();
		this.statuscode = statuscode;
		this.msg = msg;
		this.responsedata = responsedata;
	}
	public BaseResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
