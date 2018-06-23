package com.Rayleigh.bookExchange.user.domain;

public class User
{
	private String uid;
	private String username;
	private String password;
	private int money;//0:未缴纳保证金   1:已缴纳保证金
	
	public String getUid()
	{
		return uid;
	}
	public void setUid(String uid)
	{
		this.uid = uid;
	}
	public String getUsername()
	{
		return username;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public int getMoney()
	{
		return money;
	}
	public void setMoney(int money)
	{
		this.money = money;
	}
	

}
