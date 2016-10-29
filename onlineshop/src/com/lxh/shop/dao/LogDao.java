package com.lxh.shop.dao;

import java.util.List;

import com.lxh.shop.model.Log;




public interface LogDao extends BaseDao<Log> {
	public List<Log> query(String username, int page, int size);

}
