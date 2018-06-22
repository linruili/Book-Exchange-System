package com.Rayleigh.bookExchange.user.service;

import com.Rayleigh.bookExchange.user.dao.UserDao;
import com.Rayleigh.bookExchange.user.domain.User;

public class UserService
{
	private UserDao userDao = new UserDao();
	
	public void regist(User form) throws UserException
	{
		User user = userDao.findByUsername(form.getUsername());
		if(user != null) 
			throw new UserException("用户名已被注册");
		
		userDao.add(form);
	}
	
	public User login(User form) throws UserException
	{
		User user = userDao.findByUsername(form.getUsername());
		if(user == null)
			throw new UserException("用户名不存在");
		if(!user.getPassword().equals(form.getPassword()))
				throw new UserException("密码错误");
		return user;
	}

}
