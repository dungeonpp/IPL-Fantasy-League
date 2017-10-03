package com.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.model.Bidder;
import com.model.Match;
import com.model.Team;

public interface BidderService {

	public String validateLogin(String emailId,String password);
	public boolean checkIfBidderExists(String emailId);
	public void registerBidder(Bidder bidder);
	public boolean modifyBidder(Bidder bidder);
	public List<Match> showAllMatches();
	public List<Bidder> showLeaderboard();
	public List<Team> showTeamPoints();
	public String addBid(int bidderId, int teamId, int matchId);
	public String updateBid(int bidId,int matchId,int teamId);
	public List<Match> showTodaysMatch(Date sysdate);
}
