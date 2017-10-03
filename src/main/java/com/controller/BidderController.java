package com.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.dao.BidderDao;
import com.dao.daoimpl.BidderDaoImplementation;
import com.model.Bidder;
import com.model.Match;
import com.model.Team;
import com.service.AdminService;
import com.service.BidderService;
import com.service.serviceimpl.AdminServiceImplimentation;
import com.service.serviceimpl.BidderServiceImplementation;

@Controller
public class BidderController {

	@Autowired(required=true)
	private BidderService bidderService=new BidderServiceImplementation();
	@Autowired(required=true)
	private BidderDao bidderDao=new BidderDaoImplementation();
	@Autowired(required=true)
	private AdminService adminService=new AdminServiceImplimentation();


	@RequestMapping(value="/registerBidder", method=RequestMethod.POST)
	public ModelAndView addBidder(@ModelAttribute("bidder") Bidder bidder, BindingResult bindings,HttpServletRequest request,HttpServletResponse response,HttpSession session)
	{		
		bidderService.registerBidder(bidder);
		ModelAndView mv=new ModelAndView("index");
		return mv;
	}

	@RequestMapping(value="/index",method=RequestMethod.GET)
	public ModelAndView loadIndex(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("index");
		return mv;
	}

	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logout(HttpServletRequest request,HttpServletResponse response,HttpSession session) {
		session.invalidate();	    
		return "redirect:/index";
	}

	@RequestMapping(value="/dashboard", method=RequestMethod.POST)
	public ModelAndView loginBidder(@ModelAttribute("bidder") Bidder bidder, BindingResult bindings,HttpServletRequest request,HttpServletResponse response,HttpSession session) {  
		String email=bidder.getEmail();
		String password=bidder.getPassword();

		Bidder bidderForSession = new Bidder();
		String result = bidderService.validateLogin(email, password);

		Bidder bidderObject = bidderDao.getBidder(email);   
		if(result.equalsIgnoreCase("bidder")) {

			session = request.getSession();
			session.setAttribute("bidderSessionObject",bidder);
			ModelAndView mv = new ModelAndView("bidderDashboard");

			List<Team> teamsList = new ArrayList<Team>();
			teamsList = bidderService.showTeamPoints();

			List<Match> match=new ArrayList<>();

			match=bidderService.showAllMatches();
			mv.addObject("matches",match);
			mv.addObject("teamsList",teamsList);

			return mv;

		}
		else if(result.equalsIgnoreCase("admin")) {
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
		else
			return new ModelAndView("index","message","Invalid Username or Password !");
	}

	@RequestMapping(value="/showLeaderBoard", method=RequestMethod.GET)
	public ModelAndView showLeaderBoard(HttpServletRequest request,HttpServletResponse response) {  
		
		List<Bidder> biddersList = new ArrayList<>();
		  Collections.sort(biddersList, new Comparator<Bidder>() {
		        @Override
		        public int compare(Bidder bidder1, Bidder bidder2) {
		            return Double.compare(bidder1.getBidderPoints(),bidder2.getBidderPoints());
		        }
		    });
		biddersList = bidderService.showLeaderboard();
		Map<String,Object> model = new HashMap<>();
		model.put("biddersList",bidderService.showLeaderboard());
		return new ModelAndView("bidder_leaderboard",model);
	}

	@RequestMapping(value="/bidderDashboard", method=RequestMethod.GET)
	public ModelAndView bidderDashboard(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("bidderDashboard");

		List<Team> teamsList = new ArrayList<Team>();
		teamsList = bidderService.showTeamPoints();

		List<Match> match=new ArrayList<>();
		match=bidderService.showAllMatches();
		mv.addObject("matches",match);
		mv.addObject("teamsList",teamsList);

		return mv;
	}

	@RequestMapping(value="/userProfile", method=RequestMethod.GET)
	public ModelAndView displayUserProfile(@ModelAttribute("bidder") Bidder bidder, BindingResult bindings,HttpSession session,HttpServletRequest request,HttpServletResponse response) {

		session = request.getSession();

		Bidder bidderObject = (Bidder) session.getAttribute("bidderSessionObject");

		//System.out.println(bidderObject);
		String email = bidderObject.getEmail();
		//System.out.println("email is"+email);
		Bidder bidderProfile = bidderDao.getBidder(email);

		ModelAndView mv=new ModelAndView("userProfile");
		mv.addObject("bidderDetails",bidderProfile);
		return mv;
	}

	@RequestMapping(value="/bidOnMatch", method=RequestMethod.GET)
	public ModelAndView addBid(HttpServletRequest request,HttpServletResponse response,HttpSession session,@ModelAttribute("bidder") Bidder bidder, BindingResult bindings) {  
		session = request.getSession();

		int teamId=Integer.parseInt(request.getParameter("teamId"));

		int matchId=Integer.parseInt((request.getParameter("id")));

		/*		System.out.println("betting on match id "+matchId);
		System.out.println("betting on team"+teamId);*/

		Bidder bidderObject = (Bidder) session.getAttribute("bidderSessionObject");

		//System.out.println("bidder id is :" + bidderObject.getEmail());
		Bidder bidderProfile = bidderDao.getBidder(bidderObject.getEmail());
		int bidderId = bidderProfile.getBidderId();
		String teamName = bidderService.addBid(bidderId, teamId, matchId);
		//System.out.println(teamName);
		ModelAndView mv = new ModelAndView("redirect:/showLeaderBoard");
		return mv;

	}


}
