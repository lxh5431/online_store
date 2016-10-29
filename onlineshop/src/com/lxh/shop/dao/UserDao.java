package com.lxh.shop.dao;

import java.util.List;

import com.lxh.shop.model.Roles;
import com.lxh.shop.model.User;

public interface UserDao extends BaseDao<User> {
	//���û��������û�����Ϣ
	public List<User> queryJoinForder(String name, int page, int size);
	 public Long getCount(String name);
	//�û���½���ɹ����ظ�User
	  public User login(User user);
	//����idsɾ��������¼
		public void deleteByIds(String ids);
		public Roles findbyUserRole(String userId);
}
