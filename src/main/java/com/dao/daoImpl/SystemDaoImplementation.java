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
				for(Team drawDetails : drawnMatchTeam1){
					if(teamDetails.getTeamName().equalsIgnoreCase(drawDetails.getTeamName())){
						int teamIdforUpdation = teamDetails.getTeamId();
						String hql = "update Team set team_point = team_point+1 where team_id = :teamIdForUpdate";					 
						
						Query query = session.createQuery(hql);
						query.setParameter("teamIdForUpdate",teamIdforUpdation );
						int rowsAffected = query.executeUpdate();
						if (rowsAffected > 0) {
						    System.out.println("Updated " + rowsAffected + " rows.");
						}
					}
					
			}

		if(team.size()>0){
			for (Team teamDetails2 : team){
				for(Team drawDetails2 : drawnMatchTeam2){
					if(teamDetails2.getTeamName().equalsIgnoreCase(drawDetails2.getTeamName())){
						int teamIdforUpdation = teamDetails.getTeamId();
						String hql = "update Team set team_point = team_point+1 where team_id = :teamIdForUpdate";					 
						
						Query query = session.createQuery(hql);
						query.setParameter("teamIdForUpdate",teamIdforUpdation );
						int rowsAffected = query.executeUpdate();
						if (rowsAffected > 0) {
						    System.out.println("Updated " + rowsAffected + " rows.");
						}
					}
					
					}
				}	
		}

		t.commit();
		session.close();}}}
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
	public String sendResultToBidder(int matchId,int bidId) {
		String result = null;
		try
		{
		Configuration cfg=new Configuration().configure("hibernate.cfg.xml");		
		SessionFactory factory=cfg.buildSessionFactory();
		Session session=factory.openSession();
		Transaction t=session.beginTransaction();
		
		Team teamDetails = new Team();
		
		//match ka object for that matchId which is winner
		Match match = new Match();
		match=(Match) session.get(Match.class,matchId);
		
		//This team won the match
		String winner = match.getMatchWinner();
		
		//bid ka object for that bidId
		BiddingDetail bid = new BiddingDetail();
		bid = (BiddingDetail) session.get(BiddingDetail.class, bidId);
		
		//bid wala team object
		Team bidTeam = new Team();
		bidTeam = (Team) session.get(Team.class,bid.getTeam().getTeamId());
	
		int bidTeamId = bidTeam.getTeamId();
		int matchTeamId = 0;
		
		if (match.getMatchWinner().equals(teamDetails.getTeamName())){
			matchTeamId = teamDetails.getTeamId();
		}
		
		if(bidTeamId == matchTeamId){
			 result = "You won the bid for match : "+ match.getTeam1().getTeamName()+ " vs. " + match.getTeam2().getTeamName();
			
		}
		else{
			result ="You lost the bid for match : "+ match.getTeam1().getTeamName()+ " vs. " + match.getTeam2().getTeamName()+ "as" + winner + "won the match ";
		}
		t.commit();
		session.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	
		return result;
	}

}
