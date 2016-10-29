package com.lxh.shop.service;

import java.util.List;

import com.lxh.shop.model.Roles;


public interface RolesService  extends BaseService<Roles>{
	public List<Roles> queryJoinUser(String name, int page, int size);

}
