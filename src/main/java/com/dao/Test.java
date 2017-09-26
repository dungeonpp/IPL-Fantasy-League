package com.dao;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import com.dao.daoimpl.AdminDaoImplementation;
import com.model.Match;

public class Test {

	public static void main(String[] args) throws ParseException {
		
		AdminDaoImplementation a=new AdminDaoImplementation();
		//System.out.println(a.getMatch());
		//a.endTournaments();
		//a.declareMatchWinner(1,"Royal Challengers Bangalore");
		
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar cal = GregorianCalendar.getInstance(Locale.US);
		cal.setTime(date);
		
	
		
		a.updateMatches(1,"2017-09-26 16:00:00");
		//System.out.println(a.showPreviousWinner());
		//Match m1=new Match();
		//a.addMatches();
		//a.addTeams();
	}

}
