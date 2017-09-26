package com.dao;

import java.util.List;

import com.model.Bidder;

public interface BidderLoginDao {
	public void validateUser(String email,String password);

}
