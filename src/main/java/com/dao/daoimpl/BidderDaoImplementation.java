package com.dao.daoimpl;

import java.text.SimpleDateFormat;
import java.util.*;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dao.BidderDao;
import com.model.*;

@Repository("bidderDao")
@Transactional
public class BidderDaoImplementation implements BidderDao
{
	@Autowired
	public SessionFactory factory;

	@Override
	public Bidder getBidder(String emailAddress) {
		Session session = factory.getCurrentSession();
		Bidder bidder = new Bidder();

		try {
			Criteria criteria = session.createCriteria(Bidder.class);
			criteria.add(Restrictions.eq("email", emailAddress));
			bidder = (Bidder) criteria.uniqueResult();
			//System.out.println(bidder);
			return bidder;
		} catch (RuntimeException e) {
			return bidder;
		}
	}
	@Override
	public Bidder getBidder(int bidderId) {
		Session session = factory.getCurrentSession();
		Bidder bidder = new Bidder();
		bidder = session.get(Bidder.class, bidderId);
		return bidder;

	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<Bidder> showLeaderboard() {

		return (List<Bidder>) factory.getCurrentSession().createCriteria(Bidder.class).list();

	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<Team> showTeamPoints() {
		return (List<Team>) factory.getCurrentSession().createCriteria(Team.class).list();
	}

	@Override
	public void updateProfile(String newBidderName,String newBidderMobile,String newBidderPassword)
	{
		Session session = factory.getCurrentSession();
		String regex = "\\^[789]\\d{9}$";
		Bidder bidder = new Bidder();

		if(newBidderName!= null && bidder.getBidderName().equalsIgnoreCase(newBidderName)) {
			bidder.setBidderName(newBidderName);
		}
		if(newBidderMobile!= null && bidder.getMobile().matches(regex)) {
			bidder.setMobile(newBidderMobile);
		}

		session.update(bidder);

	}

	@Override
	public String updateBid(int bidId, int matchId, int teamId) 
	{
		Session session = factory.getCurrentSession();		

		Team team = session.get(Team.class,teamId);

		String query="update Bid set teamId= "+teamId+ "where bidId="+bidId+" AND matchId="+matchId;

		session.createQuery(query);
		return team.getTeamName();

	}


	@Override
	public List<Match> showTodaysMatch(Date d)
	{
		List<Match> matchesList = new ArrayList<>();
		Session session = factory.getCurrentSession();

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
				matchesList.add(match);
			}
		}
		return matchesList;

	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean validateBidder(String email,String password) {

		List<Bidder> bidderList=new ArrayList<Bidder>();
		Session session=factory.getCurrentSession();
		bidderList = session.createQuery("from Bidder b").list();
		for (Bidder bidder : bidderList)
		{
			if(bidder.getEmail().equalsIgnoreCase(email) && bidder.getPassword().equalsIgnoreCase(password))
			{
				return true;
			}
			else
				break;
		}
		return false;

	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<Match> showMatches() 
	{
		return (List<Match>) factory.getCurrentSession().createCriteria(Match.class).list();

	}

	@Override
	public String addBid(int bidderId, int teamId,int matchId )  
	{
		Session session = factory.getCurrentSession();	
		Bid bid = new Bid();
		Match match = session.get(Match.class, matchId);
		Team team = session.get(Team.class, teamId);

		bid.setBidderId(bidderId);
		bid.setMatch(match);
		bid.setTeam(team);

		session.save(bid);
		return bid.getTeam().getTeamName();
	}

	@Override
	public void saveRegistration(Bidder bidder) {
		factory.getCurrentSession().save(bidder); 
		//System.out.println("successfully saved");  
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<Bidder> getAllBidders() {
		return (List<Bidder>) factory.getCurrentSession().createCriteria(Bidder.class).list();
	}

	@Override
	public List<Bid> showBid() {
		Session session = factory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Bid> bidList = session.createQuery("from Bid b").list();
		return bidList;
	}


}
