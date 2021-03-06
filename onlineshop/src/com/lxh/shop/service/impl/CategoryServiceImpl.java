package com.lxh.shop.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lxh.shop.model.Category;
import com.lxh.shop.service.CategoryService;


/**
 * @Description TODO（模块自身的业务逻辑）
 * 
 */

@Service("categoryService")
public class CategoryServiceImpl extends BaseServiceImpl<Category> implements CategoryService {

	@Override
	public List<Category> queryJoinAccount(String type, int page, int size) {
		return categoryDao.queryJoinAccount(type, page, size);
	}

	@Override
	public Long getCount(String type) {
		return categoryDao.getCount(type);
	}

	@Override
	public void deleteByIds(String ids) {
		categoryDao.deleteByIds(ids);
	}

	@Override
	public List<Category> queryByHot(boolean hot) {
		return categoryDao.queryByHot(hot);
	}
}
