package com.lxh.shop.dao;

import com.lxh.shop.model.Account;


public interface AccountDao extends BaseDao<Account> {
	/*
	 * ֻҪ���AccountService������Ҫ���µķ������ɣ����������Ѿ���BaseService����
	 */
	public Account login(Account account);

}
