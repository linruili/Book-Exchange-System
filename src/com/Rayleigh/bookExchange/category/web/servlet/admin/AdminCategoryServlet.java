package com.Rayleigh.bookExchange.category.web.servlet.admin;

import cn.itcast.servlet.BaseServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Rayleigh.bookExchange.category.service.CategoryService;

/**
 * Servlet implementation class AdminCategoryServlet
 */
@WebServlet("/admin/AdminCategoryServlet")
public class AdminCategoryServlet extends BaseServlet 
{
    private CategoryService categoryService = new CategoryService();
    
    public String findAll(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException
	{
		request.setAttribute("categoryList", categoryService.findAll());
		return "f:/adminjsps/admin/category/list.jsp";
	}
}
