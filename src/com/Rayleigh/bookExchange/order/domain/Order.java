package com.Rayleigh.bookExchange.order.domain;

import java.util.Date;

import com.Rayleigh.bookExchange.book.domain.Book;
import com.Rayleigh.bookExchange.user.domain.User;

public class Order
{
	private String oid;
	private Date ordertime;
	private int state;//0:置换进行中  1:置换完成
	private User owner;
	private String bid;
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
	public int getState()
	{
		return state;
	}
	public void setState(int state)
	{
		this.state = state;
	}
	public User getOwner()
	{
		return owner;
	}
	public void setOwner(User owner)
	{
		this.owner = owner;
	}
	public String getBid()
	{
		return bid;
	}
	public void setBid(String bid)
	{
		this.bid = bid;
	}
	

}
