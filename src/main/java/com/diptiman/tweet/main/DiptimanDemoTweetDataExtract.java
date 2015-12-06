package com.diptiman.tweet.main;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.diptiman.tweet.util.TwitterUtil;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;


public class DiptimanDemoTweetDataExtract {
	
	public static void main(String[] args) throws Exception{
		
		Twitter twitter = TwitterUtil.getTwitterInstance();
		Query query = new Query("#london");
		LocalDate date = LocalDate.of(2015, 12, 04);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
		String formattedDate = date.format(formatter);
		query.setSince(formattedDate);
		
		QueryResult result;
		do{
			result = twitter.search(query);
			List<Status> tweets = result.getTweets();
			for(Status tweet : tweets){
				System.out.println("@"+tweet.getUser().getScreenName() + "|||" + tweet.getText()+"|||"+ tweet.isRetweeted());
			}
		}while((query = result.nextQuery()) != null);
	}	
}
