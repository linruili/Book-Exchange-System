package com.Rayleigh.bookExchange.book.web.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Rayleigh.bookExchange.book.domain.Book;
import com.Rayleigh.bookExchange.book.service.BookService;
import com.Rayleigh.bookExchange.category.domain.Category;
import com.Rayleigh.bookExchange.category.service.CategoryService;

import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;

/**
 * Servlet implementation class AdminBookServleet
 */
@WebServlet("/admin/AdminBookServlet")
public class AdminBookServlet extends BaseServlet 
{
	private BookService bookService = new BookService();
	private CategoryService categoryService = new CategoryService();
	
	public String findAll(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException
	{
    	request.setAttribute("bookList", bookService.findAll());
		return "f:/adminjsps/admin/book/list.jsp";
	}
	
	public String load(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException
	{
    	request.setAttribute("book", bookService.load(request.getParameter("bid")));
    	request.setAttribute("categoryList", categoryService.findAll());
		return "f:/adminjsps/admin/book/desc.jsp";
	}
	
	public String addPre(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException
	{
		request.setAttribute("categoryList", categoryService.findAll());
		return "f:/adminjsps/admin/book/add.jsp";
	}
	
	public String delete(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException
	{
		String bid = request.getParameter("bid");
		bookService.delete(bid);
		return findAll(request, response);
	}
	
	public String edit(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException
	{
		Book book = CommonUtils.toBean(request.getParameterMap(), Book.class);
		Category category = CommonUtils.toBean(request.getParameterMap(), Category.class);
		book.setCategory(category);
		bookService.edit(book);
		return findAll(request, response);
	}


}
