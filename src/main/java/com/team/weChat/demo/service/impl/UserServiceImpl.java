package com.team.weChat.demo.service.impl;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.team.system.service.impl.BaseServiceImpl;
import com.team.weChat.demo.dto.User;
import com.team.weChat.demo.service.IUserService;

@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements IUserService{

	@Override
	public User login(User u) {
		System.out.println(u.getName()+" 恭喜您登陆成功！");
		u.setLastUpdateDate(new Date());
		return u;
	}

}
