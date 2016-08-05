/**
 * 
 */
package gov.ssa.mode2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import gov.ssa.mode2.beans.TweetBean;

/**
 * @author admin
 *
 */
public class SelectTweets {

	/**
	 * 
	 */
	public SelectTweets() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SelectTweets selectUser = new SelectTweets();
		List<TweetBean> tweetBeanList = selectUser.getTweet("shuvo");
		
	}
	
	public List<TweetBean> getTweet(String userID) {

		Connection c = null;
	    Statement stmt = null;
	    
	    List<TweetBean> tweetList = new ArrayList<TweetBean>();
	   
	    
	    try {
	      Class.forName("org.sqlite.JDBC");
	      c = DriverManager.getConnection("jdbc:sqlite:twitterClone.db");
	      c.setAutoCommit(false);
	      System.out.println("Opened database successfully");
	      
	      String SQL = "SELECT tweet, date FROM TWEETS "
	    		  	 + "  WHERE USERID = '" + userID + "'"
	    		  	 + "  ORDER BY DATE DESC"	    		  	 
	    		  	 + "  LIMIT 10";	    		  	 

	      stmt = c.createStatement();
	      ResultSet rs = stmt.executeQuery(SQL);
	      while ( rs.next() ) {
	    	  
	    	 TweetBean tweetBean = new TweetBean();
	    	    	 
	         String  tweet = rs.getString("TWEET");
	         String  date = rs.getString("DATE");
	         
	         tweetBean.setUserID(userID);
	         tweetBean.setTweet(tweet);
	         tweetBean.setDate(date);
	         
	         tweetList.add(tweetBean);
	         
	         System.out.println( "USERID = " + userID );
	         System.out.println( "TWEET = " + tweet );
	         System.out.println( "DATE = " + date );
	
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

		
		
		
		return tweetList;
	}
}
		
	
		 	
