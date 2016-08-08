package com.iron.yard.twitter.clone;

/**
 * 
 * @author Shuvo Ahmed
 *
 */
public class User
{
	public User()
	{
	}
	
	private String userID;
	private String name;
	private String password;
	
	public String getUserID()
	{
		return userID;
	}
	
	public void setUserID(String userID)
	{
		this.userID = userID;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}
}