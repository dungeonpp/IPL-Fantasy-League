package com.dao.daoImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import dao.SystemDao;
import model.Bidder;
import model.BiddingDetail;
import model.Match;
import model.Team;

public class SystemDaoImplementation implements SystemDao {
	static List<Team> team = new ArrayList<Team>();
	static List<Match> matchList = new ArrayList<Match>();
	static List<String> matchWinners = new ArrayList<String>();
	static List<Team> drawnMatchTeam1 = new ArrayList<Team>();
	static List<Team> drawnMatchTeam2 = new ArrayList<Team>();

	@Override
	public void updateTeamPoints(int match_id) {
		try{
		Configuration cfg=new Configuration().configure("hibernate.cfg.xml");		
		SessionFactory factory=cfg.buildSessionFactory();
		Session session=factory.openSession();
		Transaction t=session.beginTransaction();

		// GET A LIST OF ALL MATCH WINNERS AND IN CASE OF DRAWN MATCHES GET THE LIST OF TEAM OBJECTS FOR WHICH MATCH WAS DRAWN
		Match match = new Match();
		match=(Match) session.get(Match.class,match_id);

		if(match != null){
				if(match.getMatchWinner().equals("draw")){
					drawnMatchTeam1.add(match.getTeam1());
					drawnMatchTeam2.add(match.getTeam2());
				}
				else{
					matchWinners.add(match.getMatchWinner());	
				}
		}
		//UPDATING TEAM POINTS OF WINNERS BY 3
		team = session.createQuery("from Team s").list();
		if(team.size()>0){
			for (Team teamDetails : team){
				if(teamDetails.getTeamName().equalsIgnoreCase(match.getMatchWinner())){
					int teamIdforUpdation = teamDetails.getTeamId();
					String hql = "update Team set team_point = team_point+3 where team_id = :teamIdForUpdate";					 
					
					Query query = session.createQuery(hql);
					query.setParameter("teamIdForUpdate",teamIdforUpdation );
					int rowsAffected = query.executeUpdate();
					if (rowsAffected > 0) {
					    System.out.println("Updated " + rowsAffected + " rows.");
					}
				}
				
			}
			
			
	
		}
		//UPDATING TEAM POINTS OF TEAMS IN DRAWN MATCHES BY 1
		
		if(team.size()>0){
			for (Team teamDetails : team){
				if(teamDetails.getTeamName().equalsIgnoreCase(match.getMatchWinner())){
					int teamIdforUpdation = teamDetails.getTeamId();
					String hql = "update Team set team_point = team_point+3 where team_id = :teamIdForUpdate";					 
					
					Query query = session.createQuery(hql);
					query.setParameter("teamIdForUpdate",teamIdforUpdation );
					int rowsAffected = query.executeUpdate();
					if (rowsAffected > 0) {
					    System.out.println("Updated " + rowsAffected + " rows.");
					}
				}	
			}			
		}
/*		
		team = session.createQuery("from Team s").list();
		if(team.size()>0){
			for (Team teamDetails : team) 
			{
				for (Team drawnTeam : drawnMatchTeam2) 
				{
					if(drawnTeam.getTeamName().equalsIgnoreCase(teamDetails.getTeamName())){
						String hql = "update Team set team_points = team_points+1 where team_id = :teamIdForUpdate";
						 
						Query query = session.createQuery(hql);
				
						query.setParameter("teamIdForUpdate", teamId);
						 
						int rowsAffected = query.executeUpdate();
						if (rowsAffected > 0) {
						    System.out.println("Updated " + rowsAffected + " rows.");
						}						
					}					
				}					
			}			
		}*/
		

		t.commit();
		session.close();}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
		
	}

	@Override
	public void updateBidderPoints(int bidderId, int points) {
		try
		{
		Configuration cfg=new Configuration().configure("hibernate.cfg.xml");		
		SessionFactory factory=cfg.buildSessionFactory();
		Session session=factory.openSession();
		Transaction t=session.beginTransaction();
		
		Bidder bidder = new Bidder();
		bidder.setBidderId(bidderId); 
		bidder.setBidderPoints(points);
		
		String hql = "UPDATE Bidder set bidder_points = bidder_points+"+ points + " where bidder_id = "+bidderId ;
		Query query = session.createQuery(hql);

		int rowsAffected = query.executeUpdate();
		if (rowsAffected > 0) {
		    System.out.println(rowsAffected + "(s) were inserted");
		}
		t.commit();
		session.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}

	}

	@Override
	public List<String> sendResultToBidder(int bidderId,int bidId) {
		List<Bidder> bidderList=new ArrayList<Bidder>();
		List<BiddingDetail> biddingList=new ArrayList<BiddingDetail>();
		
		List<String> output=new ArrayList<String>();
		
		try
		{
		Configuration cfg=new Configuration().configure("hibernate.cfg.xml");		
		SessionFactory factory=cfg.buildSessionFactory();
		Session session=factory.openSession();
		Transaction t=session.beginTransaction();
		
		bidderList = session.createQuery("from bidder s").list();
		biddingList = session.createQuery("from bidding_details s").list();
		if(bidderList.size()>0 && biddingList.size()>0){
			for (BiddingDetail bid : biddingList) 
			{
//				if(bid.getTeam())
				/*System.out.println(bidder.getBidderName()+" : "+bidder.getBidderPoints());*/
				
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

}
