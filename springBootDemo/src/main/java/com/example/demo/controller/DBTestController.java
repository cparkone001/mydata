package com.example.demo.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.MetaInfoDao;


@Controller
public class DBTestController {
	
	private static final Logger DEBUG = LogManager.getLogger(DBTestController.class);

	@Autowired
	MetaInfoDao dao;
	
	@RequestMapping("/mydbtest")
	public ModelAndView dtTest() {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("welcome");
		//mv.addObject("name", name);
		
		dao.selectMetaInfoList("ddd");
		DEBUG.debug("Hello from Log4j 2 - num : {}", "ggggggg");
		
		return mv;
	}
}
