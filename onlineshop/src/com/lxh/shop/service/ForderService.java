package com.lxh.shop.service;

import java.math.BigDecimal;

import com.lxh.shop.model.Forder;

public interface ForderService extends BaseService<Forder> {
	//���㹺���ܼ۸�
	public BigDecimal cluTotal(Forder forder);
	//���ݶ�����ţ����¶���״̬
	public void updateStatusById(int id, int sid);
}
