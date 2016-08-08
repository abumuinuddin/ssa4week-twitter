package com.iron.yard.twitter.clone;

/**
 * 
 * @author Shuvo Ahmed
 *
 */
public class Tweet
{
	public Tweet()
	{
		// TODO Auto-generated constructor stub
	}
	
	private String userID;
	private String tweet;
	private String date;

	public String getUserID()
	{
		return userID;
	}
	
	public void setUserID(String userID)
	{
		this.userID = userID;
	}
	
	public String getTweet()
	{
		return tweet;
	}
	
	public void setTweet(String tweet)
	{
		this.tweet = tweet;
	}
	
	public String getDate()
	{
		return date;
	}
	public void setDate(String date)
	{
		this.date = date;
	}
}