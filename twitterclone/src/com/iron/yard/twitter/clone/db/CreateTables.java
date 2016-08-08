package com.iron.yard.twitter.clone.db;

import java.sql.Connection;
import java.sql.Statement;

/**
 * 
 * @author Shuvo Ahmed
 *
 */
public class CreateTables
{
  public void start(Connection conn)
  {
    try
    {
    	Statement stmt = conn.createStatement();
    	
    	//String dropUserTableSql = "DROP TABLE USER";
    	//String dropTweetTableSql = "DROP TABLE TWEET";
    	//String dropFollowerTableSql = "DROP TABLE FOLLOWER";
    	
    	//stmt.executeUpdate("DROP TABLE USER");
    	//stmt.executeUpdate("DROP TABLE TWEET");
    	//stmt.executeUpdate("DROP TABLE FOLLOWER");
    	
    	String createUserTableSql = "CREATE TABLE USER " +
                   "(USERID 		CHAR(25)	PRIMARY KEY     NOT NULL," +
                   " NAME           CHAR(50)    				NOT NULL, " + 
                   " PASSWORD		CHAR(50)					NOT NULL)"; 

    	String createTweetTableSql = "CREATE TABLE TWEET " +
                "(USERID 		CHAR(25)	NOT NULL," +
                " TWEET         CHAR(140)   NOT NULL, " + 
                " DATE			TEXT		NOT NULL)"; 

    	String createFollowerTableSql = "CREATE TABLE FOLLOWER " +
                "(USERID 		CHAR(25)	NOT NULL," +
                " FOLLOWERID    CHAR(140)   NOT NULL)"; 
    	
    	
    	stmt.executeUpdate(createUserTableSql);
    	stmt.executeUpdate(createTweetTableSql);
    	stmt.executeUpdate(createFollowerTableSql);
    	
    	stmt.close();
    }
    catch(Exception e)
    {
    	e.printStackTrace();
    }
    System.out.println("Tables created successfully");
  }
}