package com.example.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.dao.model.UserInfo;

@Repository("UserInfoDao")
public interface UserInfoDao {
	List<UserInfo> selectAll();
	int add(UserInfo userIno);
}
