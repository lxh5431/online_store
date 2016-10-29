package com.lxh.shop.util.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

import org.springframework.stereotype.Component;

import com.lxh.shop.model.Category;
import com.lxh.shop.model.Product;
import com.lxh.shop.service.CategoryService;
import com.lxh.shop.service.ProductService;
/**
 * @Description: TODO(��������run����������������ҳ��Ʒ��Ϣ)
 * @author Ni Shengwu
 *
 */
@Component
public class ProductTimerTask extends TimerTask {
	
	@Resource
	private ProductService productService = null;
	@Resource
	private CategoryService categoryService = null;
	
	private ServletContext application = null;
	
	public void setApplication(ServletContext application) {
		this.application = application;
	}
	
	@Override
	//�ͼ���������Ŀ������ʱ�����ݳ�ʼ�����߼�һ��
	public void run() {
		System.out.println("----run----");
		List<List<Product>> bigList = new ArrayList<List<Product>>(); //bigList�д��һ��װ��Category���list
		// 1. ��ѯ���ȵ����
		for(Category category : categoryService.queryByHot(true)) {
			//�����ȵ����id��ȡ�Ƽ���Ʒ��Ϣ
			List<Product> lst = productService.querByCategoryId(category.getId());
			bigList.add(lst); //��װ��category��list�ŵ�bigList��
		}
		// 2. �Ѳ�ѯ��bigList����application���ö���
		application.setAttribute("bigList", bigList);
	}

}
