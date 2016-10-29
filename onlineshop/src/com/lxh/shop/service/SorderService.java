package com.lxh.shop.service;

import java.util.List;

import com.lxh.shop.model.Forder;
import com.lxh.shop.model.Product;
import com.lxh.shop.model.Sorder;

public interface SorderService extends BaseService<Sorder> {
	//��ӹ���������µĹ��ﳵ
	public Forder addSorder(Forder forder, Product product);
	//����Ʒ����ת��Ϊ������
	public Sorder productToSorder(Product product);
	//������Ʒid������������Ʒ����
	public Forder updateSorder(Sorder sorder, Forder forder);
	//��ѯ�ȵ���Ʒ��������
	public List<Object> querySale(int number);
}
