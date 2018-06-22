package com.Rayleigh.bookExchange.order.web.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Rayleigh.bookExchange.book.dao.BookDao;
import com.Rayleigh.bookExchange.book.domain.Book;
import com.Rayleigh.bookExchange.order.domain.Order;
import com.Rayleigh.bookExchange.order.service.OrderService;
import com.Rayleigh.bookExchange.user.domain.User;

import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/OrderServlet")
public class OrderServlet extends BaseServlet 
{
	private OrderService orderService = new OrderService();
	
	public String confirm(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException
	{
		return "jsps/book/list.jsp";
	}
	
	public String cancel(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException
	{
		String oid = request.getParameter("oid");
		orderService.deleteByOid(oid);
		return "jsps/book/list.jsp";
	}
	
	public String createOrder(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException
	{
		Order order = new Order();
		order.setOid(CommonUtils.uuid());
		order.setState(0);
		order.setOrdertime(new Date());
		User user = (User)request.getSession().getAttribute("session_user");
		if(user == null)
		{
			request.setAttribute("msg", "���ȵ�¼");
			return "jsps/book/list.jsp";
		}
		order.setOwner(user);
		String bid = request.getParameter("bid");
		order.setBid(bid);
		
		BookDao bookDao = new BookDao();
		Book book = bookDao.findByBid(bid);
		
		orderService.add(order);
		request.setAttribute("order", order);
		request.setAttribute("book", book);
		return "jsps/order/list.jsp";
	}
	

}
