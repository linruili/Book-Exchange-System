package com.Rayleigh.bookExchange.order.web.servlet.admin;

import cn.itcast.servlet.BaseServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Rayleigh.bookExchange.order.service.OrderService;
import com.Rayleigh.bookExchange.user.domain.User;

/**
 * Servlet implementation class AdminOrderServlet
 */
@WebServlet("/admin/AdminOrderServlet")
public class AdminOrderServlet extends BaseServlet 
{
	private OrderService orderService = new OrderService();
	
	public String findAll(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException
	{
		request.setAttribute("orderItemList", orderService.findAll());
		return "/adminjsps/admin/order/list.jsp";
	}
	
	public String edit(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException
	{
		String oid = request.getParameter("oid");
		orderService.confirmOrder(oid);
		return findAll(request, response);
	}

}
