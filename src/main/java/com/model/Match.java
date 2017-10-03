package com.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the matches database table.
 * 
 */
@Entity
@Table(name="matches")
@NamedQuery(name="Match.findAll", query="SELECT m FROM Match m")
public class Match implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int matchId;

	@Temporal(TemporalType.TIMESTAMP)
	private Date matchDateTime;

	private String matchWinner;

	//bi-directional many-to-one association to Bid
	@OneToMany(mappedBy="match")
	private List<Bid> bids;

	//bi-directional many-to-one association to Team
	@ManyToOne
	@JoinColumn(name="team1Id")
	private Team team1;

	//bi-directional many-to-one association to Team
	@ManyToOne
	@JoinColumn(name="team2Id")
	private Team team2;

	public Match() {
	}

	public int getMatchId() {
		return this.matchId;
	}

	public void setMatchId(int matchId) {
		this.matchId = matchId;
	}

	public Date getMatchDateTime() {
		return this.matchDateTime;
	}

	@Override
	public String toString() {
		return "Match [matchId=" + matchId + ", matchDateTime=" + matchDateTime + ", matchWinner=" + matchWinner
				+ ", bids=" + bids + ", team1=" + team1 + ", team2=" + team2 + "]";
	}

	public void setMatchDateTime(Date matchDateTime) {
		this.matchDateTime = matchDateTime;
	}

	public String getMatchWinner() {
		return this.matchWinner;
	}

	public void setMatchWinner(String matchWinner) {
		this.matchWinner = matchWinner;
	}

	public List<Bid> getBids() {
		return this.bids;
	}

	public void setBids(List<Bid> bids) {
		this.bids = bids;
	}

	public Bid addBid(Bid bid) {
		getBids().add(bid);
		bid.setMatch(this);

		return bid;
	}

	public Bid removeBid(Bid bid) {
		getBids().remove(bid);
		bid.setMatch(null);

		return bid;
	}

	public Team getTeam1() {
		return this.team1;
	}

	public void setTeam1(Team team1) {
		this.team1 = team1;
	}

	public Team getTeam2() {
		return this.team2;
	}

	public void setTeam2(Team team2) {
		this.team2 = team2;
	}

}