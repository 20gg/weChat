package com.team.weChat.demo.mapper;

import java.util.List;

import com.team.mybatis.common.Mapper;
import com.team.weChat.demo.dto.User;

public interface UserMapper extends Mapper<User> {
	void add(User user);
	
	List<User> getAllUser();
}
