package com.dao.daoimpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dao.SystemDao;
import com.dao.TeamDao;
import com.model.Bid;
import com.model.Bidder;
import com.model.Match;
import com.model.Team;
@Repository("SystemDao")
@Transactional
public class SystemDaoImplementation implements SystemDao {
	@Autowired
	public SessionFactory factory;


	static List<Team> team = new ArrayList<Team>();
	static List<Match> matchList = new ArrayList<Match>();
	static List<String> matchWinners = new ArrayList<String>();
	static List<Team> drawnMatchTeam1 = new ArrayList<Team>();
	static List<Team> drawnMatchTeam2 = new ArrayList<Team>();
	TeamDao teamDao = new TeamDaoImplementation();
	@Override
	public void updateTeamPoints(int match_id) {
		try{

			Session session=factory.getCurrentSession();

			// GET A LIST OF ALL MATCH WINNERS AND IN CASE OF DRAWN MATCHES GET THE LIST OF TEAM OBJECTS FOR WHICH MATCH WAS DRAWN
			Match match = new Match();
			match=(Match) session.get(Match.class,match_id);
			//System.out.println("Hello this is the match"+match);
			if(match != null){
				if(match.getMatchWinner().equals("draw")){
					drawnMatchTeam1.add(match.getTeam1());
					drawnMatchTeam2.add(match.getTeam2());
				}
				else{
					matchWinners.add(match.getMatchWinner());	
				}
			}
			//System.out.println("List of drawn teams 1 :"+drawnMatchTeam1);
			//System.out.println("List of drawn teams 2 :"+drawnMatchTeam1);
			//UPDATING TEAM POINTS OF WINNERS BY 3
			team = session.createQuery("from Team t").list();
			//System.out.println("List of all teams : "+ team);
			if(team.size()>0){
				for (Team teamDetails : team){

					if(teamDetails.getTeamName().equalsIgnoreCase(match.getMatchWinner())){

						int teamIdforUpdation = teamDetails.getTeamId();
						//System.out.println("winner id is: "+teamIdforUpdation);

						String hql = "update Team set teamPoint = teamPoint+3 where teamId = :teamIdForUpdate";					 

						Query query = session.createQuery(hql);
						query.setParameter("teamIdForUpdate",teamIdforUpdation );
						int rowsAffected = query.executeUpdate();

					}

					for(Team drawDetails : drawnMatchTeam1){
						if(teamDetails.getTeamName().equalsIgnoreCase(drawDetails.getTeamName())){
							int teamIdforUpdation = teamDetails.getTeamId();
							String hql = "update Team set teamPoint = teamPoint+1 where teamId = :teamIdForUpdate";					 

							Query query = session.createQuery(hql);
							query.setParameter("teamIdForUpdate",teamIdforUpdation );
							int rowsAffected = query.executeUpdate();
							//							if (rowsAffected > 0) {
							//								System.out.println("Updated " + rowsAffected + " rows.");
							//							}
						}
						for(Team drawDetails2 : drawnMatchTeam2){
							if(teamDetails.getTeamName().equalsIgnoreCase(drawDetails2.getTeamName())){
								int teamIdforUpdation = teamDetails.getTeamId();
								String hql = "update Team set teamPoint = teamPoint+1 where teamId = :teamIdForUpdate";					 

								Query query = session.createQuery(hql);
								query.setParameter("teamIdForUpdate",teamIdforUpdation );
								int rowsAffected = query.executeUpdate();
								//								if (rowsAffected > 0) {
								//									System.out.println("Updated " + rowsAffected + " rows.");
								//								}
							}

						}


					}

				}

			}}
		catch(Exception e)
		{
			e.printStackTrace();
		}	

	}

	@Override
	public void updateBidderPoints(int bidderId, int points) {
		try
		{


			Session session=factory.getCurrentSession();

			Bidder bidder = new Bidder();
			bidder.setBidderId(bidderId); 
			bidder.setBidderPoints(points);

			String hql = "UPDATE Bidder set bidderPoints = bidderPoints+"+ points + " where bidderId = "+bidderId ;
			Query query = session.createQuery(hql);

			int rowsAffected = query.executeUpdate();
			//			if (rowsAffected > 0) {
			//				System.out.println(rowsAffected + "(s) were inserted");
			//			}

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

			Session session=factory.getCurrentSession();

			Team teamDetails = new Team();

			//Get that match object for which parameter matchId is winner
			Match match = new Match();
			match=(Match) session.get(Match.class,matchId);

			//Winner Team's Name
			String winner = match.getMatchWinner();

			//Bid object for which parameter is bidId
			Bid bid = new Bid();
			bid = (Bid) session.get(Bid.class, bidId);

			//Bid Team's Object
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
				result ="You lost the bid for match : "+ match.getTeam1().getTeamName()+ " vs. " + match.getTeam2().getTeamName()+ " as " + winner + " won the match ";
			}

		}catch(Exception e)
		{
			e.printStackTrace();
		}

		return result;
	}

}
