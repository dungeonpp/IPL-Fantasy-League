package com.dao;

import java.util.List;

public interface SystemDao {

	void updateTeamPoints(int matchId);
	void updateBidderPoints(int bidderId,int points);
	String sendResultToBidder(int bidderId,int bidId);

}
