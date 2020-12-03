package com.example.demo.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.MetaInfoDao;
import com.example.demo.dao.UserInfoDao;
import com.example.demo.dao.model.ResultMsg;
import com.example.demo.dao.model.User;
import com.example.demo.dao.model.UserInfo;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * This is Demo Spring boot
 * @author chul Park
 *
 */
@RestController
public class DemoController {
	private static final Logger LOGGER = LogManager.getLogger(DemoController.class);
	@Autowired
	MetaInfoDao dao;
	
	@Autowired
	UserInfoDao userInfoDao;
	
	@RequestMapping(value = "/hello3", method = RequestMethod.GET)
	public HashMap<String, Object> test3() {
		HashMap<String, Object> map = new HashMap<>();
		map.put("abcaa", "ddeeed");
		map.put("abca1", "ddeeet");
		map.put("abca2", "ddeeee");
		map.put("abca3", "ddeee2");
		map.put("abca4", "ddeee4");
		return map;
	}

	@RequestMapping(value="/ajax", method=RequestMethod.GET, produces = "application/json; charset=utf8")
	@ResponseBody
	public void AjaxView(@RequestParam("id") String id, HttpServletResponse response)  {
	    String personJson;

	    Map metaIno = dao.selectMetaInfoList("ss"); 
	    
	    if(metaIno != null){
	        personJson = "{\"objectName\":\""+metaIno.get("objectName") 
	                    +"\",\"abbrName\":\""+metaIno.get("abbrName") 
	                    +"\",\"objRmk\":\""+metaIno.get("objRmk") 
	                    +"\",\"dataSize\":\""+metaIno.get("dataSize")+"\"}"; 
	    }
	    else{
	        personJson = "null";
	    }
	    try {
	        LOGGER.debug("tttttttttttttttttttt->" + personJson);
			response.setHeader("Content-Type", "application/xml");
			response.setContentType("text/xml;charset=UTF-8");
			response.setCharacterEncoding("utf-8");
			response.getWriter().print(personJson);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }   
	}
	
	@RequestMapping(value= "/ajax.seo", method=RequestMethod.GET, produces = "application/json; charset=utf8")
	@ResponseBody
	public void AjaxView1(@RequestParam("id") String id, HttpServletResponse response)  {
	    ObjectMapper mapper = new ObjectMapper();

	    Map metaIno = dao.selectMetaInfoList("ss"); 
	    try {
	        response.getWriter().print(mapper.writeValueAsString(metaIno));
	    } catch (IOException e) {
	        e.printStackTrace();
	    }   
	}
	
	@RequestMapping(value = "/ajax.abc", produces = "application/json;")
	public String testAjax() {

		String jsonResult = "{" +
			    "    \"name\": \"여자친구\", " +
			    "    \"members\": [ " +
			    "        \"소원\", " +
			    "        \"예린\", " +
			    "        \"은하\", " +
			    "        \"유주\", " +
			    "        \"신비\", " +
			    "        \"엄지\" " +
			    "    ], " +
			    "    \"albums\": { " +
			    "        \"EP 1집\": \"Season of Glass\", " +
			    "        \"EP 2집\": \"Flower Bud\", " +
			    "        \"EP 3집\": \"SNOWFLAKE\", " +
			    "        \"정규 1집\": \"LOL\", " +
			    "        \"EP 4집\": \"THE AWAKENING\" " +
			    "    } " +
			    "}";			

		return jsonResult ;
	}
	
	@RequestMapping(value = "/ajax123", produces = "application/json;")
	public void testAjax(HttpServletRequest request, HttpServletResponse response) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			
			LOGGER.debug("I'm comming to Ajax World==================================");
			StringBuffer jb = new StringBuffer();
	           String line = null;
	           try {
	               BufferedReader reader = request.getReader();
	               while ((line = reader.readLine()) != null) {
	                   jb.append(line);
	               }
	           } catch (Exception e) {
	        	   e.printStackTrace();
	           }
	           
	           ObjectMapper objectMapper = new ObjectMapper();
	           LOGGER.debug("I have received ==================================");
	           LOGGER.debug("I have received ==>" + jb.toString());				
	           List<User> users = objectMapper.readValue(jb.toString(), new TypeReference<List<User>>(){});
	           for(User user : users) {
	        	   LOGGER.debug("User ===>" +user.toString());
	           }           


		} catch (Exception e) {
		    e.printStackTrace();
		} 
		
	    try {
	    	
	    	List<Map<String,?>> arr = new ArrayList<Map<String,?>>();
	    	Map<String,String> m = new HashMap<>();
	    	m.put("id","ppp");
	    	m.put("name","����ѹ�");
	    	arr.add(m);
	    	Map<String,String> m1 = new HashMap<>();
	    	m1.put("id","ppp");
	    	m1.put("name","한글");
	    	arr.add(m1);
	    	
	    	response.setCharacterEncoding("UTF-8");
	    	response.setContentType("application/json; charset=UTF-8");
	        response.getWriter().print(mapper.writeValueAsString(arr));
	        
	    } catch (IOException e) {
	        e.printStackTrace();
	    }   
	}	
	
	/**
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/getAllUserInfo", produces = "application/json;")
	public void getAllUserInfo(HttpServletRequest request, HttpServletResponse response) {
		ObjectMapper mapper = new ObjectMapper();
	    try {
	    	
	    	LOGGER.debug("~~~~~~~~~~~~~~~등어 왔어 들어 왔어~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	    	List <UserInfo> lst = userInfoDao.selectAll();
	    	response.setCharacterEncoding("UTF-8");
	    	response.setContentType("application/json; charset=UTF-8");
	        response.getWriter().print(mapper.writeValueAsString(lst));
	        
	    } catch (IOException e) {
	        e.printStackTrace();
	    } finally {
	    }
	}
	
	/**
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/addUserInfo", produces = "application/json;")
	public void addUserInfo(HttpServletRequest request, HttpServletResponse response) {
		ObjectMapper mapper = new ObjectMapper();
	    try {
	    	
			StringBuffer jb = new StringBuffer();
			String line = null;
			BufferedReader reader = request.getReader();
			while ((line = reader.readLine()) != null) {
				jb.append(line);
			}
	    	
			LOGGER.debug("I have received ==================================");
			LOGGER.debug("I have received ==>" + jb.toString());
			UserInfo userInfo = mapper.readValue(jb.toString(), new TypeReference<UserInfo>() {
			});			
			
	    	int cnt = userInfoDao.add(userInfo);
	    	
	    	response.setCharacterEncoding("UTF-8");
	    	response.setContentType("application/json; charset=UTF-8");
	    	if(cnt> 0) {
	    		
		    	List <UserInfo> lst = userInfoDao.selectAll();
		        response.getWriter().print(mapper.writeValueAsString(lst)); 		
	    	} else {
	    		response.getWriter().print(mapper.writeValueAsString(ResultMsg.getInstance(false, "사용자 등록된내용이 없습니다.")));
	    	}
	    } catch (IOException e) {
	        e.printStackTrace();
	    } finally {
	    	
	    }
	}	
}



