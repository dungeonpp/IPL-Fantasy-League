package com.service;

import java.sql.Date;

import com.model.Bidder;

public interface SystemService {
	
	void updateTeamPoints(int matchId);
	void updateBidderPoints(int matchId);
	//Bidder sendResultToBidder();	Yet to be implemented 

}
