package com.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dao.AdminDao;
import com.dao.daoimpl.AdminDaoImplementation;
import com.model.Match;
import com.model.Team;
import com.service.AdminService;
import com.service.BidderService;
import com.service.SystemService;
import com.service.serviceimpl.AdminServiceImplimentation;
import com.service.serviceimpl.BidderServiceImplementation;
import com.service.serviceimpl.SystemServiceImplementation;

@Controller
public class AdminController {
	@Autowired
	private AdminService adminService=new AdminServiceImplimentation();
	@Autowired
	private BidderService bidderService=new BidderServiceImplementation();
	@Autowired
	private AdminDao adminDao=new AdminDaoImplementation();
	@Autowired
	private SystemService systemService=new SystemServiceImplementation();
	List<Team> team=new ArrayList<>();
	
	
	@RequestMapping(value="/admindashboard")
	public ModelAndView adminDashboard(HttpServletRequest request, HttpServletResponse response)
	{
		
		Match matchVar=new Match();

		List<Match> match=new ArrayList<>();
		List<Match> unResultMatches=new ArrayList<>();
		match=adminService.showMatches();
		ModelAndView mv=new ModelAndView("AdminDashboard");
		Iterator <Match> it=match.iterator();
		while(it.hasNext())
		{
			matchVar=it.next();
			if(matchVar.getMatchWinner().length()==0)
			{
				unResultMatches.add(matchVar);
			}
		}
		
		mv.addObject("matches",unResultMatches);
		return mv;
		
		
		
	}
	
	@RequestMapping(value="addTeam")
	public ModelAndView uploadDatt()
	{
		adminService.uplodTeams("");
		return new ModelAndView("AdminDashboard");
		
	}
	@RequestMapping(value="addMatch")
	public ModelAndView uploadMatch()
	{
		adminService.uploadMatches("");
		return new ModelAndView("AdminDashboard");
		
	}
	
	@RequestMapping(value="endTournament")
	public ModelAndView flushTables()
	{
		adminService.endTournamenst();
		Match matchVar=new Match();

		List<Match> match=new ArrayList<>();
		List<Match> unResultMatches=new ArrayList<>();
		match=adminService.showMatches();
		ModelAndView mv=new ModelAndView("AdminDashboard");
		Iterator <Match> it=match.iterator();
		while(it.hasNext())
		{
			matchVar=it.next();
			if(matchVar.getMatchWinner().length()==0)
			{
				unResultMatches.add(matchVar);
			}
		}
		
		mv.addObject("matches",unResultMatches);
		
		return mv;
		
	}
	@RequestMapping(value="/declareWinner")
	public ModelAndView announceWinner(HttpServletRequest request, HttpServletResponse response)
	{
		
		Match matchVar=new Match();
		String winner=request.getParameter("winner");
		int matchId=Integer.parseInt((request.getParameter("id")));
		adminService.updateMatchWinner(matchId, winner);
    	systemService.updateBidderPoints(matchId);
    	systemService.updateTeamPoints(matchId);
    	
    	List<Match> match=new ArrayList<>();
		List<Match> unResultMatches=new ArrayList<>();
		match=adminService.showMatches();
		ModelAndView mv=new ModelAndView("AdminDashboard");
		Iterator <Match> it=match.iterator();
		while(it.hasNext())
		{
			matchVar=it.next();
			if(matchVar.getMatchWinner().length()==0)
			{
				unResultMatches.add(matchVar);
			}
		}
		
		mv.addObject("matches",unResultMatches);
		return mv;

		
	}
	
	@RequestMapping(value="/rescheduleMatch")
	public ModelAndView rescheduleMatch(HttpServletRequest request, HttpServletResponse response)
	{
		Match m=new Match();
		List <Match> matches=new ArrayList<>();
		List <Match> match=new ArrayList<>();
    	matches=adminService.showMatches();
    	int Id=Integer.parseInt((request.getParameter("id")));
    	m=adminDao.match(Id);
    	match.add(m);
		return new ModelAndView("ResheduleMatch","matches",match);
		
	}
	@RequestMapping("/matchHistory")
	public ModelAndView matchHistory(HttpServletRequest request, HttpServletResponse response)
	{
		Match matchVar=new Match();

		List<Match> match=new ArrayList<>();
		List<Match> matchhist=new ArrayList<>();
		match=adminService.showMatches();
		ModelAndView mv=new ModelAndView("matchHistory");
		Iterator <Match> it=match.iterator();
		while(it.hasNext())
		{
			matchVar=it.next();
			if(matchVar.getMatchWinner().length()!=0)
			{
				matchhist.add(matchVar);
			}
		}
		mv.addObject("matches",matchhist);
		return mv;
		
	}
	@RequestMapping(value="/updateMatch" ,method=RequestMethod.GET)
	public ModelAndView updateMacth(HttpServletRequest request, HttpServletResponse response) throws ParseException
	{
		int i=0;
		System.out.println(request.getAttribute("id"));
		String date=request.getParameter("date");
		StringTokenizer dateAndTime = new StringTokenizer(date,":");
		 String newTime1[]=new String[3];
		while(dateAndTime.hasMoreTokens()) {
			newTime1[i++]=dateAndTime.nextToken();
 
		}
		Date sysdate=new Date();
		sysdate.setHours(Integer.parseInt(newTime1[0]));
		sysdate.setMinutes(Integer.parseInt(newTime1[1]));
		String date1=sysdate.toString();
		Match m=new Match();
		
		
		List <Match> matches=new ArrayList<>();
		List <Match> match=new ArrayList<>();
    	matches=adminService.showMatches();
    	String mid=request.getParameter("id");
    	int id=Integer.parseInt(mid);
    	m=adminDao.match(id);
    	match.add(m);
    	adminService.resheduleMatch(id,date1);
		 return new ModelAndView("ResheduleMatch","matches",match);
	
		
	}
	
}
