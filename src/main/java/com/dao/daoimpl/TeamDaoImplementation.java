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

import com.dao.TeamDao;
import com.model.Team;
@Repository("teamDao")
@Transactional
public class TeamDaoImplementation implements TeamDao {

	@Autowired
	public SessionFactory factory;

	@Override
	public Team getTeam(int teamId) {
		Session session = factory.getCurrentSession();
		Team team = new Team();
		team = session.get(Team.class, teamId);
		return team;

	}

	@Override
	public List<Team> getAllTeams() {
		Session session = factory.getCurrentSession();
		List<Team> allTeamsList = new ArrayList<Team>();
		allTeamsList = session.createQuery("from Team t").list();
		return allTeamsList;
	}
}
