package com.Rayleigh.bookExchange.book.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;

import com.Rayleigh.bookExchange.book.domain.Book;
import com.Rayleigh.bookExchange.category.domain.Category;

import cn.itcast.commons.CommonUtils;
import cn.itcast.jdbc.TxQueryRunner;

public class BookDao
{
	private QueryRunner qr = new TxQueryRunner();
	
	public List<Book> findAll()
	{
		String sql = "select * from Book where del=false";
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
		String sql = "select * from Book where cid=? and del=false";
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
			Map<String, Object> map = qr.query(sql, new MapHandler(), bid);
			Category category = CommonUtils.toBean(map, Category.class);
			Book book = CommonUtils.toBean(map, Book.class);
			book.setCategory(category);
			return book;
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public void add(Book book)
	{
		try 
		{
			String sql = "insert into book values(?,?,?,?,?,?)";
			Object[] params = {book.getBid(), book.getBname(), book.getAuthor(),
					book.getImage(), book.getCategory().getCid(), book.isDel()};
			qr.update(sql, params);
		} catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public void delete(String bid) 
	{
		try 
		{
			String sql = "update book set del=true where bid=?";
			qr.update(sql, bid);
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

	public void edit(Book book)
	{
		try {
			String sql = "update book set bname=?, author=?, image=?, cid=? where bid=?";
			Object[] params = {book.getBname(), book.getAuthor(), book.getImage(), 
					book.getCategory().getCid(), book.getBid()};
			qr.update(sql, params);
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
