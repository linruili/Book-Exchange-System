package com.Rayleigh.bookExchange.category.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.Rayleigh.bookExchange.category.domain.Category;

import cn.itcast.jdbc.TxQueryRunner;

public class CategoryDao
{
	private QueryRunner qr = new TxQueryRunner();

	public List<Category> findAll()
	{
		String sql = "select * from category";
		try
		{
			return qr.query(sql, new BeanListHandler<Category>(Category.class));
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public void add(Category category)
	{
		String sql = "insert into category values(?,?)";
		Object[] params = {category.getCid(), category.getCname()};
		try
		{
			qr.update(sql, params);
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	public void delete(String cid)
	{
		String sql = "delete from category where cid=?";
		try
		{
			qr.update(sql, cid);
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	public Category load(String cid)
	{
		String sql = "select * from category where cid=?";
		try
		{
			return qr.query(sql, new BeanHandler<Category>(Category.class), cid); 
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public void edit(Category category)
	{
		String sql = "update category set cname=? where cid=?";
		try
		{
			qr.update(sql, category.getCname(), category.getCid());
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}
