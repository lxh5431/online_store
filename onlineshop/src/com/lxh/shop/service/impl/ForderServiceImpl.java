package com.lxh.shop.service.impl;


import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.lxh.shop.model.Forder;
import com.lxh.shop.model.Sorder;
import com.lxh.shop.service.ForderService;



@Service("forderService")
public class ForderServiceImpl extends BaseServiceImpl<Forder> implements ForderService {

	@Override
	public BigDecimal cluTotal(Forder forder) {

		BigDecimal total = new BigDecimal(0.00);
		for(Sorder sorder : forder.getSorders()) {
			total = total.add(sorder.getPrice().multiply(new BigDecimal(sorder.getNumber())));
		}
		return total;
	}

	@Override
	public void updateStatusById(int id, int sid) {
		forderDao.updateStatusById(id, sid);
	}
	
}
