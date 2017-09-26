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

	@Override
	public void addMatches() {
		try{
			
			FileInputStream input = new FileInputStream("C:\\Users\\Administrator\\Desktop\\ipl_match.xls");
			POIFSFileSystem fs = new POIFSFileSystem( input );
			HSSFWorkbook wb = new HSSFWorkbook(fs);
			HSSFSheet sheet = wb.getSheetAt(0);
			Row row;
			for(int i=1; i<=sheet.getLastRowNum(); i++){
				Session session = Connection.getSession();
		        Transaction t = session.beginTransaction();
				row = sheet.getRow(i);
				Date date = row.getCell(0).getDateCellValue();         
				SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String op4=sdf3.format(date);
				String teamA = row.getCell(1).getStringCellValue();
				String teamB = row.getCell(2).getStringCellValue();
				String matchwinner = row.getCell(3).getStringCellValue();
		       
				List<Team> teamOne=new ArrayList<Team>();
				List<Team> teamTwo=new ArrayList<Team>();
				teamOne=session.createQuery("from Team where teamName=\'"+teamA+"\'").list();
				teamTwo=session.createQuery("from Team where teamName=\'"+teamB+"\'").list();
				Match match=new Match();
				
				int teamAId=teamOne.get(0).getTeamId();
				int teamBId=teamTwo.get(0).getTeamId();
				Team team1= new Team();
				Team team2=new Team();
				team1=(Team) session.get(Team.class,teamAId);
				team2=(Team) session.get(Team.class,teamBId);
				match.setMatchDateTime(date);
				match.setTeam1(team1);
				match.setTeam2(team2);
				match.setMatchWinner("Draw");
				session.save(match);
				t.commit();
				session.close();
			
			}
			
			
			Connection.shutdown();
		}catch(Exception e){
			e.printStackTrace();
		}


	}

	
	

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
