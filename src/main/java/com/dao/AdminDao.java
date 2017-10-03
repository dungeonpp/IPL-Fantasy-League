package com.dao;

import java.io.FileNotFoundException;
import java.util.*;

import com.model.Bidder;
import com.model.Match;
import com.model.Team;


public interface AdminDao {
	public void addTeams();
	public void addMatches(String file);
	public List<Match> getMatch();
	public void endTournaments();
	public List<Bidder>showPreviousWinner();
	public void declareMatchWinner(int match_id,String winner);
	public void updateMatches(int matchId,String dateTime);
	public Match match(int matcId);
	public List<Team> getTeam();
	

	
	

}
