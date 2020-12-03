package com.example.demo.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository("MetaInfoDao")
public interface MetaInfoDao {
	
	public Map selectMetaInfoList(String name);

}
