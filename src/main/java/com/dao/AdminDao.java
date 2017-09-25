package com.dao;

import java.util.*;

import model.*;

public interface AdminDao {
	public void addTeams(Team team);
	public void addMatches(Match match);
	public List<Match> getMatch();
	public void endTournaments();
	public List<Bidder>showPreviousWinner();
	public void declareMatchWinner(int match_id,String winner);
	public void updateMatches(int matchId,String dateTime);
	
	

}
