package com.lxh.shop.service;

import com.lxh.shop.model.Account;

public interface AccountService extends BaseService<Account> {
	/*
	 * ֻҪ���AccountService������Ҫ���µķ������ɣ����������Ѿ���BaseService����
	 */
	public Account login(Account account);

}
