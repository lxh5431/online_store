package com.lxh.shop.service.impl;

import org.springframework.stereotype.Service;

import com.lxh.shop.model.Account;
import com.lxh.shop.service.AccountService;


/**
 * @Description TODO��ģ�������ҵ���߼���
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
	 * ֻ��ʵ��AccountService�ӿ��������ķ������ɣ����������Ѿ���BaseServiceImpl��ʵ����
	 */
	
	//�����½����
}
