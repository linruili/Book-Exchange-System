package com.Rayleigh.bookExchange.category.service;

import java.util.List;

import com.Rayleigh.bookExchange.category.dao.CategoryDao;
import com.Rayleigh.bookExchange.category.domain.Category;

public class CategoryService
{
	private CategoryDao categoryDao = new CategoryDao();

	public List<Category> findAll()
	{
		return categoryDao.findAll();
	}

}
