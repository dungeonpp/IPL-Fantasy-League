package com.dao.daoimpl;

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

import com.dao.BidderDao;
import com.model.Bidder;
import com.model.BiddingDetail;
import com.model.Match;
import com.model.Team;

public class BidderDaoImplementation implements BidderDao
{
	@Override
	public List<String> showLeaderboard() {

	List<Bidder> b=new ArrayList<Bidder>();
	List<String> output=new ArrayList<String>();
	
	try
	{
	Configuration cfg=new Configuration().configure("hibernate.cfg.xml");		
	SessionFactory factory=cfg.buildSessionFactory();
	Session session=factory.openSession();
	Transaction t=session.beginTransaction();
	
	b = session.createQuery("from Bidder s").list();
	if(b.size()>0){
		for (Bidder bidder : b) 
		{
			System.out.println(bidder.getBidderName()+" : "+bidder.getBidderPoints());
		}
	}
	t.commit();
	session.close();
	}catch(Exception e)
	{
		e.printStackTrace();
	}

	return output;
	

}

	@Override
	public List<String> showTeamPoints() {
	List<Team> team=new ArrayList<Team>();
	List<String> output=new ArrayList<String>();
	
	try
	{
		Configuration cfg=new Configuration().configure("hibernate.cfg.xml");		
		SessionFactory factory=cfg.buildSessionFactory();
		Session session=factory.openSession();
		Transaction t=session.beginTransaction();
		
		team = session.createQuery("from Team s").list();
		if(team.size()>0){
			for (Team teamDetails : team) 
			{
				System.out.println(teamDetails.getTeamName()+" : "+teamDetails.getTeamPoint());
			}
	}
	t.commit();
	session.close();
	}catch(Exception e)
	{
		e.printStackTrace();
	}

	return output;


}

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
		bidder.setBidderName("prafull");
		bidder.setEmail("r@gmail.com");
		bidder.setMobile("9677899");
		bidder.setPassword("ron");
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
	
	@Override
	public void showMatches() 
	{
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();		
		Transaction tx = session.beginTransaction();
		
		List<Bidder> list = new ArrayList<>();
		list = session.createQuery("from Match").list();
		System.out.println(list);

		tx.commit();
		session.close();
	}
	
	@Override
	public void addBid(int matchId, int bidderId, int teamId )  
	{
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();		
		Transaction tx = session.beginTransaction();
		
		BiddingDetail bid = new BiddingDetail();
		
		session.save(bid);
		
		String HQL_QUERY = "From BiddingDetail b";
		Query query = session.createQuery(HQL_QUERY);
		int bidId = 0; Set<Integer> set = new HashSet<>();
		for(Iterator it = query.iterate();it.hasNext();)
		{
			BiddingDetail bd = (BiddingDetail)it.next();
			bidId=bd.getBidId();
			set.add(bidId);
		}
		bidId = Collections.max(set);
		
		String query1="update BiddingDetail set matchId="+matchId+" where bidId="+bidId;
		String query2="update BiddingDetail set teamId="+teamId+" where bidId="+bidId;
		String query3="update BiddingDetail set bidderId="+bidderId+" where bidId="+bidId;

		Query q1=session.createQuery(query1); Query q2=session.createQuery(query2); Query q3=session.createQuery(query3);

		q1.executeUpdate();q2.executeUpdate();q3.executeUpdate();
		
		tx.commit();
		
		session.close();
		System.out.println("insertion is done successfully...");
		factory.close();
	}
	
	public static void main(String[] args) 
	{
		BidderDaoImplementation bdi = new BidderDaoImplementation();
		
		bdi.updateProfile(1);  // bidderId
		//bdi.updateBid(3, 1, 3);  // bidId, matchId, teamId
		
		//bdi.showMatches();
		//bdi.addBid(6, 3, 1);
		//matchId, bidderId, teamId 
		
		//Date d = new Date();
		//bdi.showTodaysMatch(d);  // currentDate 
	}

	/*@Override
	public String showLastBidResult() {
		
		
		
		return null;
	}*/
}
