package com.iron.yard.twitter.clone;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.AbstractHandler;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.server.handler.HandlerCollection;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.json.JSONObject;

import com.iron.yard.twitter.clone.service.TweetService;
import com.iron.yard.twitter.page.handler.UserHandler;

public class TwitterClone extends AbstractHandler {

    @Override
    public void handle(String target, Request baseRequest, HttpServletRequest request, 
                HttpServletResponse response)
    
            throws IOException, ServletException {
        System.out.println("Target: " + target);
        // Declare response encoding and types
        response.setContentType("text/html; charset=utf-8");

        // Declare response status code
        response.setStatus(HttpServletResponse.SC_OK);
        
//        response.getWriter().println("<h1>Home page</h1>"); 
    	
        // Inform jetty that this request has now been handled
        baseRequest.setHandled(true); 
 
        // Write back response
     
        if (target.equalsIgnoreCase("/getLatestFeeds")) {
        	TweetService tweetService = new TweetService();
        	List<JSONObject> tweets = tweetService.getTopTenTweetsJSON();
        	response.getWriter().println(tweets.toString()); 
        }
        
		if (target.equalsIgnoreCase("/twitterLogIn")) {
			UserHandler.handleTwitterLogIn(target, response);
		}

    }


   
    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);
        
        ResourceHandler resource_handler = new ResourceHandler();
        resource_handler.setDirectoriesListed(true);
        resource_handler.setWelcomeFiles(new String[]{ "/web/index.html" });
 
        resource_handler.setResourceBase(".");
        
        HandlerCollection handlers = new HandlerCollection();        
        HandlerList list = new HandlerList();
        list.setHandlers(new Handler[] { new TwitterClone(),new DefaultHandler() });
        handlers.setHandlers(new Handler[] { resource_handler,  list });
        server.setHandler(handlers);

        server.start();
        server.join();
         
    }

}