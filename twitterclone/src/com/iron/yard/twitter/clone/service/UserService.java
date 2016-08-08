package com.iron.yard.twitter.clone.service;

/**
 * 
 */

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import com.iron.yard.twitter.clone.Follower;
import com.iron.yard.twitter.clone.User;
import com.iron.yard.twitter.clone.db.DBConnection;

/**
 * @author Shuvo Ahmed
 *
 */
public class UserService
{
	/**
	 * 
	 */
	public UserService()
	{
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		
		UserService userService = new UserService();
		//List<Tweet> followersTweet = followerService.getFollowerTweets("shuvo");
		//List<Follower> followers = followerService.getFollowers("shuvo");
		System.out.println(userService.getUser("shuvo", "shuvopassword").getName());
	}

	public JSONObject getUserJSON(String userID, String userPassword)
	{
		User user = getUser(userID, userPassword);
		JSONObject jsonObject = new JSONObject(user);
		
		return jsonObject;
	}

	public User getUser(String userID, String userPassword)
	{
	    User user = new User();
		try
	    {
	    	Connection c = DBConnection.getConnection();
	      
	    	String SQL = "SELECT USERID, NAME, PASSWORD FROM USER "
	    	    	 + "  WHERE USERID = '" + userID + "' AND PASSWORD = '" + userPassword + "'";
	    		  	 
	      Statement stmt = c.createStatement();
	      ResultSet rs = stmt.executeQuery(SQL);
	      while ( rs.next() )
	      {
	         user.setUserID(rs.getString("USERID"));
	         user.setName(rs.getString("NAME"));
	         user.setPassword(rs.getString("PASSWORD"));
	         
	         //System.out.println( "USERID = " + follower.getUserID());
	         //System.out.println( "FOLLOWERID = " + follower.getFollowerID());
	         //System.out.println();
	         break;
	      }
	      
	      rs.close();
	      stmt.close();
	    }
	    catch ( Exception e )
	    {
	      e.printStackTrace();
	    }

	    return user;
	}
}