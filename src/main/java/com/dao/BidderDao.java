package com.dao;

import java.util.Date;
import java.util.List;

import com.model.Match;
import com.model.Team;

public interface BidderDao 
{
		public void updateProfile(int bidderId);
		public void showMatches();
		public void addBid(int bidderId, int teamId, int matchId);
		List<String> showLeaderboard();
		List<String> showTeamPoints();
		void updateBid(int bidId,int matchId,int teamId);
		
		public void showTodaysMatch(Date sysdate);
}
