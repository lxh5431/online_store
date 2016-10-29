package com.lxh.shop.test;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lxh.shop.model.User;
import com.lxh.shop.service.UserService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:beans.xml")
public class UserServiceImplTest {

	@Resource
	private UserService userService;
	
	


	
	@Test
	public void testQueryJoinAccount() {
		for(User c : userService.queryJoinForder("", 1, 2)) {
			System.out.println(c + "," + c.getUsername());
		}
	}
	
	@Test
	public void testGetCount() {
		System.out.println(userService.getCount(""));
	}

	@Test
	public void testLogin(){
		System.out.println(userService.login(new User("2016001","123456")));
	}
	
	}
	

