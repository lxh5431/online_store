package com.lxh.shop.service.impl;

import org.springframework.stereotype.Service;

import com.lxh.shop.model.Account;
import com.lxh.shop.service.AccountService;


/**
 * @Description TODO（模块自身的业务逻辑）
 * @author Ni Shengwu
 *
 */
@Service("accountService")
public class AccountServiceImpl extends BaseServiceImpl<Account> implements AccountService {

	@Override
	public Account login(Account account) {
		// TODO Auto-generated method stub
		return accountDao.login(account);
	}

	/*
	 * 只需实现AccountService接口中新增的方法即可，公共方法已经在BaseServiceImpl中实现了
	 */
	
	//管理登陆功能
}
