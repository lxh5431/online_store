package com.lxh.shop.dao;

import java.util.List;

import com.lxh.shop.model.Roles;
import com.lxh.shop.model.User;

public interface UserDao extends BaseDao<User> {
	//按用户名查找用户名信息
	public List<User> queryJoinForder(String name, int page, int size);
	 public Long getCount(String name);
	//用户登陆，成功返回该User
	  public User login(User user);
	//根据ids删除多条记录
		public void deleteByIds(String ids);
		public Roles findbyUserRole(String userId);
}
