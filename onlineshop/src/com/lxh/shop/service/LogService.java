package com.lxh.shop.service;

import java.util.List;

import com.lxh.shop.model.Log;

public interface LogService extends BaseService<Log>{
	public List<Log> query(String username, int page, int size);
	
	
	
}
