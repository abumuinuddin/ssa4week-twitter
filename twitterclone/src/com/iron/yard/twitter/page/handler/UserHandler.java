package com.iron.yard.twitter.page.handler;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.client.api.Request;

import com.iron.yard.twitter.clone.User;
import com.iron.yard.twitter.clone.service.TweetService;
import com.iron.yard.twitter.clone.service.UserService;

public class UserHandler {
	
	/**
	 * @param target
	 * @param response
	 * @throws IOException
	 */
	public static void handleTwitterLogIn(String target, HttpServletRequest request, HttpServletResponse response)
			throws IOException {

        	UserService userService = new UserService();
        	String userid = request.getParameter("userid");
        	String password = request.getParameter("password");
        	User user = userService.getUser(userid, password);
        	if (user !=null){
        		System.out.println("userid=" + user.getUserID());
            	response.addCookie(new Cookie("userid", user.getUserID()));
            	//response.addCookie (new Cookie("password", user.getPassword()));
            	response.sendRedirect("/web/FollowerTweets.html");
        	} else {
        		response.sendRedirect("/web/logon.html?Err=User Not Found");
        	}
        	System.out.println("User ID : " + request.getParameter("userid"));
        	

        	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
