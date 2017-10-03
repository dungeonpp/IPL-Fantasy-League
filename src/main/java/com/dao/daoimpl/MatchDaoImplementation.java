package com.dao.daoimpl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dao.MatchDao;
import com.model.Match;
import com.model.Team;
@Repository("matchDao")
@Transactional
public class MatchDaoImplementation implements MatchDao {
	@Autowired
	public SessionFactory factory;
	@Override
	public Match getMatch(int matchId) {
		Session session = factory.getCurrentSession();
		Match match = new Match();
		match = session.get(Match.class, matchId);
		return match;

	}

}
