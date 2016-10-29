package com.lxh.shop.service.impl;




import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lxh.shop.model.Log;
import com.lxh.shop.service.LogService;



@Transactional
@Service("logService")
public class LogServiceImpl extends BaseServiceImpl<Log> implements LogService {

	@Override
	public List<Log> query(String username, int page, int size) {
		// TODO Auto-generated method stub
		return logDao.query(username, page, size);
	}
	
}
