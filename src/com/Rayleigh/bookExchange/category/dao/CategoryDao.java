package com.Rayleigh.bookExchange.category.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
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

}
