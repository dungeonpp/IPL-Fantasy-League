package com.dao.daoImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import dao.bidder.BidderLoginDao;
import model.Bidder;


public class BidderLoginDaoImp implements BidderLoginDao {



	@Override
	public void validateUser(String email,String password) {
		
		List<Bidder> b=new ArrayList<Bidder>();
		Configuration cfg=new Configuration().configure("hibernate.cfg.xml");		
		SessionFactory factory=cfg.buildSessionFactory();
		Session session=factory.openSession();
		Transaction t=session.beginTransaction();
		b = session.createQuery("from Bidder s").list();
		System.out.println("Details");
		for (Bidder bidder : b)
		{
			
			if(bidder.getEmail().equalsIgnoreCase(email) && bidder.getPassword().equalsIgnoreCase(password))
			{
				System.out.println("match found!!!");
				System.out.println(bidder);
			}
			else
			{
				System.out.println("Sorry!!! match not found ");
			}

		}

	}

}
