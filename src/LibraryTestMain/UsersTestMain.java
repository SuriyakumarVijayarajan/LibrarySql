package LibraryTestMain;
import java.sql.Connection;
import LibraryDAOs.*;
import LibraryPojo.*;
import Connection.*;
import java.sql.SQLException;
import java.util.Scanner;

public class UsersTestMain {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Scanner sc = new Scanner(System.in);
		Connection con=ConnectionUtil.getDBConnect();
		System.out.println("Connection established");
		UsersDao uDao = new UsersDao();
		System.out.println("Enter your choice ");
		int choice=Integer.parseInt(sc.nextLine());
		System.out.println("Enter your user_name,city,date_register,password,mobile_no,email_id");
		
		/*User name*/
		switch(choice) {
		case 1:
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
		boolean a=uDao.insert(p1);
		if(a) {
			System.out.println("Row inserted Successfully");
		}
			
			
		case 2:
			int user_id,fine_amount = 0;
			System.out.println("Enter User Id");
			user_id=Integer.parseInt(sc.nextLine());
			System.out.println("Enter Fine amount");
			Users p2=new Users(user_id,fine_amount);
				
			uDao.update(p2);
		    break;
			
		case 3: 
			    user_id=Integer.parseInt(sc.nextLine());
				Users p3=new Users((user_id));
				uDao.delete(p3);
				break;
				
		}				
				
				
		

	}

}
