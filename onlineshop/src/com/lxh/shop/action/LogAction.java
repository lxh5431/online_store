package com.lxh.shop.action;

import java.io.ByteArrayInputStream;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.lxh.shop.model.Category;
import com.lxh.shop.model.Log;
import com.lxh.shop.model.User;
import com.lxh.shop.util.impl.Common;

@Controller("logAction")
@Scope("prototype")
@Aspect
//
@Component
public class LogAction extends BaseAction<Log> {
	@Around("execution(* com.lxh.service.impl.*.* (..))")
	public Object logAll(ProceedingJoinPoint point) {
		Object result = null;

		String methodName = point.getSignature().getName();
		String className = point.getTarget().getClass().getSimpleName();
		String user = null;
		Long start = 0L;
		Long end = 0L;
		String ip = null;
		// 执行方法名
		try {
			// 当前用户
			start = System.currentTimeMillis();
			result = point.proceed();
			end = System.currentTimeMillis();
			// ip
			ip = InetAddress.getLocalHost().getHostAddress();
			// 登录名
			user = Common.getAuthenticatedUsername();
			// System.out.println("Username:" +user);
		} catch (Throwable e) {
			// e.printStackTrace();
		}
		String name = null;
		// 操作范围
		if (className.indexOf("Resources") > -1) {
			name = "资源管理";
		} else if (className.indexOf("Roles") > -1) {
			name = "角色管理";
		} else if (className.indexOf("User") > -1) {
			name = "用户管理";
		}
		// 
		String opertype = "";
		if (methodName.indexOf("saveUserRole") > -1) {
			opertype = "update用户角色";
		} else if (methodName.indexOf("saveRoleRescours") > -1) {
			opertype = "update角色的权限";
		} else if (methodName.indexOf("save") > -1 || methodName.indexOf("save") > -1) {
			opertype = "save操作";
		} else if (methodName.indexOf("update") > -1 || methodName.indexOf("modify") > -1) {
			opertype = "update操作";
		} else if (methodName.indexOf("delete") > -1) {
			opertype = "delete操作";
		}
		if(!Common.isEmpty(opertype)&&className.indexOf("User")==-1){
			Long time = end - start;
			Log log = new Log();
			log.setUsername(user);
			log.setModule(name);
			log.setAction(opertype);
			log.setActionTime(time.toString());
			log.setUserIP(ip);
			logService.save(log);
		}
          return result;
          
	}
	public String queryby() {
		System.out.println("username:" + model.getUsername());
		System.out.println("page：" + page);
		System.out.println("rows：" + rows);
		
		//用来存储分页的数据
		pageMap = new HashMap<String, Object>();
		
		//根据关键字和分页的参数查询相应的数据
		List<Log> logList = logService.query(model.getUsername(), page, rows);
		pageMap.put("rows", logList); //存储为JSON格式
		//根据关键字查询总记录数
	   return "jsonMap";
	}
	
	
	
	
	
	public String deleteByIds() {
		System.out.println(ids);
	   logService.delete(model.getId());
		//如果删除成功就会往下执行，我们将"true"以流的形式传给前台
		inputStream = new ByteArrayInputStream("true".getBytes());
		return "stream";
	}
	
	public void save() {
		System.out.println(model);
	logService.save(model);
	}
	
	public void update() {
		System.out.println(model);
		logService.update(model);
	}
	
	public String query() {
		jsonList = logService.query();
		return "jsonList";
	}
}
