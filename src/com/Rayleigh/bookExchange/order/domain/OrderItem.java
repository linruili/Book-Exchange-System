package com.Rayleigh.bookExchange.order.domain;

import java.util.Date;

public class OrderItem
{
	private String oid;
	private Date ordertime;
	private String bname;
	private String author;
	private String stateDes;
	private String image;
	public String getImage()
	{
		return image;
	}
	public void setImage(String image)
	{
		this.image = image;
	}
	public String getOid()
	{
		return oid;
	}
	public void setOid(String oid)
	{
		this.oid = oid;
	}
	public Date getOrdertime()
	{
		return ordertime;
	}
	public void setOrdertime(Date ordertime)
	{
		this.ordertime = ordertime;
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
	public String getStateDes()
	{
		return stateDes;
	}
	public void setStateDes(String stateDes)
	{
		this.stateDes = stateDes;
	}

}
