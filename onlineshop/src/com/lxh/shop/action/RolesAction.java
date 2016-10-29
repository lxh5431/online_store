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
		System.out.println("page��" + page);
		System.out.println("rows��" + rows);
		
		//�����洢��ҳ������
		pageMap = new HashMap<String, Object>();
		
		//���ݹؼ��ֺͷ�ҳ�Ĳ�����ѯ��Ӧ������
		List<Roles> roles = rolesService.queryJoinUser(model.getName(), page, rows);
		pageMap.put("rows", roles); //�洢ΪJSON��ʽ
		

		return "jsonMap";
	}
	
	public String deleteByIds() {
		System.out.println(ids);
	      rolesService.delete(model.getId());
		//���ɾ���ɹ��ͻ�����ִ�У����ǽ�"true"��������ʽ����ǰ̨
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
