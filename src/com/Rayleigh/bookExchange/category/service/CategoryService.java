package com.Rayleigh.bookExchange.category.service;

import java.util.List;

import com.Rayleigh.bookExchange.book.dao.BookDao;
import com.Rayleigh.bookExchange.book.domain.Book;
import com.Rayleigh.bookExchange.category.dao.CategoryDao;
import com.Rayleigh.bookExchange.category.domain.Category;
import com.Rayleigh.bookExchange.category.web.servlet.CategoryException;

public class CategoryService
{
	private CategoryDao categoryDao = new CategoryDao();
	private BookDao bookDao = new BookDao();

	public List<Category> findAll()
	{
		return categoryDao.findAll();
	}

	public void add(Category category)
	{
		categoryDao.add(category);
	}

	public void delete(String cid) throws CategoryException
	{
		List<Book> bookList = bookDao.findByCategory(cid);
		if(bookList==null || bookList.size()==0)
			categoryDao.delete(cid);
		else
			throw new CategoryException("该分类还存在图书，无法删除");
	}

	public Category editPre(String cid)
	{
		return categoryDao.load(cid);
	}

	public void edit(Category category)
	{
		categoryDao.edit(category);
	}


}
