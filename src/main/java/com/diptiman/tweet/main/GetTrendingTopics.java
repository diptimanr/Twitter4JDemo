package com.diptiman.tweet.main;

import com.diptiman.tweet.util.TwitterUtil;

import twitter4j.Location;
import twitter4j.ResponseList;
import twitter4j.Trends;
import twitter4j.Twitter;
import twitter4j.TwitterException;

public class GetTrendingTopics {
	
	public static void main(String[] args) throws Exception{
		
		Twitter twitter = TwitterUtil.getTwitterInstance();
		ResponseList<Location> locations;
		locations = twitter.getAvailableTrends();
		
		Integer idTrendLocation = getTrendLocation("london");
		if(idTrendLocation == null){
			System.out.println("Trend Location Not Found");
			System.exit(0);
		}
		
		Trends trends = twitter.getPlaceTrends(idTrendLocation);
		for(int i = 0; i < trends.getTrends().length; i++){
			System.out.println(trends.getTrends()[i].getName());
		}
		
		//printWoeId();

	}
	
	private static void printWoeId() throws Exception{
		Twitter twitter = TwitterUtil.getTwitterInstance();		
		ResponseList<Location> locations;
		locations = twitter.getAvailableTrends();
		System.out.println("Showing available Trends ....");
		for(Location location : locations){
			System.out.println(location.getName() + " (woeid : " + location.getWoeid() + ")");
		}
	}
	
	
	private static Integer getTrendLocation(String locationName){
		int idTrendLocation = 0;
		try{
			Twitter twitter = TwitterUtil.getTwitterInstance();			
			ResponseList<Location> locations;
			locations = twitter.getAvailableTrends();
			
			for(Location location : locations){
				if(location.getName().toLowerCase().equals(locationName.toLowerCase())){
					idTrendLocation = location.getWoeid();
					break;
				}
			}
			if(idTrendLocation > 0){
				return(new Integer(idTrendLocation));
			}
			return(null);
		}catch(TwitterException te){
			te.printStackTrace();
			System.out.println("Failed to get trends :  " + te.getMessage());
			return(null);
		}
	}
}
