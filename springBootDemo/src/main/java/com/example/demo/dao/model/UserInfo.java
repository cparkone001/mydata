package com.example.demo.dao.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserInfo {
	@JsonProperty("id")
	String id;
	
	@JsonProperty("name")
	String name;
	
	@JsonProperty("email")
	String email;
	
	@JsonProperty("dept")
	String dept;
	
	@JsonProperty("etc")
	String etc;
}
