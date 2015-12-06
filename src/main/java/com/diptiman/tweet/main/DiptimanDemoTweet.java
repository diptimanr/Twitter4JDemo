package com.diptiman.tweet.main;

import com.diptiman.tweet.util.TwitterUtil;

import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;


public class DiptimanDemoTweet {

	public static void main(String[] args) throws Exception{
		
		Twitter twitter = TwitterUtil.getTwitterInstance();
		twitter.updateStatus("Updating from Diptiman Tweet Demo");
		System.out.println("\nMy TimeLine");
		
		ResponseList<Status> list = twitter.getHomeTimeline();
		for(Status each : list){
			System.out.println("Sent by : @" + each.getUser().getScreenName()
						+ " - " + each.getUser().getName() + "\n" + each.getText()
						+ "\n");
		}
	}
}
