package com.lxh.shop.action;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.lxh.shop.model.Roles;
import com.lxh.shop.model.User;



@Controller("userAction")
@Scope("prototype")
public class UserAction extends BaseAction<User> {
	

	public String queryJoinForder() {
		System.out.println("name:" + model.getName());
		System.out.println("page：" + page);
		System.out.println("rows：" + rows);
		
		//用来存储分页的数据
		pageMap = new HashMap<String, Object>();
		
		//根据关键字和分页的参数查询相应的数据
		List<User> user = userService.queryJoinForder(model.getName(), page, rows);
		pageMap.put("rows", user); //存储为JSON格式
		//根据关键字查询总记录数
		Long total = userService.getCount(model.getName());
//		System.out.println(total);
		pageMap.put("total", total); //存储为JSON格式

		return "jsonMap";
	}
	 public String findbyUserRole(String userId){
		 System.out.println(ids);
			userService.findbyUserRole(userId);
			//如果删除成功就会往下执行，我们将"true"以流的形式传给前台
			inputStream = new ByteArrayInputStream("true".getBytes());
		    return "stream";
		 
	 }
	
	public String deleteByIds() {
		System.out.println(ids);
		userService.deleteByIds(ids);
		//如果删除成功就会往下执行，我们将"true"以流的形式传给前台
		inputStream = new ByteArrayInputStream("true".getBytes());
		return "stream";
	}
	
	public void save() {
		System.out.println(model);
		userService.save(model);
	}
	
	public void update() {
		System.out.println(model);
		userService.update(model);
	}
	
	public String query() {
		jsonList = userService.query();
		return "jsonList";
	}
	

public String login() {
		//进行登陆的判断
	System.out.println(model);
		model = userService.login(model);
		System.out.println(model);
		if(model == null) {
			session.put("error", "登陆失败");
			return "login";
		} else {
			//登录成功，先将用户存储到session中
			session.put("user", model);
			//根据session中goURL是否有值而决定页面的跳转
			if(session.get("goURL") == null) {
				return "index"; //跳到首页
			} else {
				return "goURL";
			}
		}
	}
}
