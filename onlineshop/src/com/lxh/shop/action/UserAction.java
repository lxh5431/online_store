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
		System.out.println("page��" + page);
		System.out.println("rows��" + rows);
		
		//�����洢��ҳ������
		pageMap = new HashMap<String, Object>();
		
		//���ݹؼ��ֺͷ�ҳ�Ĳ�����ѯ��Ӧ������
		List<User> user = userService.queryJoinForder(model.getName(), page, rows);
		pageMap.put("rows", user); //�洢ΪJSON��ʽ
		//���ݹؼ��ֲ�ѯ�ܼ�¼��
		Long total = userService.getCount(model.getName());
//		System.out.println(total);
		pageMap.put("total", total); //�洢ΪJSON��ʽ

		return "jsonMap";
	}
	 public String findbyUserRole(String userId){
		 System.out.println(ids);
			userService.findbyUserRole(userId);
			//���ɾ���ɹ��ͻ�����ִ�У����ǽ�"true"��������ʽ����ǰ̨
			inputStream = new ByteArrayInputStream("true".getBytes());
		    return "stream";
		 
	 }
	
	public String deleteByIds() {
		System.out.println(ids);
		userService.deleteByIds(ids);
		//���ɾ���ɹ��ͻ�����ִ�У����ǽ�"true"��������ʽ����ǰ̨
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
		//���е�½���ж�
	System.out.println(model);
		model = userService.login(model);
		System.out.println(model);
		if(model == null) {
			session.put("error", "��½ʧ��");
			return "login";
		} else {
			//��¼�ɹ����Ƚ��û��洢��session��
			session.put("user", model);
			//����session��goURL�Ƿ���ֵ������ҳ�����ת
			if(session.get("goURL") == null) {
				return "index"; //������ҳ
			} else {
				return "goURL";
			}
		}
	}
}
