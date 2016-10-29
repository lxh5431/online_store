package com.lxh.shop.dao.impl;


import org.springframework.stereotype.Repository;

import com.lxh.shop.dao.ForderDao;
import com.lxh.shop.model.Forder;




@Repository("forderDao")
public class ForderDaoImpl extends BaseDaoImpl<Forder> implements ForderDao {

	@Override
	public void updateStatusById(int id, int sid) {
		String hql = "update Forder f set f.status.id=:sid where f.id=:id";
		getSession().createQuery(hql)
			.setInteger("sid", sid)
			.setInteger("id", id)
			.executeUpdate();
	}
	
}
