package com.example.demo.dao.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User
{
	@JsonProperty("userId")
	public String u;
 
	@JsonProperty("age")
	public String a;
 
	@JsonProperty("email")
	public String e;
	
	
   @Override
    public String toString() {
        return "User [userId=" + u + ", age=" + a + ", email=" + e  + "]";
   }
}