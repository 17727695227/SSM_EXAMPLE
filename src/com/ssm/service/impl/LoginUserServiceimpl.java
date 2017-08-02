package com.ssm.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssm.dao.LoginUserDAO;
import com.ssm.model.User;
import com.ssm.service.LoginUserService;

@Service("loginUserService")
public class LoginUserServiceimpl implements LoginUserService{

	@Resource
	private LoginUserDAO loginUserDao;
	
	@Override
	public User exit(User user) {
		return loginUserDao.exitUser(user);
	}

}
