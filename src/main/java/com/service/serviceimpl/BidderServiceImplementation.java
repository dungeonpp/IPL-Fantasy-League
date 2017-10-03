package com.service.serviceimpl;

import java.util.*;

import org.apache.poi.util.SystemOutLogger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.BidderDao;
import com.dao.daoimpl.BidderDaoImplementation;
import com.model.*;
import com.service.BidderService;
import com.utility.UserAlreadyExists;


@Service("bidderService")
@Transactional
public class BidderServiceImplementation implements BidderService{
	@Autowired
	private BidderDao bidderDao = new BidderDaoImplementation();
	public String validateLogin(String emailId, String password) {
		if(emailId.equalsIgnoreCase("admin") && password.equals("godfather")) {
			return "admin"; 
		}
		Bidder bidder = bidderDao.getBidder(emailId);
		if(bidder != null) {
			String bidderPassword = bidder.getPassword();
			if (bidderPassword.equals(password)) {
				return "bidder";
			} else {
				return "failed";
			}
		}
			return "failed";
	}

	public boolean checkIfBidderExists(String emailId) {
		Bidder bidder = bidderDao.getBidder(emailId);
		if (bidder != null)
			return true;
		else
			return false;
	}

	public boolean modifyBidder(Bidder bidder) {
		String bidderName = bidder.getBidderName();
		String bidderPassword = bidder.getPassword();
		String bidderMobile = bidder.getMobile();
		bidderDao.updateProfile(bidderName,bidderPassword,bidderMobile);
		return true;
	}

	public void registerBidder(Bidder bidder) {
		List<Bidder> allBiddersList = new ArrayList<Bidder>();
		allBiddersList = bidderDao.getAllBidders();
		if(allBiddersList!=null) {
			for(Bidder bidderObject: allBiddersList) {
				if(bidder.getEmail().equalsIgnoreCase(bidderObject.getEmail()))
				{
					try {
						throw new UserAlreadyExists("User already exists");
					} catch (UserAlreadyExists e) {
						e.printStackTrace();
					}
				}
				else
				{
					bidderDao.saveRegistration(bidder);
				}
			}
		}
	}
	@Override
	public List<Match> showAllMatches() {
			return bidderDao.showMatches();
	}

	@Override
	public String addBid(int bidderId, int teamId, int matchId) {
		String teamName = bidderDao.addBid(bidderId, teamId, matchId);
		return teamName;

	}
	@Override
	public List<Bidder> showLeaderboard() {
		return bidderDao.showLeaderboard();  
	      
	}
	@Override
	public List<Team> showTeamPoints() {
		return bidderDao.showTeamPoints();
	}
	
	@Override
	public String updateBid(int bidId, int matchId, int teamId) {
		String teamName = bidderDao.updateBid(bidId, matchId, teamId);
		return teamName;
		
	}
	@Override
	public List<Match> showTodaysMatch(Date sysdate) {
		return bidderDao.showTodaysMatch(sysdate);
	}
	

}

	
	

