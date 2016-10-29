package com.lxh.shop.dao.impl;



import java.util.List;

import org.springframework.stereotype.Repository;

import com.lxh.shop.dao.RolesDao;
import com.lxh.shop.model.Roles;




@Repository("rolesDao")
public class RolesDaoImpl extends BaseDaoImpl<Roles> implements RolesDao
{
	@SuppressWarnings("unchecked")
	@Override
	public List<Roles> queryJoinUser(String name, int page, int size) {
		String hql = "from Roles r  where r.name like :name";
		return getSession().createQuery(hql)
				.setString("name", "%" + name + "%")
				.setFirstResult((page-1) * size) //从第几个开始显示
				.setMaxResults(size) //显示几个
				.list();
	}
	
}
