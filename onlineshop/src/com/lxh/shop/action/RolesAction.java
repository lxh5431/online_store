package com.lxh.shop.action;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.lxh.shop.model.Roles;
import com.lxh.shop.model.User;



@Controller("rolesAction")
@Scope("prototype")
public class RolesAction extends BaseAction<Roles>{
	public String queryJoinUser() {
		System.out.println("name:" + model.getName());
		System.out.println("page：" + page);
		System.out.println("rows：" + rows);
		
		//用来存储分页的数据
		pageMap = new HashMap<String, Object>();
		
		//根据关键字和分页的参数查询相应的数据
		List<Roles> roles = rolesService.queryJoinUser(model.getName(), page, rows);
		pageMap.put("rows", roles); //存储为JSON格式
		

		return "jsonMap";
	}
	
	public String deleteByIds() {
		System.out.println(ids);
	      rolesService.delete(model.getId());
		//如果删除成功就会往下执行，我们将"true"以流的形式传给前台
		inputStream = new ByteArrayInputStream("true".getBytes());
		return "stream";
	}
	
	public void save() {
		System.out.println(model);
		rolesService.save(model);
	}
	
	public void update() {
		System.out.println(model);
		rolesService.update(model);
	}
	
	public String query() {
		jsonList = rolesService.query();
		return "jsonList";
	}

}
