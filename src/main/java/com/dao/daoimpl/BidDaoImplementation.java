package com.dao.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dao.BidDao;
import com.model.Bid;

@Repository("bidDao")
@Transactional
public class BidDaoImplementation implements BidDao {
	@Autowired
	public SessionFactory factory;

	@Override
	public Bid getBid(int bidId) {
		Session session = factory.getCurrentSession();
		Bid bid = new Bid();
		bid = session.get(Bid.class, bidId);
		return bid;
	}

	@Override
	public List<Bid> getAllBids() {
		Session session = factory.getCurrentSession();
		List<Bid> allBidsList = new ArrayList<Bid>();
		allBidsList = session.createQuery("From Bid b").list();
		return allBidsList;
	}

}
