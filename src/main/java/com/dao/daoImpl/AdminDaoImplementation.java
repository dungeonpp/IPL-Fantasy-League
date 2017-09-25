package com.dao.daoImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import connection.Connection;
import dao.admin.AdminDao;

import com.model.Bidder;
import com.model.Match;
import com.model.Team;

public class AdminDaoImplementation implements AdminDao {

	static List<Bidder> bidder=new ArrayList<>();
	@Override
	public void addTeams(Team team) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addMatches(Match match) {
		
	}

	@Override
	public List<Bidder> showPreviousWinner() {

		return bidder;
	}

	@Override
	public void declareMatchWinner(int Id,String winnerName) {
		Session session = Connection.getSession();
        Transaction t = session.beginTransaction();
        String query="update Match set matchWinner=\'"+winnerName+"\' where matchId=1";
        Query q=session.createQuery(query);
		q.executeUpdate();
//        Query  query=session.createQuery("from Match where match_id="+Id);
//        Iterator<Match> it=query.iterate();
//        while(it.hasNext())
//        {
//        	it.next().setMatchWinner(winnerName);
//        }
        t.commit();
        session.close();
        Connection.shutdown();
        
        
        
	}

	@Override
	public void updateMatches(int matchId,String dateTime) {
		Session session = Connection.getSession();
        Transaction t = session.beginTransaction();
		String query="update Match set match_date_time=\'"+dateTime+"\' where match_id="+matchId;
		Query q=session.createQuery(query);
		q.executeUpdate();
		t.commit();
		System.out.println(session.get(Match.class,1));
		session.close();
		Connection.shutdown();
	}

}
