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
 * @Description TODO������ģ��ĳ�ȡ��
 * @author Ni Shengwu
 *
 */
@SuppressWarnings("unchecked")
@Service("baseService ")
@Lazy(true)
public class BaseServiceImpl<T> implements BaseService<T> {

	private Class clazz; //clazz�д洢�˵�ǰ���������ͣ�������T
	
	
	public BaseServiceImpl() {
		System.out.println("this������ǵ�ǰ���ù��췽���Ķ���" + this);
		System.out.println("��ȡ��ǰthis����ĸ�����Ϣ" + this.getClass().getSuperclass());
		System.out.println("��ȡ��ǰthis����ĸ�����Ϣ(����������Ϣ)" + this.getClass().getGenericSuperclass());
		//�õ����͵Ĳ�������
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		clazz = (Class)type.getActualTypeArguments()[0];
	}
	
	@PostConstruct
	public void init() {
		//����clazz�����ͣ��Ѳ�ͬ��dao�����Ƹ�baseDao����
		String clazzName = clazz.getSimpleName();
		String clazzDao = clazzName.substring(0, 1).toLowerCase() 
				+ clazzName.substring(1) + "Dao"; //����Account==>accountDao
		System.out.println(clazzDao);
		try {
//			Field clazzField = this.getClass().getField(clazzDao);
//			Field baseField = this.getClass().getField("baseDao");
			Field clazzField = this.getClass().getSuperclass().getDeclaredField(clazzDao);
			Field baseField = this.getClass().getSuperclass().getDeclaredField("baseDao");
			baseField.set(this, clazzField.get(this)); //baseDao����ֵ��
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	//@Resource //baseDao�Ƿ��ͣ����ܹ�ע��ֻ��ͨ�������init������ֵ
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
