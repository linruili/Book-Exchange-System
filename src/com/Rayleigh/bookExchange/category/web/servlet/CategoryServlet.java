package com.Rayleigh.bookExchange.category.web.servlet;

import cn.itcast.servlet.BaseServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Rayleigh.bookExchange.category.service.CategoryService;

/**
 * Servlet implementation class CategoryServlet
 */
@WebServlet("/CategoryServlet")
public class CategoryServlet extends BaseServlet 
{
	private CategoryService categoryService = new CategoryService();
	
	public String findAll(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException
	{
		request.setAttribute("categoryList", categoryService.findAll());
		return "f:/jsps/left.jsp";
		

	}
    

}
