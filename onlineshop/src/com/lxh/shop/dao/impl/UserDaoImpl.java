package com.lxh.shop.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lxh.shop.dao.UserDao;
import com.lxh.shop.model.Product;
import com.lxh.shop.model.Roles;
import com.lxh.shop.model.User;



@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {
	
	@SuppressWarnings("unchecked")
	@Override
	public List<User> queryJoinForder(String name, int page, int size) {
		String hql = "from User u  where u.name like :name";
		return getSession().createQuery(hql)
				.setString("name", "%" + name + "%")
				.setFirstResult((page-1) * size) //从第几个开始显示
				.setMaxResults(size) //显示几个
				.list();
	}
	
	@Override
	public Long getCount(String name) {
		String hql = "select count(u) from User u where u.name like :name";
		return (Long) getSession().createQuery(hql)
			.setString("name", "%" + name + "%")
			.uniqueResult(); //返回一条记录:总记录数
	}
	
	
	
	@Override
	public User login(User user) {
		String hql = "from User u where u.username=:username and u.pass=:pass";
		return (User) getSession().createQuery(hql) //
			.setString("username", user.getUsername()) //
			.setString("pass", user.getPass()) //
			.uniqueResult();
	}

	@Override
	public void deleteByIds(String ids) {
		// TODO Auto-generated method stub
		String hql = "delete from User u where u.id in (" + ids + ")";
		getSession().createQuery(hql).executeUpdate();
		
		
	}

	@Override
	public Roles findbyUserRole(String userId) {
		// TODO Auto-generated method stub
		String hql="from role r where r.id in (SELECT role_id FROM user_role WHERE user_id=#{id})";
	 return (Roles) getSession().createQuery(hql)
				.setString("id", "%" + userId + "%")
				.uniqueResult(); //返回一条记录:总记录数
		}
	
	}


