package com.Rayleigh.bookExchange.book.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.Rayleigh.bookExchange.book.domain.Book;

import cn.itcast.jdbc.TxQueryRunner;

public class BookDao
{
	private QueryRunner qr = new TxQueryRunner();
	
	public List<Book> findAll()
	{
		String sql = "select * from Book";
		try
		{
			return qr.query(sql, new BeanListHandler<Book>(Book.class));
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public List<Book> findByCategory(String cid)
	{
		String sql = "select * from Book where cid=?";
		try
		{
			return qr.query(sql, new BeanListHandler<Book>(Book.class), cid);
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public Book findByBid(String bid)
	{
		String sql = "select * from Book where bid=?";
		try
		{
			return qr.query(sql, new BeanHandler<Book>(Book.class), bid);
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}

}
