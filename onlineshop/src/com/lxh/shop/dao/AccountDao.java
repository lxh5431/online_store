package com.lxh.shop.dao;

import com.lxh.shop.model.Account;


public interface AccountDao extends BaseDao<Account> {
	/*
	 * 只要添加AccountService本身需要的新的方法即可，公共方法已经在BaseService中了
	 */
	public Account login(Account account);

}
