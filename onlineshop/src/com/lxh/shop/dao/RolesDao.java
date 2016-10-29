package com.lxh.shop.dao;


import java.util.List;

import com.lxh.shop.model.Roles;





public interface RolesDao extends BaseDao<Roles>{
	public List<Roles> queryJoinUser(String name, int page, int size);	
}
