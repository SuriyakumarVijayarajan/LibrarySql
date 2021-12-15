package Library;
import java.sql.SQLException;
import java.util.Scanner;
import  User_Details.*;

public class LibraryApp {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your wish 1.login 2.register");
		String choice=sc.nextLine();
		UsersDao user = null;
		switch(choice) {
		case "login":
			System.out.println("Enter your username and password");		
			String uname=sc.nextLine();
			String pword=sc.nextLine();
			
			user = new UsersDao();
			String val = user.fetch(uname, pword);
			System.out.println(val);
			if(val.equals("user")) {
				System.out.println("Welcome user");
				
			}else if(val.equals("admin")){
				System.out.println("welcome admin");
				
			}
			break;
		case "register":
			user = new UsersDao();
			System.out.println("Enter your user_id,user_name,city,date_register,date_expire,user_role,password");
//			String user_id=sc.nextLine();
//			String user_name=sc.nextLine();
//			String city=sc.nextLine();
//			String date_register=sc.nextLine();
//			String date_expire=sc.nextLine();
//			String user_role=sc.nextLine();
//			String password=sc.nextLine();
			String pDetail=sc.nextLine();
			Users p1=new Users(pDetail.split(",")[0],pDetail.split(",")[1],
					pDetail.split(",")[2],pDetail.split(",")[3],pDetail.split(",")[4],
					pDetail.split(",")[5],pDetail.split(",")[6]);
			boolean a=user.insert(p1);
			if(a) {
				System.out.println("Registration successful");
				break;
			}
			else
				System.out.println("Not registered");
			break;
			
			default:
				System.out.println("Please select valid choice");
			
			

			
		}

	}

}
