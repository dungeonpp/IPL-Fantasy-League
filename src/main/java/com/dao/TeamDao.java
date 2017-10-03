package com.dao;

import java.util.List;

import com.model.Team;

public interface TeamDao {
	public Team getTeam(int teamId);
	public List<Team> getAllTeams();
}
