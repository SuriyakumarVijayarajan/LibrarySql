import java.sql.SQLException;
import java.util.Scanner;
import  User_Details.*;

public class LibraryApp {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your wish 1.login 2.register");
		String choice=sc.nextLine();
		switch(choice) {
		case "login":
			System.out.println("Enter your username and password");		
			String uname=sc.nextLine();
			String pword=sc.nextLine();
			
			UsersDao user = new UsersDao();
			String val = user.fetch(uname, pword);
			System.out.println(val);
			if(val.equals("user")) {
				System.out.println("Welcome user");
			}else if(val.equals("admin")){
				System.out.println("welcome admin");
			}
			
		}

	}

}
