package com.lxh.shop.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lxh.shop.model.Roles;
import com.lxh.shop.service.RolesService;

@Service("rolesService")
public class RolesServiceImpl extends BaseServiceImpl<Roles> implements RolesService{

	@Override
	public List<Roles> queryJoinUser(String name, int page, int size) {
		// TODO Auto-generated method stub
		return rolesDao.queryJoinUser(name, page, size);
	}
	
	

}
