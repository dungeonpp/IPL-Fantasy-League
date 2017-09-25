package dao.bidder.implementations;

import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.Bidder;  
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test2{

	public static void main(String[] args) {  
		Scanner sc = new Scanner(System.in);
		BidderRegistrationDaoImplementations brdi = new BidderRegistrationDaoImplementations();

		Bidder bidder = new Bidder();
		boolean chk=false;
		if(chk==false) 
		{
			System.out.println("Enter bidder name");
			String name=sc.nextLine();
			bidder.setBidderName(name);

			System.out.println("Enter bidder email");
			String email = sc.nextLine();
			bidder.setEmail(email);

			System.out.println("Enter password");
			String passwd = sc.nextLine();
			bidder.setPassword(passwd);


			System.out.println("Enter mobile");
			String mno = sc.next();
			bidder.setMobile(mno);



			//bidder.setBidderPoints(0);
			//bidder.setBidderId(9);



			chk=brdi.validateRegistration(bidder);
			//chk=true;

			if(chk==true)
			{
				brdi.saveRegistration(bidder);

			}
			else
			{
				System.out.println("Please enter valid details!");
			}

		}
		// if(chk==false) 






		//brdi.validateRegistration(bidder);
		//brdi.saveRegistration(bidder);
		/*public boolean validate(final String hex) {
			private Pattern pattern;
			private Matcher matcher;

			private static final String EMAIL_PATTERN =
				"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
				pattern = Pattern.compile(EMAIL_PATTERN);

				matcher = pattern.matcher(hex);
				return matcher.matches();

			}*/



		//creating configuration object  
		/* Configuration cfg=new Configuration();  
    cfg.configure("hibernate.cfg.xml");//populates the data of the configuration file  
    //creating session factory object  
    SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
    //creating session object  
    Session session= sessionfactory.openSession();  
    //creating transaction object  
    Transaction t=session.beginTransaction();  
    System.out.println("::::Please enter data::::");


    System.out.println("Please enter ID:");
    int userId=sn.nextInt();
    System.out.println("Please enter name:");
    String userName= sn.next();
    System.out.println("Please enter mobile:");
    String userMobile= sn.next();
    System.out.println("Please enter email:");
    String userEmail= sn.next();
    System.out.println("Please enter password:");
    String pass= sn.next();
    System.out.println("Please enter type of user:");
    char userType= sn.next().charAt(0);
    System.out.println("Please enter address:");
    String userAddress= sn.next();
    System.out.println("Please enter city:");
    String userCity= sn.next();
    System.out.println("Please enter state:");
    String userState= sn.next();
    System.out.println("Please enter country:");
    String userCountry= sn.next();
    System.out.println("Please enter pin:");
    int userPin= sn.nextInt();


    Users e1=new Users();  
    e1.setUserId(userId);  
    e1.setUserName(userName);
    e1.setUserMobile(userMobile);
    e1.setUserEmail(userEmail);
    e1.setPassword(pass);
    e1.setUserType(userType);
    e1.setUserAddress(userAddress);
    e1.setUserCity(userCity);
    e1.setUserState(userState);
    e1.setUserCountry(userCountry);
    e1.setUserPin(userPin); 

    Bidder bidder = new Bidder();
    bidder.setBidderName("Steve");
    bidder.setEmail("steve.smith@gmail.com");
    bidder.setMobile("9876546374");
    bidder.setPassword("12345");


    try {
		session.save(bidder);//persisting the object  
		t.commit();//transaction is committed  
		session.close();
	} catch (HibernateException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}  
    System.out.println("successfully saved");  

}  
}  */
	}
}