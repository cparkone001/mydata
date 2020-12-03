package com.example.demo.dao.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResultMsg {
	@JsonProperty("isSuccess")
	boolean isSuccess;
	@JsonProperty("message")
	String message;
	
	public ResultMsg(boolean isSuccess, String message) {
		this.isSuccess = isSuccess;
		this.message = message; 
	}
	
	public boolean isSuccess() {
		return isSuccess;
	}
	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public static ResultMsg getInstance(boolean isSuccess, String message) {
		return new ResultMsg(isSuccess, message );
	}
}
