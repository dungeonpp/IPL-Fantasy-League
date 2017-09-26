package com.dao;

import java.util.*;

import com.model.Bidder;
import com.model.Match;


public interface AdminDao {
	public void addTeams();//Swati is still working on it
	public void addMatches();//
	public List<Match> getMatch();
	public void endTournaments();
	public List<Bidder>showPreviousWinner();
	public void declareMatchWinner(int match_id,String winner);
	public void updateMatches(int matchId,String dateTime);
	
	

}
