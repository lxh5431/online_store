package com.lxh.shop.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lxh.shop.action.AccountAction;
import com.lxh.shop.model.Account;

import com.lxh.shop.service.AccountService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:beans.xml")

public class AccountServiceImplTest {
	/*@Resource
	private AccountService accountService;
	@Test
	public void testLogin(){
		System.out.println(accountService.login(new Account("admin","admin")));
	}*/
	@Resource
	private AccountAction accountAction;
	@Test
	public void testLogin(){
		System.out.println(accountAction.login());
	}
	

}
