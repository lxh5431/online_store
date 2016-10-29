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
	//���е�½���ж�
		   System.out.println(model);
			model = accountService.login(model);
			System.out.println(model);
			if(model == null) {
				session.put("error", "��½ʧ��");
				return "login";
			} else {
				//��¼�ɹ����Ƚ��û��洢��session��
				session.put("account", model);
				//����session��goURL�Ƿ���ֵ������ҳ�����ת
				if(session.get("goURL") == null) {
					return "aindex"; //������ҳ
				} else {
					return "goURL";
				}
			}
	}
	}

