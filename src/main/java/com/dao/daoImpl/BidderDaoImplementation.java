package com.dao.daoImpl;

import java.util.Date;
import java.util.HashSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import dao.bidder.BidderDao;
import model.Bidder;
import model.BiddingDetail;
import model.Match;
import model.Team;

public class BidderDaoImplementation implements BidderDao
{
	@Override
	public void updateProfile(int bidderId)
	{
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();		
		Transaction tx = session.beginTransaction();
		
		Bidder bidder = new Bidder();
		bidder = (Bidder) session.get(Bidder.class,bidderId );
		bidder.setBidderName("Akashh");
		bidder.setEmail("a@gmail.com");
		bidder.setMobile("9677899");
		bidder.setPassword("akash");
		bidder.setBidderPoints(0);
		
		session.update(bidder);
		tx.commit();
		
		session.close();
		System.out.println("Updation is done successfully...");
		factory.close();
	}
	
	@Override
	public void updateBid(int bidId, int matchId, int teamId) 
	{
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();		
		Transaction tx = session.beginTransaction();
		
		BiddingDetail bid = new BiddingDetail();
		Team team = new Team();
		team.setTeamId(teamId);
	
		
		String query="update BiddingDetail set teamId= "+teamId+ "where bidId="+bidId+" AND matchId="+matchId;

		Query q=session.createQuery(query);
		q.executeUpdate();
		tx.commit();
		
		session.close();
		System.out.println("Updation is done successfully...");
		factory.close();
	}
	
@Override
	public void showTodaysMatch(Date d)
	{
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();		
		Transaction tx = session.beginTransaction();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String todaysDate = sdf.format(d);
		
		
		String SQL_QUERY = "From Match match";
		Query query = session.createQuery(SQL_QUERY);
		for(Iterator it = query.iterate();it.hasNext();)
		{
			Match match = (Match)it.next();
			Date matchDate1=match.getMatchDateTime();
			String matchDate = sdf.format(matchDate1);
			if(todaysDate.equalsIgnoreCase(matchDate))
			{
				System.out.println(match);
			}
		}
	
		tx.commit();
		session.close();
		
	}
	
	
	
	public static void main(String[] args) 
	{
		BidderDaoImplementation bdi = new BidderDaoImplementation();
		Date d = new Date();
		bdi.showTodaysMatch(d);
		bdi.updateProfile(1);  // bidderId
		bdi.updateBid(1, 1, 2);  // bidId, matchId, teamId 
	}
}
