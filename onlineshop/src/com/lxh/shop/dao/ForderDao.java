package com.lxh.shop.dao;

import com.lxh.shop.model.Forder;



public interface ForderDao extends BaseDao<Forder> {
	//���ݶ�����ţ����¶���״̬
	public void updateStatusById(int id, int sid);
}
