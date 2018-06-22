package com.Rayleigh.bookExchange.user.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.Rayleigh.bookExchange.user.domain.User;

import cn.itcast.jdbc.TxQueryRunner;

public class UserDao
{
	private QueryRunner qr = new TxQueryRunner();
	
	public User findByUsername(String username)
	{
		String sql = "select * from tb_user where username=?";
		try
		{
			return qr.query(sql, new BeanHandler<User>(User.class), username);
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public void add(User user)
	{
		String sql = "insert into tb_user values(?,?,?,?)";
		Object[] params = {user.getUid(), user.getUsername(), user.getPassword(), user.getMoney()};
		try
		{
			qr.update(sql, params);
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

}
