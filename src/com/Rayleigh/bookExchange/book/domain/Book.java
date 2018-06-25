package com.Rayleigh.bookExchange.book.domain;

import com.Rayleigh.bookExchange.category.domain.Category;

public class Book
{
	private String bid;
	private String bname;
	private String author;
	private String image;
	private Category category;
	private boolean del;
	public boolean isDel()
	{
		return del;
	}
	public void setDel(boolean del)
	{
		this.del = del;
	}
	public String getBid()
	{
		return bid;
	}
	public void setBid(String bid)
	{
		this.bid = bid;
	}
	public String getBname()
	{
		return bname;
	}
	public void setBname(String bname)
	{
		this.bname = bname;
	}
	public String getAuthor()
	{
		return author;
	}
	public void setAuthor(String author)
	{
		this.author = author;
	}
	public String getImage()
	{
		return image;
	}
	public void setImage(String image)
	{
		this.image = image;
	}
	public Category getCategory()
	{
		return category;
	}
	public void setCategory(Category category)
	{
		this.category = category;
	}
	
}
