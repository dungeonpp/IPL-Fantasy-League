package com.service.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.AdminDao;
import com.dao.daoimpl.AdminDaoImplementation;
import com.model.Match;
import com.model.Team;
import com.service.AdminService;
@Service("adminService")
@Transactional
public class AdminServiceImplimentation implements AdminService {


	@Autowired
	private AdminDao adminDao=new AdminDaoImplementation();
	@Override
	public void uplodTeams(String file) {
		adminDao.addTeams();

	}

	@Override
	public void uploadMatches(String file) {

		adminDao.addMatches(file);
	}

	@Override
	public List<Match> showMatches() {

		return adminDao.getMatch();
	}

	@Override
	public void endTournamenst() {
		try
		{
			adminDao.endTournaments();
		}catch(Exception e)
		{
			//System.out.println("Error Occured During Deliting Table");
		}


	}

	@Override
	public void updateMatchWinner(int matchId, String winner) {

		adminDao.declareMatchWinner(matchId, winner);
	}

	@Override
	public void resheduleMatch(int matchId, String time) {

		adminDao.updateMatches(matchId, time);
	}

	@Override
	public List<Team> showTeam() {

		List<Team> team=new ArrayList<>();
		team=adminDao.getTeam();
		return team ;
	}

}
