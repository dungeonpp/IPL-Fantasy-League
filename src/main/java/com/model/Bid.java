package com.model;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Component
@Scope("prototype")
@Entity
@NamedQuery(name="Bid.findAll", query="SELECT b FROM Bid b")
public class Bid implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int bidId;

	private int bidderId;

	//bi-directional many-to-one association to Team
	@ManyToOne
	@JoinColumn(name="teamId")
	private Team team;

	//bi-directional many-to-one association to Match
	@ManyToOne
	@JoinColumn(name="matchId")
	private Match match;

	public Bid() {
	}

	public int getBidId() {
		return this.bidId;
	}

	public void setBidId(int bidId) {
		this.bidId = bidId;
	}

	public int getBidderId() {
		return this.bidderId;
	}

	public void setBidderId(int bidderId) {
		this.bidderId = bidderId;
	}

	public Team getTeam() {
		return this.team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public Match getMatch() {
		return this.match;
	}

	public void setMatch(Match match) {
		this.match = match;
	}

}