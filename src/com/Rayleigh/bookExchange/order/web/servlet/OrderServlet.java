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
		request.setAttribute("msg", "申请成功，请到于1周内携带实体书至实体店进行置换");
		return "f:/jsps/msgBody.jsp";
	}
	
	public String cancel(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException
	{
		String oid = request.getParameter("oid");
		orderService.deleteByOid(oid);
		return "f:/jsps/book/list.jsp";
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
			request.setAttribute("msg", "请先登录");
			return "f:/jsps/msgBody.jsp";
		}
		order.setOwner(user);
		String bid = request.getParameter("bid");
		order.setBid(bid);
		
		BookDao bookDao = new BookDao();
		Book book = bookDao.findByBid(bid);
		
		orderService.add(order);
		request.setAttribute("order", order);
		request.setAttribute("book", book);
		return "jsps/order/desc.jsp";
	}
	
	public String showOrders(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException
	{
		User user = (User)request.getSession().getAttribute("session_user");
		if(user == null)
		{
			request.setAttribute("msg", "请先登录");
			return "f:/jsps/msgBody.jsp";
		}
		request.setAttribute("orderItemList", orderService.showOrders(user.getUid()));
		return "jsps/order/list.jsp";
	}
	

}
