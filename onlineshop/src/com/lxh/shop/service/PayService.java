package com.lxh.shop.service;

import java.util.Map;

import com.lxh.shop.model.BackData;
import com.lxh.shop.model.SendData;



public interface PayService {

	// �Ѽ��ܺ����Ϣ�洢��requestMap��
	public abstract Map<String, Object> saveDataToRequest(
			Map<String, Object> request, SendData sendData);
	
	//�ѷ��ص����ݽ��м��ܵõ����ģ����봫���������ıȽ�
	public boolean checkBackData(BackData backData);
}