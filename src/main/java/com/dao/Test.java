package com.dao.admin;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import com.dao.admin.implementations.AdminDaoImplementation;
import com.model.Match;

public class Test {

	public static void main(String[] args) throws ParseException {
		AdminDaoImplementation a=new AdminDaoImplementation();
		System.out.println(a.getMatch());
		//a.endTournaments();
		a.declareMatchWinner(1,"Royal Challengers Bangalore");
//		String dateStr = new Date("2017-09-26 10:10:40").toString();
//		DateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
//		Date date = (Date)formatter.parse(dateStr);
//		System.out.println(date);        
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Calendar cal = GregorianCalendar.getInstance(Locale.US);
		cal.setTime(date);
		
		String formatedDate = cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1) + "-" +cal.get(Calendar.DATE)+" "+cal.get(Calendar.HOUR_OF_DAY)+":"+cal.get(Calendar.MINUTE)+":"+cal.get(Calendar.SECOND);
	
		//Date d1=sdf.parse(formatedDate);
		//System.out.println(formatedDate);
		//a.updateMatches(1,formatedDate);
		System.out.println(a.showPreviousWinner());
		Match m1=new Match();
		a.addMatches(m1);
	}

}
