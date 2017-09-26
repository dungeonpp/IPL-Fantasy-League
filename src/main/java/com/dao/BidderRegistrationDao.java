package com.dao;

import com.model.Bidder;

public interface BidderRegistrationDao {
	
	public boolean validateRegistration(Bidder bidder);
	public void saveRegistration(Bidder bidder);
	

}
