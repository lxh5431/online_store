package com.lxh.shop.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lxh.shop.model.Roles;
import com.lxh.shop.service.RolesService;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:beans.xml")

public class RolesServiceImplTest {
	@Resource
	private RolesService rolesService;
	
	


	
	@Test
	public void testQueryJoinAccount() {
		for(Roles roles: rolesService.queryJoinUser("", 1, 2))
			System.out.println( roles + "," +roles.getName() );
		}
	}



