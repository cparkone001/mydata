package com.example.demo.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HelloController {

	private static final Logger DEBUG = LogManager.getLogger(HelloController.class);
	
	@RequestMapping("/")
	public ModelAndView greet() {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("welcome");
		mv.addObject("name", "myFirst App");
		DEBUG.debug("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ddd");
		return mv;
	}
	
	@RequestMapping("/ajaxtest")
	public ModelAndView ajaxWebPage() {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("Girlfriends");
		mv.addObject("name", "myFirst App");
		DEBUG.debug("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ddd");
		return mv;
	}	

}