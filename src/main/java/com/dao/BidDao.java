package com.dao;

import java.util.List;

import com.model.Bid;

public interface BidDao {
	public Bid getBid(int bidId);
	public List<Bid> getAllBids();

}
