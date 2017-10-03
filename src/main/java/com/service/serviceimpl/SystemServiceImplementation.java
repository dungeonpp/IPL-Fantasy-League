package com.service.serviceimpl;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.BidDao;
import com.dao.BidderDao;
import com.dao.MatchDao;
import com.dao.SystemDao;
import com.dao.TeamDao;
import com.dao.daoimpl.BidDaoImplementation;
import com.dao.daoimpl.BidderDaoImplementation;
import com.dao.daoimpl.MatchDaoImplementation;
import com.dao.daoimpl.SystemDaoImplementation;
import com.dao.daoimpl.TeamDaoImplementation;
import com.model.Bid;
import com.model.Bidder;
import com.model.Match;
import com.model.Team;
import com.service.SystemService;
@Service("systemService")
@Transactional
public class SystemServiceImplementation implements SystemService {
	@Autowired
	private BidDao bidDao = new BidDaoImplementation();
	@Autowired
	private BidderDao bidderDao = new BidderDaoImplementation();
	@Autowired
	private MatchDao matchDao = new MatchDaoImplementation();
	@Autowired
	private TeamDao teamDao = new TeamDaoImplementation();
	@Autowired
	private SystemDao systemDao = new SystemDaoImplementation();


	public void updateTeamPoints(int matchId) {
		systemDao.updateTeamPoints(matchId);
	}

	public void updateBidderPoints(int matchId) {

		//int bidderId,int bidId are not given
		//get a list of bids
		List<Bid> bidDetailsList = new ArrayList<Bid>();	
		bidDetailsList = bidDao.getAllBids();

		Bid bidObject = new Bid();

		for(Bid matchFindInBid: bidDetailsList){
			if(matchFindInBid.getMatch().getMatchId() == matchId){
				//				bidObject.setMatch();
				bidObject = matchFindInBid;
			}
		}
		//get bidderId
		int bidderId = bidObject.getBidderId();
		//get bidder object
		Bidder bidderObject = bidderDao.getBidder(bidderId);
		//get match object
		Match matchObject = matchDao.getMatch(matchId);
		//teams playing in that match
		Team team1 = matchObject.getTeam1();
		Team team2 = matchObject.getTeam2();

		Team winnerTeam = null;
		Team loserTeam = null;


		String winner = matchObject.getMatchWinner();

		if(winner.equalsIgnoreCase(team1.getTeamName())){
			winnerTeam = team1;
			loserTeam = team2;
		}
		else if(winner.equalsIgnoreCase(team2.getTeamName())) {
			winnerTeam = team2;
			loserTeam = team1;
		}
		//got winner and loser teams object

		//compare both teams
		int winnerTeamPoints = winnerTeam.getTeamPoint();
		int loserTeamPoints = loserTeam.getTeamPoint();

		int bidderPointsToUpdate = 0;

		int pointsDifference = java.lang.Math.abs((winnerTeamPoints - loserTeamPoints));
		if( pointsDifference > 0 && pointsDifference <= 6)
		{
			if(bidObject.getTeam().getTeamId() == winnerTeam.getTeamId()){
				if(winnerTeamPoints > loserTeamPoints){
					bidderPointsToUpdate= 2;
				}
				else{
					bidderPointsToUpdate = 3;
				}
			}
		}
		else if(pointsDifference > 6){
			if (bidObject.getTeam().getTeamId() == winnerTeam.getTeamId()) {

				if(winnerTeamPoints > loserTeamPoints){
					bidderPointsToUpdate = 2;
				}
				else{
					bidderPointsToUpdate = 5;
				}

			}
		}
		else if(pointsDifference == 0) {
			if (bidObject.getTeam().getTeamId() == winnerTeam.getTeamId()) {

				if(winnerTeamPoints == loserTeamPoints){
					bidderPointsToUpdate = 2;
				}

			}

		}
		systemDao.updateBidderPoints(bidderId,bidderPointsToUpdate);
	}



/*	public Bidder sendResultToBidder() {

		List<Bidder> biddersList = new ArrayList<Bidder>();
		biddersList = bidderDao.getAllBidders();

		List<Bid> bidsList = new ArrayList<Bid>();
		bidsList = bidDao.getAllBids();

		int matchId=0;
		int bidId=0;
		for(Bid bid: bidsList) {
			for(Bidder bidder: biddersList) {
				if(bid.getBidderId() == bidder.getBidderId()) {
					bidId = bid.getBidId();
					matchId = bid.getMatch().getMatchId();
					systemDao.sendResultToBidder(matchId, bidId);
				}
			}
		}


		return bidder;
	}*/

}
