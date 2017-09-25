package com.dao;

import java.util.Date;

import model.Match;
import model.Team;

public interface BidderDao 
{
		public void updateProfile(int bidderId);
		public void showMatches();
		public void addBid(int bidderId, int teamId, int matchId);
		public List<String> showLeaderboard();
		public List<String> showTeamPoints();
		public void updateBid(int bidId,int matchId,int teamId);
		public String showLastBidResult();
		public void showTodaysMatch(Date sysdate);
	
}
