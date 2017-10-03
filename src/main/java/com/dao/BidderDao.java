package com.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.model.Bid;
import com.model.Bidder;
import com.model.Match;
import com.model.Team;

public interface BidderDao 
{
		public void updateProfile(String newBidderName,String newBidderMobile,String password);
		public List<Match> showMatches();
		public String addBid(int bidderId, int teamId, int matchId);
		public List<Bidder> showLeaderboard();
		public List<Team> showTeamPoints();
		public List<Bid> showBid();
		public String updateBid(int bidId,int matchId,int teamId);
		public void saveRegistration(Bidder bidder);
		public boolean validateBidder(String email,String password);
		public List<Match> showTodaysMatch(Date sysdate);
		public Bidder getBidder(String emailAddress);
		public List<Bidder> getAllBidders();
		Bidder getBidder(int bidderId);
}
