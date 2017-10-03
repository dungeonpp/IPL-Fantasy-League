package com.model;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@Scope("prototype")
@Entity
@NamedQuery(name="Team.findAll", query="SELECT t FROM Team t")
public class Team implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int teamId;

	private int draw;

	@Override
	public String toString() {
		int played = win + loss + draw;
		return " Team " + teamName + " Played "+ played + " Won " +win+ " Lost "+ loss+  " draw " + draw + " Points " + teamPoint;
	}

	private int loss;

	private String teamName;

	private int teamPoint;

	private int win;

	//bi-directional many-to-one association to Bid
	@OneToMany(mappedBy="team")
	private List<Bid> bids;

	//bi-directional many-to-one association to Match
	@OneToMany(mappedBy="team1")
	private List<Match> matches1;

	//bi-directional many-to-one association to Match
	@OneToMany(mappedBy="team2")
	private List<Match> matches2;

	public Team() {
	}

	public int getTeamId() {
		return this.teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public int getDraw() {
		return this.draw;
	}

	public void setDraw(int draw) {
		this.draw = draw;
	}

	public int getLoss() {
		return this.loss;
	}

	public void setLoss(int loss) {
		this.loss = loss;
	}

	public String getTeamName() {
		return this.teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public int getTeamPoint() {
		return this.teamPoint;
	}

	public void setTeamPoint(int teamPoint) {
		this.teamPoint = teamPoint;
	}

	public int getWin() {
		return this.win;
	}

	public void setWin(int win) {
		this.win = win;
	}

	public List<Bid> getBids() {
		return this.bids;
	}

	public void setBids(List<Bid> bids) {
		this.bids = bids;
	}

	public Bid addBid(Bid bid) {
		getBids().add(bid);
		bid.setTeam(this);

		return bid;
	}

	public Bid removeBid(Bid bid) {
		getBids().remove(bid);
		bid.setTeam(null);

		return bid;
	}

	public List<Match> getMatches1() {
		return this.matches1;
	}

	public void setMatches1(List<Match> matches1) {
		this.matches1 = matches1;
	}

	public Match addMatches1(Match matches1) {
		getMatches1().add(matches1);
		matches1.setTeam1(this);

		return matches1;
	}

	public Match removeMatches1(Match matches1) {
		getMatches1().remove(matches1);
		matches1.setTeam1(null);

		return matches1;
	}

	public List<Match> getMatches2() {
		return this.matches2;
	}

	public void setMatches2(List<Match> matches2) {
		this.matches2 = matches2;
	}

	public Match addMatches2(Match matches2) {
		getMatches2().add(matches2);
		matches2.setTeam2(this);

		return matches2;
	}

	public Match removeMatches2(Match matches2) {
		getMatches2().remove(matches2);
		matches2.setTeam2(null);

		return matches2;
	}

}