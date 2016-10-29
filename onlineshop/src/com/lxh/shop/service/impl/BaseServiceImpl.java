package com.lxh.shop.service.impl;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.lxh.shop.dao.AccountDao;
import com.lxh.shop.dao.BaseDao;
import com.lxh.shop.dao.CategoryDao;
import com.lxh.shop.dao.ForderDao;
import com.lxh.shop.dao.LogDao;
import com.lxh.shop.dao.ProductDao;
import com.lxh.shop.dao.RolesDao;
import com.lxh.shop.dao.SorderDao;
import com.lxh.shop.dao.UserDao;
import com.lxh.shop.service.BaseService;


/**
 * @Description TODO（公共模块的抽取）
 * @author Ni Shengwu
 *
 */
@SuppressWarnings("unchecked")
@Service("baseService ")
@Lazy(true)
public class BaseServiceImpl<T> implements BaseService<T> {

	private Class clazz; //clazz中存储了当前操作的类型，即泛型T
	
	
	public BaseServiceImpl() {
		System.out.println("this代表的是当前调用构造方法的对象" + this);
		System.out.println("获取当前this对象的父类信息" + this.getClass().getSuperclass());
		System.out.println("获取当前this对象的父类信息(包括泛型信息)" + this.getClass().getGenericSuperclass());
		//拿到泛型的参数类型
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		clazz = (Class)type.getActualTypeArguments()[0];
	}
	
	@PostConstruct
	public void init() {
		//根据clazz的类型，把不同的dao对象复制给baseDao对象
		String clazzName = clazz.getSimpleName();
		String clazzDao = clazzName.substring(0, 1).toLowerCase() 
				+ clazzName.substring(1) + "Dao"; //例如Account==>accountDao
		System.out.println(clazzDao);
		try {
//			Field clazzField = this.getClass().getField(clazzDao);
//			Field baseField = this.getClass().getField("baseDao");
			Field clazzField = this.getClass().getSuperclass().getDeclaredField(clazzDao);
			Field baseField = this.getClass().getSuperclass().getDeclaredField("baseDao");
			baseField.set(this, clazzField.get(this)); //baseDao就有值了
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	//@Resource //baseDao是泛型，不能够注入只能通过上面的init方法赋值
	protected BaseDao baseDao;
	@Resource
	protected AccountDao accountDao;
	@Resource
	protected CategoryDao categoryDao;
	@Resource
	protected ForderDao forderDao;
	@Resource
	protected ProductDao productDao;
	@Resource
	protected SorderDao sorderDao;
	@Resource
	protected UserDao userDao;
	@Resource
	protected LogDao logDao;
	@Resource
	protected RolesDao rolesDao;
	
	@Override
	public void save(T t) {
		baseDao.save(t);
	}

	@Override
	public void update(T t) {
		baseDao.update(t);	
	}

	@Override
	public void delete(int id) {
		baseDao.delete(id);
	}

	@Override
	public T get(int id) {
		return (T) baseDao.get(id);
	}

	@Override
	public List<T> query() {
		return baseDao.query();
	}

}
