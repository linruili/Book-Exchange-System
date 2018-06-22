package com.Rayleigh.bookExchange.order.service;

import com.Rayleigh.bookExchange.order.dao.OrderDao;
import com.Rayleigh.bookExchange.order.domain.Order;

public class OrderService
{
	private OrderDao orderDao = new OrderDao();
	
	public void add(Order order)
	{
		orderDao.addOrder(order);
	}

	public void deleteByOid(String oid)
	{
		orderDao.deleteByOid(oid);
	}

}
