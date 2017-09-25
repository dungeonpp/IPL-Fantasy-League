package com.dao;

import java.util.List;

public interface SystemDao {

	void updateTeamPoints(int matchId);
	void updateBidderPoints(int bidderId,int points);
	//needs to be implemented
	List<String> sendResultToBidder(int bidderId,int bidId);

}
