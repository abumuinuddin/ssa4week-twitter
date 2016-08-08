package com.iron.yard.twitter.clone.db;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 
 * @author Shuvo Ahmed
 *
 */
public final class DBConnection {

	public static Connection conn = null;
	
	public static Connection getConnection()
	{
		if(conn == null)
		{
			try
			{
				Class.forName("org.sqlite.JDBC");
				conn = DriverManager.getConnection("jdbc:sqlite:twitterClone.db");
			}
			catch(Exception e)
			{
				e.printStackTrace();
				//System.out.println( e.getClass().getName() + ": " + e.getMessage() );
		    }
		    System.out.println("Opened database successfully...");
		}
		return conn;
	}
	
	public static void closeConnection(Connection connection)
	{
		try
		{
			if(connection != null)
			{
				connection.close();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		System.out.println("Database Connection Closed Successfully...");
	}
}