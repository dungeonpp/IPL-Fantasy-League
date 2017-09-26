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
	@Column(name="match_id")
	private int matchId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="match_date_time")
	private Date matchDateTime;

	@Column(name="match_winner")
	private String matchWinner;

	//bi-directional many-to-one association to BiddingDetail
	@OneToMany(mappedBy="match")
	private List<BiddingDetail> biddingDetails;

	//bi-directional many-to-one association to Team
	@ManyToOne
	@JoinColumn(name="team1_id")
	private Team team1;
 
	//bi-directional many-to-one association to Team
	@ManyToOne
	@JoinColumn(name="team2_id")
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

	public void setMatchDateTime(Date matchDateTime) {
		this.matchDateTime = matchDateTime;
	}

	public String getMatchWinner() {
		return this.matchWinner;
	}

	public void setMatchWinner(String matchWinner) {
		this.matchWinner = matchWinner;
	}

	public List<BiddingDetail> getBiddingDetails() {
		return this.biddingDetails;
	}

	public void setBiddingDetails(List<BiddingDetail> biddingDetails) {
		this.biddingDetails = biddingDetails;
	}

	public BiddingDetail addBiddingDetail(BiddingDetail biddingDetail) {
		getBiddingDetails().add(biddingDetail);
		biddingDetail.setMatch(this);

		return biddingDetail;
	}

	public BiddingDetail removeBiddingDetail(BiddingDetail biddingDetail) {
		getBiddingDetails().remove(biddingDetail);
		biddingDetail.setMatch(null);

		return biddingDetail;
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

	@Override
	public String toString() {
		return "\nMatch [matchId=" + matchId + ", matchDateTime=" + matchDateTime + ", matchWinner=" + matchWinner
				+ ", team1=" + team1.getTeamName() + ", team2=" + team2.getTeamName() + "]";
	}

}