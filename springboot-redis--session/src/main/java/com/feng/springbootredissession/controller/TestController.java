package com.feng.springbootredissession.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/")
public class TestController {

	@RequestMapping(value="/getSessionId")
	@ResponseBody
	public String getSessionId(HttpServletRequest request){
		
		Object o = request.getSession().getAttribute("1");
		if(o == null){
			o = "spring boot 牛逼了!!!有端口"+request.getLocalPort()+"生成";
			request.getSession().setAttribute("1", 2);
		}
		
		return "端口=" + request.getLocalPort() +  " sessionId=" + request.getSession().getId() +"<br/>"+o;
	}
	
}
