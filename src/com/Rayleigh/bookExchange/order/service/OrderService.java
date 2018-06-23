package com.Rayleigh.bookExchange.order.service;

import java.util.ArrayList;
import java.util.List;

import com.Rayleigh.bookExchange.book.dao.BookDao;
import com.Rayleigh.bookExchange.book.domain.Book;
import com.Rayleigh.bookExchange.order.dao.OrderDao;
import com.Rayleigh.bookExchange.order.domain.Order;
import com.Rayleigh.bookExchange.order.domain.OrderItem;

public class OrderService
{
	private OrderDao orderDao = new OrderDao();
	private BookDao bookDao = new BookDao();
	
	public void add(Order order)
	{
		orderDao.addOrder(order);
	}

	public void deleteByOid(String oid)
	{
		orderDao.deleteByOid(oid);
	}

	public List<OrderItem> showOrders(String uid)
	{
		List<Order> orderList = orderDao.loadOrderByUid(uid);
		List<OrderItem> orderItemList = new ArrayList<OrderItem>();
		for(Order order:orderList)
		{
			OrderItem orderItem = new OrderItem();
			orderItem.setOid(order.getOid());
			orderItem.setOrdertime(order.getOrdertime());
			if(order.getState()==0)
				orderItem.setStateDes("�û�������");
			else
				orderItem.setStateDes("�û������");
			Book book = bookDao.findByBid(order.getBid());
			orderItem.setAuthor(book.getAuthor());
			orderItem.setBname(book.getBname());
			orderItem.setImage(book.getImage());
			orderItemList.add(orderItem);
		}
		return orderItemList;
	}

}
