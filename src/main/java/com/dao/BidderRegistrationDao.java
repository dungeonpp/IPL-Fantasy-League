package dao.bidder;

import model.Bidder;

//import java.util.*;

public interface BidderRegistrationDao {
	
	public boolean validateRegistration(Bidder bidder);
	
	
	public void saveRegistration(Bidder bidder);
	

}
