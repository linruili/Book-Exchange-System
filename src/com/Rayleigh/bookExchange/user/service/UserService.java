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
			throw new UserException("�û����ѱ�ע��");
		
		userDao.add(form);
	}
	
	public User login(User form) throws UserException
	{
		User user = userDao.findByUsername(form.getUsername());
		if(user == null)
			throw new UserException("�û���������");
		if(!user.getPassword().equals(form.getPassword()))
				throw new UserException("�������");
		return user;
	}

}
