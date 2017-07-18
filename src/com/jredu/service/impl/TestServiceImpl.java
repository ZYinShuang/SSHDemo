package com.jredu.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jredu.dao.UserDao;
import com.jredu.entity.User;
import com.jredu.service.TestService;

@Service
public class TestServiceImpl implements TestService {

	@Resource
	private UserDao dao;
	
	@Override
	public User test(User user) {
		// TODO Auto-generated method stub
		return dao.findUser(user);
	}

}
