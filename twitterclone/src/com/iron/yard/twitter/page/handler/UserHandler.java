package com.iron.yard.twitter.page.handler;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import com.iron.yard.twitter.clone.service.TweetService;

public class UserHandler {
	
	/**
	 * @param target
	 * @param response
	 * @throws IOException
	 */
	public static void handleTwitterLogIn(String target, HttpServletResponse response)
			throws IOException {

        	TweetService tweetService = new TweetService();
        	//List<JSONObject> tweets = tweetService.getTopTenTweetsJSON();
        	//response.getWriter().println(tweets.toString()); 
        	response.addCookie(new Cookie("userid", "abu"));
        	response.addCookie (new Cookie("password", "abu123"));
        	response.sendRedirect("/web/index.html");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
