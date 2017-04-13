package com.team.weChat.demo.service;

import com.team.system.service.IBaseService;
import com.team.system.service.ProxySelf;
import com.team.weChat.demo.dto.User;

public interface IUserService extends IBaseService<User>,ProxySelf<IUserService>{

}
