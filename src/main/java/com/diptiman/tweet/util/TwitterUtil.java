package com.diptiman.tweet.util;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterUtil {
	
	private final static String CONSUMER_KEY = "<YOUR KEY>";
	private final static String CONSUMER_KEY_SECRET = "<YOUR KEY>";
	private final static String ACCESS_TOKEN = "<YOUR KEY>";
	private final static String ACCESS_TOKEN_SECRET = "<YOUR KEY>";
	
	public static Twitter getTwitterInstance(){
		ConfigurationBuilder cb = null;
		TwitterFactory tf = null;
		Twitter twitter = null;
		try{
			cb = new ConfigurationBuilder();
			cb.setDebugEnabled(true)
				.setOAuthConsumerKey(CONSUMER_KEY)
				.setOAuthConsumerSecret(CONSUMER_KEY_SECRET)
				.setOAuthAccessToken(ACCESS_TOKEN)
				.setOAuthAccessTokenSecret(ACCESS_TOKEN_SECRET);
			
			tf = new TwitterFactory(cb.build());
			twitter = tf.getInstance();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return(twitter);
	}
}
