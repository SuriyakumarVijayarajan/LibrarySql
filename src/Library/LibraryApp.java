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
			System.out.println("Enter your user_id,user_name,city,date_register,date_expire,password");
			String user_id=null;
			String user_name=null;
			boolean flag=false;
			do {
				System.out.println("Enter User_id");
				user_id=sc.nextLine();
				if(user_id.matches("[A-Za-z0-9]{2,}")){
					  flag=true;  
				  }
				else
					System.out.println("Please enter Valid user id");
				
			}while(flag==false);
			flag=false;
			do {
				System.out.println("Enter User_Name");
				user_name=sc.nextLine();
				if(user_name.matches("[A-Za-z]{2,}")){
					  flag=true;  
				  }
				else
					System.out.println("Please enter Valid user name");
				
			}while(flag==false);
			String city=null;
			flag=false;
			do {
				System.out.println("Enter city");
				city=sc.nextLine();
				if(city.matches("[A-Za-z]{2,}")){
					  flag=true;  
				  }
				else
					System.out.println("Please enter Valid city");
				
			}while(flag==false);
			String date_register=null;
			flag=false;
			do {
				System.out.println("Enter date_register");
				date_register=sc.nextLine();
				if(date_register.matches("([0-9]+[-]+[0-9]+[-]+[0-9]){10}")){
					  flag=true;  
				  }
				else
					System.out.println("Please enter Valid register date");
				
			}while(flag==false);
			String date_expire=null;
			flag=false;
			do {
				System.out.println("Enter date_expire");
				date_expire=sc.nextLine();
				if(date_expire.matches("([0-9]+[-]+[0-9]+[-]+[0-9]){10}")){
					  flag=true;  
				  }
				else
					System.out.println("Please enter Valid expire date");
				
			}while(flag==false);
			String password=null;
			flag=false;
			do {
				System.out.println("Enter password");
				date_expire=sc.nextLine();
				if(password.matches("([a-zA-Z0-9]+[@#$!%&+_=-]+[[0-9a-zA-Z]){10}")){
					  flag=true;  
				  }
				else
					System.out.println("Please enter Valid password");
				
			}while(flag==false);
			Users p1=new Users(user_id,user_name,city,date_register,date_expire,password);
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
