package com.team.weChat.common.service.impl;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.team.weChat.common.service.SysUserManager;

@Service
public class SysUserManagerImpl implements SysUserManager {
	
	@Cacheable("getName")
	@Override
	public String getName(String id) {
		System.out.println("第一次获取key： "+id);
		return "二狗蛋儿";
	}

 
}
