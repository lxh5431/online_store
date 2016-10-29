package com.lxh.shop.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lxh.shop.dao.SorderDao;
import com.lxh.shop.model.Sorder;



@Repository("sorderDao")
@SuppressWarnings("unchecked")
public class SorderDaoImpl extends BaseDaoImpl<Sorder> implements
		SorderDao {
	
	@Override
	public List<Object> querySale(int number) {
		//不用fecth查出来的就是两项
		String hql = "select s.name, sum(s.number) from Sorder s join s.product group by s.product.id";
		return getSession().createQuery(hql) //
			.setFirstResult(0) //
			.setMaxResults(number) //
			.list();
	}
}
