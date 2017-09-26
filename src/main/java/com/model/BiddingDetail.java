package com.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the bidding_details database table.
 * 
 */
@Entity
@Table(name="bidding_details")
@NamedQuery(name="BiddingDetail.findAll", query="SELECT b FROM BiddingDetail b")
public class BiddingDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="bid_id")
	private int bidId;

	@Column(name="bidder_id")
	private int bidderId;

	//bi-directional many-to-one association to Team
	@ManyToOne
	@JoinColumn(name="team_id")
	private Team team;

	//bi-directional many-to-one association to Match
	@ManyToOne
	@JoinColumn(name="match_id")
	private Match match;

	public BiddingDetail() {
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

	@Override
	public String toString() {
		return "\nBiddingDetail [bidId=" + bidId + ", bidderId=" + bidderId + ", team=" + team + ", match=" + match + "]";
	}

	public Match getMatch() {
		return this.match;
	}

	public void setMatch(Match match) {
		this.match = match;
	}

}