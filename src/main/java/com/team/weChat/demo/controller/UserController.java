package com.team.weChat.demo.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team.weChat.demo.dto.User;
import com.team.weChat.demo.service.IUserService;

@Controller
public class UserController {
	private final static Logger log = Logger.getLogger(UserController.class);
	
	@Autowired
	private IUserService userService;
	
	@RequestMapping("/index")
	@ResponseBody
	public String index() {
		User u = new User();
		u.setName("张书丹");
		u.setPassword("123321");
		userService.login(u);
		return "index";
	}
	
	@RequestMapping("/home")
	@ResponseBody
	public String home() {

		return "home";
	}
}
