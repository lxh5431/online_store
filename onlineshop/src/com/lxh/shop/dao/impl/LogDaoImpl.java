package com.lxh.shop.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lxh.shop.dao.LogDao;
import com.lxh.shop.model.Log;

@Repository("logDao")
public class LogDaoImpl extends BaseDaoImpl<Log> implements LogDao{

	@SuppressWarnings("unchecked")
	@Override
	public List<Log> query(String username, int page, int size) {
		// TODO Auto-generated method stub
		String hql = "from Log l  where l.username like :username";
		return getSession().createQuery(hql)
				.setString("username", "%" + username + "%")
				.setFirstResult((page-1) * size) //从第几个开始显示
				.setMaxResults(size) //显示几个
				.list();
	}

}
