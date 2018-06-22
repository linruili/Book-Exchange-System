package com.Rayleigh.bookExchange.book.service;

import java.util.List;

import com.Rayleigh.bookExchange.book.dao.BookDao;
import com.Rayleigh.bookExchange.book.domain.Book;

public class BookService
{
	private BookDao bookDao = new BookDao();
	
	public List<Book> findAll()
	{
		return bookDao.findAll();
	}

	public List<Book> findByCategory(String cid)
	{
		return bookDao.findByCategory(cid);
	}

	public Book load(String bid)
	{
		return bookDao.findByBid(bid);
	}

}
