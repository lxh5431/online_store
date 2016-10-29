package com.lxh.shop.service;

import com.lxh.shop.model.Account;

public interface AccountService extends BaseService<Account> {
	/*
	 * 只要添加AccountService本身需要的新的方法即可，公共方法已经在BaseService中了
	 */
	public Account login(Account account);

}
