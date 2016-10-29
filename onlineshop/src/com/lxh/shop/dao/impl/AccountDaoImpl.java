package com.lxh.shop.dao.impl;

import org.springframework.stereotype.Repository;

import com.lxh.shop.dao.AccountDao;
import com.lxh.shop.model.Account;
import com.lxh.shop.model.User;
@Repository("accountDao")
public class AccountDaoImpl extends BaseDaoImpl<Account> implements AccountDao {
	

	@Override
	public Account login(Account account) {
		String hql = "from Account a where a.login=:login and a.pass=:pass";
		return (Account) getSession().createQuery(hql) //
			.setString("login", account.getLogin()) //
			.setString("pass", account.getPass()) //
			.uniqueResult();
	}


}
