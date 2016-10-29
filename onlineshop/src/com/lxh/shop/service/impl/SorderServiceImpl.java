package com.lxh.shop.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lxh.shop.model.Forder;
import com.lxh.shop.model.Product;
import com.lxh.shop.model.Sorder;
import com.lxh.shop.service.SorderService;


@Service("sorderService")
@SuppressWarnings("unchecked")
public class SorderServiceImpl extends BaseServiceImpl<Sorder> implements
		SorderService {

	@Override
	public Forder addSorder(Forder forder, Product product) {
		boolean isHave = false; //���������û���ظ�������
		//�õ���ǰ�Ĺ�����
		Sorder sorder = productToSorder(product);
		//�жϵ�ǰ�������Ƿ��ظ�������ظ�����������������
		for(Sorder old : forder.getSorders()) {
			if(old.getProduct().getId().equals(sorder.getProduct().getId())) {
				//���������ظ���������������
				old.setNumber(old.getNumber() + sorder.getNumber());
				isHave = true;
				break;
			}
		}
		//��ǰ�������ڹ��ﳵ�в����ڣ������Ӽ���
		if(!isHave) {
			//�����������ӹ�����֮ǰ���Ƚ����������빺�ﳵ�Ĺ��������Ǵ�ʱforder.idΪnull��
			//����������ʱ��������⹺�ﳵ������⹺�����ʱ�����������
			sorder.setForder(forder);
			forder.getSorders().add(sorder);
		}
		
		return forder;
	}

	@Override
	public Sorder productToSorder(Product product) {
		Sorder sorder = new Sorder();
		sorder.setName(product.getName());
		sorder.setNumber(1);
		sorder.setPrice(product.getPrice());
		sorder.setProduct(product);
		return sorder;
	}

	@Override
	public Forder updateSorder(Sorder sorder, Forder forder) {
		for(Sorder temp : forder.getSorders()) {
			if(temp.getProduct().getId().equals(sorder.getProduct().getId())) {
				temp.setNumber(sorder.getNumber());
			}
		}
		return forder;
	}
	
	@Override
	public List<Object> querySale(int number) {
		return sorderDao.querySale(number);
	}
}