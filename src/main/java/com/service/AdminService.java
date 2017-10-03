package com.service;

import java.util.List;

import com.model.Bidder;
import com.model.Match;
import com.model.Team;

public interface AdminService {

		public void uplodTeams(String file);
		public void uploadMatches(String file);
		public List<Match> showMatches();
		public void endTournamenst();
		public void updateMatchWinner(int matchId,String winner);
		public void resheduleMatch(int matchId,String time);
		public List<Team> showTeam();

	
	
}
