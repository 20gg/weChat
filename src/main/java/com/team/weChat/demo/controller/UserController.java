package com.team.weChat.demo.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
	private final static Logger log = Logger.getLogger(UserController.class);
	
	@RequestMapping("/index")
	@ResponseBody
	public String index() {
		log.info("成功获取你的名字：");
		String gg= "niasf ";
		System.out.println(gg);
		return "index";
	}
	
	@RequestMapping("/home")
	@ResponseBody
	public String home() {

		return "home";
	}
}
