package com.dao.daoimpl;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dao.AdminDao;

import com.model.Bidder;
import com.model.Match;
import com.model.Team;
@Repository("adminDao")
@Transactional
public class AdminDaoImplementation implements AdminDao {

	@Autowired
	public SessionFactory factory;
	static List<Bidder> bidder=new ArrayList<>();
	@Override
	public void updateMatches(int matchId,String dateTime) {

		String query="update Match set match_date_time=\'"+dateTime+"\' where match_id="+matchId;
		factory.getCurrentSession().update(query);


	}

	@Override
	@Transactional
	public void addTeams() {
		List<Team> teamList=new ArrayList<>();
		try{

			FileReader file=new FileReader("C:\\Users\\Administrator\\Desktop\\ipl_demo.csv");
			BufferedReader bf=new BufferedReader(file);
			String line;
			while((line=bf.readLine())!=null) {
				String arr[]=line.split(",");
				String teamName=arr[1];
				//System.out.println(arr[2]);
				int teamId=Integer.parseInt(arr[2]);
				Team teamObj=new Team();
				teamObj.setTeamName(teamName);
				teamObj.setTeamId(teamId);
				//System.out.println(teamObj);
				factory.getCurrentSession().save(teamObj);
			}


		}catch(Exception e){
			e.printStackTrace();
		}

	}

	@Transactional
	public List<Team> getTeam(String teamName) {
		List<Team> team=new ArrayList<>();
		team=factory.getCurrentSession().createQuery("from Team where teamName=\'"+teamName+"\'").list();

		return team;
	}

	@Override
	@Transactional
	public void addMatches(String file) {

		try{
			Match match=new Match();
			FileInputStream input = new FileInputStream("C:\\Users\\Administrator\\Desktop\\ipl_match.xls");
			POIFSFileSystem fs = new POIFSFileSystem( input );
			HSSFWorkbook wb = new HSSFWorkbook(fs);
			HSSFSheet sheet = wb.getSheetAt(0);
			Row row;
			for(int i=1; i<=sheet.getLastRowNum(); i++){
				Session session =factory.getCurrentSession();

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
			}



		}catch(Exception e){
			e.printStackTrace();
		}


	}


	@Override
	@Transactional
	public List<Match> getMatch() {

		List<Match> match=new ArrayList<>();
		match = factory.getCurrentSession().createQuery("from Match").list();
		return match;

	}

	@Override
	@Transactional
	public void endTournaments() {


		Session session=factory.getCurrentSession();
		Query q4=session.createQuery("delete from Bid");
		q4.executeUpdate();
		Query q1=session.createQuery("delete from Bidder");
		q1.executeUpdate();
		Query q2=session.createQuery("delete from Match");
		q2.executeUpdate();
		Query q3=session.createQuery("delete from Team");
		q3.executeUpdate();


	}

	@Override
	@Transactional
	public List<Bidder> showPreviousWinner() {

		return bidder;
	}


	@Override
	@Transactional
	public void declareMatchWinner(int Id,String winnerName) {

		Match match=new Match();
		String query="update Match set matchWinner=\'"+winnerName+"\' where matchId=1";
		match=(Match) factory.getCurrentSession().get(Match.class,Id);
		//System.out.println(match);
		match.setMatchWinner(winnerName);




	}

	@Override
	public Match match(int matchId) {
		Match matchObj=new Match();
		matchObj=factory.getCurrentSession().get(Match.class, matchId);
		return matchObj;
	}

	@Override
	public List<Team> getTeam() {
		List<Team> team=new ArrayList<>();
		team = factory.getCurrentSession().createQuery("from Team").list();
		return team;
	}






}
