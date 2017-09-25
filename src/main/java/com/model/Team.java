package com.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the team database table.
 * 
 */
@Entity
@NamedQuery(name="Team.findAll", query="SELECT t FROM Team t")
public class Team implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="team_id")
	private int teamId;

	private int draw;

	private int loss;

	@Column(name="team_name")
	private String teamName;

	@Column(name="team_point")
	private int teamPoint;

	private int win;

	//bi-directional many-to-one association to BiddingDetail
	@OneToMany(mappedBy="team")
	private List<BiddingDetail> biddingDetails;

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

	public List<BiddingDetail> getBiddingDetails() {
		return this.biddingDetails;
	}

	public void setBiddingDetails(List<BiddingDetail> biddingDetails) {
		this.biddingDetails = biddingDetails;
	}

	public BiddingDetail addBiddingDetail(BiddingDetail biddingDetail) {
		getBiddingDetails().add(biddingDetail);
		biddingDetail.setTeam(this);

		return biddingDetail;
	}

	public BiddingDetail removeBiddingDetail(BiddingDetail biddingDetail) {
		getBiddingDetails().remove(biddingDetail);
		biddingDetail.setTeam(null);

		return biddingDetail;
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