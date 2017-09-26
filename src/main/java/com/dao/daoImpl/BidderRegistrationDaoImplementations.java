package com.dao.daoimpl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

//import java.util.*;
import com.dao.BidderRegistrationDao;
import com.model.Bidder;

public class BidderRegistrationDaoImplementations implements BidderRegistrationDao {
	
	public boolean validateRegistration(Bidder bidder)
	{
	     if(bidder.getBidderName()==null || bidder.getBidderName()=="")
	     {
				return false;
	     }
	     else if(bidder.getMobile().length() < 10 || bidder.getMobile()=="")
		 {
				return false;
	     }
	     else if(bidder.getPassword().length() < 8 || bidder.getPassword()=="")
		 {
				return false;
	     }
	     else
		 {
				String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
				String email = bidder.getEmail();
				Boolean b = email.matches(EMAIL_REGEX);
				System.out.println("is e-mail: "+email+" :Valid = " + b);
				if(b==false)
				{
					return false;
				}	
	     }
	    	 return true;
	     
		
	}

	@Override
	public void saveRegistration(Bidder bidder) {
		
	    Configuration cfg=new Configuration();  
	    cfg.configure("hibernate.cfg.xml");//populates the data of the configuration file  
	    SessionFactory factory=cfg.buildSessionFactory();  
	    //creating session object  
	    Session session=factory.openSession();  
	    //creating transaction object  
	    Transaction t=session.beginTransaction(); 
	    
	    try {
			session.save(bidder);//persisting the object 
			
			t.commit();//transaction is committed  
			session.close();
		} catch (HibernateException e) {
			e.printStackTrace();
		}  
	    System.out.println("successfully saved");  
	    
	}

}

