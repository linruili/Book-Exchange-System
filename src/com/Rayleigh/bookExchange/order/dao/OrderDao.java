package com.Rayleigh.bookExchange.order.dao;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.Rayleigh.bookExchange.order.domain.Order;

import cn.itcast.jdbc.TxQueryRunner;

public class OrderDao
{
	private QueryRunner qr = new TxQueryRunner();
	
	public void addOrder(Order order)
	{
		String sql = "insert into orders values(?,?,?,?,?)";
		Timestamp timestamp = new Timestamp(order.getOrdertime().getTime()); 
		Object[] params = {order.getOid(), timestamp, order.getState(), 
				order.getOwner().getUid(), order.getBid()};
		
		try
		{
			qr.update(sql, params);
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		
	}

	public void deleteByOid(String oid)
	{
		String sql = "delete from orders where oid=?";
		try
		{
			qr.update(sql, oid);
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		
	}

	public List<Order> loadOrderByUid(String uid)
	{
		String sql = "select * from orders where uid=?";
		try
		{
			List<Order> orderList = qr.query(sql, new BeanListHandler<Order>(Order.class), uid);
			return orderList;
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return null;
		
	}

}
