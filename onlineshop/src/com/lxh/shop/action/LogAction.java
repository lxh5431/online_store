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
		// ִ�з�����
		try {
			// ��ǰ�û�
			start = System.currentTimeMillis();
			result = point.proceed();
			end = System.currentTimeMillis();
			// ip
			ip = InetAddress.getLocalHost().getHostAddress();
			// ��¼��
			user = Common.getAuthenticatedUsername();
			// System.out.println("Username:" +user);
		} catch (Throwable e) {
			// e.printStackTrace();
		}
		String name = null;
		// ������Χ
		if (className.indexOf("Resources") > -1) {
			name = "��Դ����";
		} else if (className.indexOf("Roles") > -1) {
			name = "��ɫ����";
		} else if (className.indexOf("User") > -1) {
			name = "�û�����";
		}
		// 
		String opertype = "";
		if (methodName.indexOf("saveUserRole") > -1) {
			opertype = "update�û���ɫ";
		} else if (methodName.indexOf("saveRoleRescours") > -1) {
			opertype = "update��ɫ��Ȩ��";
		} else if (methodName.indexOf("save") > -1 || methodName.indexOf("save") > -1) {
			opertype = "save����";
		} else if (methodName.indexOf("update") > -1 || methodName.indexOf("modify") > -1) {
			opertype = "update����";
		} else if (methodName.indexOf("delete") > -1) {
			opertype = "delete����";
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
		System.out.println("page��" + page);
		System.out.println("rows��" + rows);
		
		//�����洢��ҳ������
		pageMap = new HashMap<String, Object>();
		
		//���ݹؼ��ֺͷ�ҳ�Ĳ�����ѯ��Ӧ������
		List<Log> logList = logService.query(model.getUsername(), page, rows);
		pageMap.put("rows", logList); //�洢ΪJSON��ʽ
		//���ݹؼ��ֲ�ѯ�ܼ�¼��
	   return "jsonMap";
	}
	
	
	
	
	
	public String deleteByIds() {
		System.out.println(ids);
	   logService.delete(model.getId());
		//���ɾ���ɹ��ͻ�����ִ�У����ǽ�"true"��������ʽ����ǰ̨
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
