com.dao.daoImpl;

import java.util.Scanner;

public class TestBidderLogin {
	public static void main(String[] args) {
		BidderLoginDaoImp obj = new BidderLoginDaoImp();
		
		System.out.println("Enter the mail : ");
		Scanner sc = new Scanner(System.in);
		String email =sc.nextLine();

		System.out.println("Enter the password : ");
		String password =sc.nextLine();


		obj.validateUser(email,password);
	}
}
