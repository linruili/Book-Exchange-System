package com.Rayleigh.bookExchange.user.web.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Rayleigh.bookExchange.user.domain.User;
import com.Rayleigh.bookExchange.user.service.UserException;
import com.Rayleigh.bookExchange.user.service.UserService;

import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;

/**
 * Servlet implementation class UserServlet
 * 
 */

@WebServlet("/UserServlet")
public class UserServlet extends BaseServlet 
{
	private UserService userService = new UserService();
	
	public String regist(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException
	{
		User form = CommonUtils.toBean(request.getParameterMap(), User.class);
		form.setUid(CommonUtils.uuid());
		Map<String, String> errors = new HashMap<String, String>();
		String username = form.getUsername();
		String password = form.getPassword();
		if(username==null || username.trim()=="")
			errors.put("username", "用户名格式错误");
		if(password==null || password.trim()=="")
			errors.put("password", "密码格式错误");
		
		if(errors.size()>0)
		{
			request.setAttribute("errors", errors);
			request.setAttribute("form", form);
			return "f:/jsps/user/regist.jsp";     
		}
		
		try
		{
			userService.regist(form);
			request.setAttribute("msg", "恭喜，注册成功");
			return "f:/jsps/msg.jsp";
		} catch (UserException e)
		{
			request.setAttribute("msg", e.getMessage());
			request.setAttribute("form", form);
			return "f:/jsps/user/regist.jsp";
		}
	}
	
	public String login(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException
	{
		User form = CommonUtils.toBean(request.getParameterMap(), User.class);
		try
		{
			User user = userService.login(form);
			request.getSession().setAttribute("session_user", user);
			return "r:/index.jsp";
		} catch (UserException e)
		{
			request.setAttribute("msg", e.getMessage());
			request.setAttribute("form", form);
			return "f:/jsps/user/login.jsp";
		}
	}
	
	public String quit(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException
	{
		request.getSession().invalidate();
		return "r:/index.jsp";
	}
	
	

	


}
