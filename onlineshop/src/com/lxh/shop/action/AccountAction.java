package com.lxh.shop.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.lxh.shop.model.Account;



@Controller("accountAction")
@Scope("prototype")
public class AccountAction extends BaseAction<Account> {
	


		
	

	public String query() {
		jsonList = accountService.query();
		return "jsonList";
	}

	public String login() {
	//进行登陆的判断
		   System.out.println(model);
			model = accountService.login(model);
			System.out.println(model);
			if(model == null) {
				session.put("error", "登陆失败");
				return "login";
			} else {
				//登录成功，先将用户存储到session中
				session.put("account", model);
				//根据session中goURL是否有值而决定页面的跳转
				if(session.get("goURL") == null) {
					return "aindex"; //跳到首页
				} else {
					return "goURL";
				}
			}
	}
	}

