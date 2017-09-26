package com.dao.daoimpl;

public class Test {

	public static void main(String[] args) {
		SystemDaoImplementation sdi = new SystemDaoImplementation();

		sdi.updateBidderPoints(2, 5);
		sdi.updateTeamPoints(2);
		System.out.println(sdi.sendResultToBidder(3,3));

	}

}
