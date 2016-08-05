/**
 * 
 */
package gov.ssa.mode2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.json.JSONObject;

import gov.ssa.mode2.beans.UserBean;

/**
 * @author admin
 *
 */
public class SelectUser {

	/**
	 * 
	 */
	public SelectUser() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SelectUser selectUser = new SelectUser();
		UserBean user = selectUser.getUser("shuvo");
		
		// Code web app can do to convert bean to JSON
		JSONObject jsonObject = new JSONObject(user);
		
		
		System.out.println("done");
	}
	
	public UserBean getUser(String userID) {

		Connection c = null;
	    Statement stmt = null;
	    
	    UserBean userBean = null;
	    
	    try {
	      Class.forName("org.sqlite.JDBC");
	      c = DriverManager.getConnection("jdbc:sqlite:twitterClone.db");
	      c.setAutoCommit(false);
	      System.out.println("Opened database successfully");
	      
	      String SQL = "SELECT NAME, PASSWORD FROM USER "
	    		  	 + "  WHERE USERID = '" + userID + "'";

	      stmt = c.createStatement();
	      ResultSet rs = stmt.executeQuery(SQL);
	      if ( rs.next() ) {  
	    	  
	    	 userBean = new UserBean(); 
	    	 
	         String  name = rs.getString("NAME");
	         String  password = rs.getString("PASSWORD");
	         
	         userBean.setUserID(userID);
	         userBean.setName(name);
	         userBean.setPassword(password);
	         
	         System.out.println( "USERID = " + userID );
	         System.out.println( "NAME = " + name );
	         System.out.println( "PASSWORD = " + password );
	
	         System.out.println();
	      }
	      rs.close();
	      stmt.close();
	      c.close();
	    } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	    }
	    System.out.println("Operation done successfully");

		
		
		
		return userBean;
	}
}
		
	
		 	
