package com.lxh.shop.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lxh.shop.service.SorderService;

import net.sf.json.JSONSerializer;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:beans.xml")
public class SorderServiceImplTest {

	@Resource 
	private SorderService sorderService;

	@Test
	public void queryJoinCategory() {
		System.out.println(JSONSerializer.toJSON(sorderService.querySale(5)));
		for(Object temp : sorderService.querySale(5)) {
			System.out.println(temp);
		}
	}
}
