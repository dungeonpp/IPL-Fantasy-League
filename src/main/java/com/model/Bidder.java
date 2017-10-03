package com.model;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
@Scope("prototype")
@Entity
@NamedQuery(name="Bidder.findAll", query="SELECT b FROM Bidder b")
public class Bidder implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int bidderId;

	private String bidderName;

	private int bidderPoints;

	@Override
	public String toString() {
		return "Bidder [bidderId=" + bidderId + ", bidderName=" + bidderName + ", bidderPoints=" + bidderPoints
				+ ", email=" + email + ", mobile=" + mobile + ", password=" + password + "]";
	}

	private String email;

	private String mobile;

	private String password;

	public Bidder() {
	}

	public int getBidderId() {
		return this.bidderId;
	}

	public void setBidderId(int bidderId) {
		this.bidderId = bidderId;
	}

	public String getBidderName() {
		return this.bidderName;
	}

	public void setBidderName(String bidderName) {
		this.bidderName = bidderName;
	}

	public int getBidderPoints() {
		return this.bidderPoints;
	}

	public void setBidderPoints(int bidderPoints) {
		this.bidderPoints = bidderPoints;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}