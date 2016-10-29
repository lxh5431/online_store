package com.lxh.shop.test;
import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lxh.shop.model.Category;
import com.lxh.shop.model.Product;
import com.lxh.shop.service.CategoryService;
import com.lxh.shop.service.ProductService;

import net.sf.json.JSONSerializer;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:beans.xml")
public class ProductServiceImplTest {

	@Resource
	private ProductService productService;
	@Resource 
	private CategoryService categoryService;

	@Test
	public void testQueryJoinCategory() {
		for(Product p : productService.queryJoinCategory("", 1, 5)) {
			System.out.println(p + "," + p.getCategory());
//			p.getCategory().setAccount(null);
			System.out.println(JSONSerializer.toJSON(p));//¿¡º”‘ÿŒ Ã‚
		}
	}
	
	/*@Test
	public void testCount() {
		System.out.println(productService.getCount(""));
	}*/
	
/*	@Test
	public void testSave() {
		Product t = new Product(null, "test2", new BigDecimal(23.22), "da8b3609-8ecf-4157-8075-a6e9028bd64d.jpg", "cccc", "cccc", null, true, true);
		Category c = (Category) categoryService.queryJoinAccount("∂˘ÕØ–›œ–", 1, 1).get(0);
		c.setType(null);
		c.setAccount(null);
		c.setHot(null);
		t.setCategory(c);
		System.out.println(t);
		productService.save(t);
	}
	
	@Test
	public void testQuerByCategoryId() {
		List<Product> product = productService.querByCategoryId(2);
		for(Product p : product) {
			System.out.println(p);
		}
	}
	
	@Test
	public void get() {
		System.out.println(productService.get(1));
		System.out.println(productService.get(1));
	}
}*/
}