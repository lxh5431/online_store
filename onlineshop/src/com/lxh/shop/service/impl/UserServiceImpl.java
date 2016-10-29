package com.lxh.shop.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lxh.shop.model.Roles;
import com.lxh.shop.model.User;
import com.lxh.shop.service.UserService;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements
		UserService {

	@Override
	public User login(User user) {
		return userDao.login(user);
	}

	@Override
	public List<User> queryJoinForder(String name, int page, int size) {
		// TODO Auto-generated method stub
		return userDao.queryJoinForder(name, page, size);
	}

	@Override
	public Long getCount(String name) {
		// TODO Auto-generated method stub
		return userDao.getCount(name);
	}

	@Override
	public void deleteByIds(String ids) {
		// TODO Auto-generated method stub
		userDao.deleteByIds(ids);
		
	}

	@Override
	public Roles findbyUserRole(String userId) {
		// TODO Auto-generated method stub
		return userDao.findbyUserRole(userId);
	}

}
