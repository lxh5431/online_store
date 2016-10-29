package com.lxh.shop.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lxh.shop.model.Product;
import com.lxh.shop.service.ProductService;
/**
 * @Description TODO��ģ�������ҵ���߼���
 * 
 *
 */
@SuppressWarnings("unchecked")
@Service("productService")
public class ProductServiceImpl extends BaseServiceImpl<Product> implements ProductService {

	@Override
	public List<Product> queryJoinCategory(String name, int page, int size) {
		return productDao.queryJoinCategory(name, page, size);
	}
	
	@Override
	public Long getCount(String name) {
		return productDao.getCount(name);
	}

	@Override
	public void deleteByIds(String ids) {
		productDao.deleteByIds(ids);
	}

	@Override
	public List<Product> querByCategoryId(int cid) {
		return productDao.querByCategoryId(cid);
	}

}
