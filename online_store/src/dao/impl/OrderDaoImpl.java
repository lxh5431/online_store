package dao.impl;

import java.awt.print.Book;
import java.util.List;
import java.util.Set;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import dao.OrderDao;
import entity.Goods;
import entity.Order;
import entity.OrderItem;
import entity.User;
import utils.JdbcUtils;

public class OrderDaoImpl implements OrderDao {

	@Override
	public void add(Order order) {
		try{QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
		//1. ��order�Ļ�����Ϣ���浽order��
		String sql = "insert into orders(id,ordertime,price,state,user_id) values(?,?,?,?,?)";
		Object params[] = {order.getId(), order.getOrdertime(), order.getPrice(), order.isState(), order.getUser().getId()};
        runner.update(sql, params);
        Set<OrderItem>set=order.getOrderitems();
        for(OrderItem item:set){
        	sql="insert into orderitem(id,quantity,price,order_id,goods_id)values(?,?,?,?,?)";
        	params = new Object[]{item.getId(), item.getQuantity(), item.getPrice(), order.getId(), item.getGoods().getId()};
			runner.update(sql, params);
        }
        }catch(Exception e){
        	e.printStackTrace();
        	throw new RuntimeException(e);
        }
	}

	@Override
	public Order find(String id) {
		// TODO Auto-generated method stub
		try{
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			//1.�ҳ������Ļ�����Ϣ
			String sql = "select * from orders where id=?";
			Order order = (Order) runner.query(sql, id, new BeanHandler(Order.class));
			//2.�ҳ����������еĶ�����
			sql = "select * from orderitem where order_id=?";
			List<OrderItem> list = (List<OrderItem>) runner.query(sql, id, new BeanListHandler(OrderItem.class));
			for(OrderItem item : list){
				sql = "select book.* from orderitem,goods where orderitem.id=? and orderitem.goods_id=goods.id";
				Goods goods = (Goods) runner.query(sql, item.getId(), new BeanHandler(Goods.class));
				item.setGoods(goods);
			}
			//���ҳ��Ķ�����Ž�order
			order.getOrderitems().addAll(list);
			//3.�ҳ����������ĸ��û�
			sql = "select * from orders,user where orders.id=? and orders.user_id=user.id";
			User user = (User) runner.query(sql, order.getId(), new BeanHandler(User.class));
			order.setUser(user);
			return order;
			
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	

	@Override
	public List<Order> getAll(boolean state) {
		try{
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select * from orders where state=?";
			List<Order> list = (List<Order>) runner.query(sql, state, new BeanListHandler(Order.class));
			for(Order order : list){				
				//�ҳ���ǰ���������ĸ��û�
				sql = "select user.* from orders,user where orders.id=? and orders.user_id=user.id";
				User user = (User) runner.query(sql, order.getId(), new BeanHandler(User.class));
				order.setUser(user);
			} 
			return list;
		} catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public void update(Order order) {
		try{
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "update orders set state=? where id=?";
			Object params[] = {order.isState(), order.getId()};
			runner.update(sql, params);
		} catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	

	@Override
	public List<Order> getAll(boolean state, String userid) {
		// TODO Auto-generated method stub
		try{
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select * from orders where state=? and orders.user_id=?";
			Object params[] = {state, userid};
			List<Order> list = (List<Order>) runner.query(sql, params, new BeanListHandler(Order.class));
			//�����и�user�ӵ�list��
			for(Order order : list){
				sql = "select * from user where user.id=?";
				User user = (User) runner.query(sql, userid, new BeanHandler(User.class));
				order.setUser(user);
			}
			return list;
		} catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Order> getAllOrder(String userid) {
		// TODO Auto-generated method stub
		try{
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select * from orders where user_id=?";
			List<Order> list = (List<Order>) runner.query(sql, userid, new BeanListHandler(Order.class));
			//�����и�user�ӵ�List��ȥ
			for(Order order : list){
				sql = "select * from user where id=?";
				User user = (User) runner.query(sql, userid, new BeanHandler(User.class));
				order.setUser(user);
			}
			return list;
		} catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
