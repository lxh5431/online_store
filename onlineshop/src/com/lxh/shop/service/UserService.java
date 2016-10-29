package com.lxh.shop.service;

import java.util.List;

import com.lxh.shop.model.Roles;
import com.lxh.shop.model.User;

public interface UserService extends BaseService<User> {
	//�û���½���ɹ����ظ�User
	public User login(User user);
	//���û��������û�����Ϣ
		public List<User> queryJoinForder(String name, int page, int size);
		public Long getCount(String name);
		//����idsɾ��������¼
	   public void deleteByIds(String ids);
	   public Roles findbyUserRole(String userId);
}
