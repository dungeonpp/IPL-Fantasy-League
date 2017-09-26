package com.dao.daoimpl;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


import com.dao.AdminDao;

import com.model.Bidder;
import com.model.Match;
import com.model.Team;

public class AdminDaoImplementation implements AdminDao {

	static List<Bidder> bidder=new ArrayList<>();
	

	
	
	

	@Override
	public List<Match> getMatch() {
		try
		{
		List<Match> match=new ArrayList<>();
		Session session = Connection.getSession();
        Transaction t = session.beginTransaction();
		match = session.createQuery("from Match s").list();
		if(match.size()>0){
			return match;
		}
		t.commit();
		session.close();
		Connection.shutdown();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void endTournaments() {
		try
		{
			Session session = Connection.getSession();
	        Transaction t = session.beginTransaction();
	        
			bidder = session.createQuery("from Bidder b order by b.bidderPoints DESC").setMaxResults(3).list();
			System.out.println(bidder);
			Query q4=session.createQuery("delete from BiddingDetail");
			q4.executeUpdate();
			Query q1=session.createQuery("delete from Bidder");
			q1.executeUpdate();
			Query q2=session.createQuery("delete from Match");
			q2.executeUpdate();
			Query q3=session.createQuery("delete from Team");
			q3.executeUpdate();
			
		
			t.commit();
			session.close();
			Connection.shutdown();
		}catch(Exception e)
		{
			e.printStackTrace();
		}

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

	
}
