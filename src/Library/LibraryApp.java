package Library;
import java.sql.SQLException;
import java.util.Scanner;

import Book_Details.*;
import  User_Details.*;

public class LibraryApp {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your wish 1.register 2.login");
		String choice=sc.nextLine();
		UsersDao user = null;
		switch(choice) {

		
		/*Register*/
		
		
		case "register":
		case "1":
			user = new UsersDao();
			System.out.println("Enter your user_name,city,date_register,password,mobile_no,email_id");
			
			/*User name*/
			
			
			boolean flag =false;
			String user_name=null;
			do {
				System.out.println("Enter User_Name");
				user_name=sc.nextLine();
				if(user_name.matches("[A-Za-z]{2,}")){
					  flag=true;  
				  }
				else
					System.out.println("Please enter Valid user name");
				
/*City*/				
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

/*Password*/
			}while(flag==false);
			String password=null;
			flag=false;
			do {
				System.out.println("Enter password");
				password=sc.nextLine();
				if(password.matches("(?=.*[0-9])(?=.*[@#$%*!^()_+])(?=.*[a-z])(?=.*[A-Z]).{8,}")){
					  flag=true;  
				  }
				else
					System.out.println("Please enter Valid password");

/*Phone number*/				
			}while(flag==false);
			Long mobile_no=null;
			flag=false;
			String phno=null;
			do {
				System.out.println("Enter Phone Number");
				phno = sc.nextLine();
				if(phno.matches("[6-9][0-9]{9}")){
					  flag=true;  
				  }
				else
					System.out.println("Please enter Valid Phone number");
				
			}while(flag==false);
			mobile_no =Long.parseLong(phno);
			
/*Email Id*/			
			String email_id=null;
			flag=false;
			do {
				System.out.println("Enter email_id");
				email_id=sc.nextLine();
				if(email_id.matches("([a-zA-Z0-9]+[@][a-zA-Z]+[.][a-z]+{15,40})")){
					  flag=true;  
				  }
				else
					System.out.println("Please enter Valid email");
				
			}while(flag==false);
			Users p1=new Users(user_name,city,password,mobile_no,email_id);
			boolean a=user.insert(p1);
			if(a) {
				System.out.println("Registration successful");
			}
			else {
				System.out.println("Not registered");
			    break;
			}
			
/*Login*/			
			
		case "login":
		case "2":
			System.out.println("Enter your username and password");		
			flag =false;
			user_name=null;
			do {
				System.out.println("Enter User_Name");
				user_name=sc.nextLine();
				if(user_name.matches("[A-Za-z]{2,}")){
					  flag=true;  
				  }
				else
					System.out.println("Please enter Valid user name");
				
			}while(flag==false);
			password=null;
			flag=false;
			do {
				System.out.println("Enter password");
				password=sc.nextLine();
				if(password.matches("(?=.*[0-9])(?=.*[@#$%*!^()_+])(?=.*[a-z])(?=.*[A-Z]).{8,}")){
					  flag=true;  
				  }
				else
					System.out.println("Please enter Valid password");
				
			}while(flag==false);
			
			user = new UsersDao();
			String val = user.fetch(user_name, password);
			System.out.println(val);
			if(val.equals("user")) {
				System.out.println("Welcome user");
				libUser();
				
			}else if(val.equals("admin")){
				System.out.println("welcome admin");
				
			}
			break;
			
			default:
				System.out.println("Please select valid choice");
			
			

			
		}

	}
	
	public static void libUser() throws ClassNotFoundException, SQLException {
		BooksDao user=new BooksDao();
		System.out.println("1.Borrow Book, 2.Return Book ");
		Scanner sc=new Scanner(System.in);
		
		int choice = Integer.parseInt(sc.nextLine());
		switch(choice) {
		case 1:
			System.out.println("Search book by 1.Author 2.Category");
			int choice1 = Integer.parseInt(sc.nextLine());
			switch(choice1) {
			case 1:
				System.out.println("Enter Author Name");
				String author=sc.nextLine();
				user.authorFetch(author);
			}
			
		}
		
	}

}
