package com.library.main;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.library.dao.*;
import com.library.pojo.*;
public class LibraryApp {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your wish 1.register 2.login");
		String choice=sc.nextLine();
		UsersDao user = null;
		BooksDao book=new BooksDao();
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
				flag=true;
			}while(flag==false);
			
			user = new UsersDao();
			String val = user.fetch(user_name, password);
			System.out.println(val);
			if(val.equals("user")) {
				System.out.println("Welcome "+user_name);
				libUser(user_name);
				
			}else if(val.equals("admin")){
				
				System.out.println("welcome admin "+user_name);
				LibraryAdmin();
			}
			break;
			
			default:
				System.out.println("Please select valid choice");
			
			

			
		}

	}
	
	private static void LibraryAdmin() {
		// TODO Auto-generated method stub
		BooksDao book=new BooksDao();
		SuppliersDao supply=new SuppliersDao();
		BookIssueDao bookIssue=new BookIssueDao();
		FinesDao fine=new FinesDao();
		System.out.println("1.Show Books 2.Add Books 3.Add supplier Details 4.Add Book Issue Details 5.Add Fine Details 6.Add User");
		Scanner sc=new Scanner(System.in);
		int choice=Integer.parseInt(sc.nextLine());
		switch(choice) {
		case 1:
//			ResultSet rs=book.showBooks();
			List Products=book.showBooks();
			for(int i=0;i<Products.size();i++)
			{
				System.out.println(Products.get(i));
				
			}
//			try {
//				while(rs.next()) {
//					System.out.println("Book Name");
//					System.out.println(rs.getString(1));
//					System.out.println("Author");
//					System.out.println(rs.getString(2));
//					System.out.println("Category");
//					System.out.println(rs.getString(3));
//				}
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
		case 2:
			System.out.println("Enter Book_code");
			String book_code=sc.nextLine();
			System.out.println("Enter Book Title");
			String book_title=sc.nextLine();
			System.out.println("Enter Category");
			String category=sc.nextLine();
			System.out.println("Enter Author");
			String author=sc.nextLine();
			System.out.println("Enter Price");
			int price=Integer.parseInt(sc.nextLine());
			System.out.println("Enter Rack Number");
			String rack_number=sc.nextLine();
			System.out.println("Enter Date Arrival");
			String date_arrival=sc.nextLine();
			System.out.println("Enter Supplier Id");
			String supplier_id=sc.nextLine();
			Books p1=new Books(book_code,book_title,category,author,price,rack_number,date_arrival,supplier_id);
			try {
				book.insert(p1);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 3:
			System.out.println("Enter Supplier Id");
			supplier_id=sc.nextLine();
			System.out.println("Enter Supplier Name");
			String supplier_name=sc.nextLine();
			System.out.println("Enter Address");
			String address=sc.nextLine();
			System.out.println("Enter Contact");
			long contact=Long.parseLong(sc.nextLine());
			Suppliers s1=new Suppliers(supplier_id,supplier_name,address,contact);
			try {
				supply.insert(s1);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			
		case 4:
			System.out.println("Enter Book Issue Details");
			String pDetail=sc.nextLine();
			System.out.println("Enter Book Issue no");
			int book_issue_no=Integer.parseInt(sc.nextLine());
			System.out.println("Enter User ID");
			String user_name=sc.nextLine();
			System.out.println("Enter Book Code");
			book_code=sc.nextLine();
			System.out.println("Enter Date Issue");
			String date_issue1=sc.nextLine();
			LocalDate date_issue=LocalDate.parse(date_issue1);
			System.out.println("Enter Date Return");
			String date_return1=sc.nextLine();
			LocalDate date_return=LocalDate.parse(date_return1);
			System.out.println("Enter Date Returned");
			String date_returned1=sc.nextLine();
			LocalDate date_returned=LocalDate.parse(date_returned1);
			System.out.println("Enter Fine Range");
			int fine_range=Integer.parseInt(sc.nextLine());
			BookIssue issue=new BookIssue(book_issue_no,user_name,book_code,date_issue,date_return,date_returned,fine_range);
			try {
				bookIssue.insert(issue);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 5:
			System.out.println("Enter Fine_range");
			fine_range=Integer.parseInt(sc.nextLine());
			System.out.println("Enter Fine_amount");
			int fine_amount=Integer.parseInt(sc.nextLine());
			System.out.println(fine_range);
			Fines fines=new Fines(fine_range,fine_amount);
			try {
				fine.insert(fines);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			
		case 6:
			
		}
		
		
		
		
	}

	public static void libUser(String user_name) throws ClassNotFoundException, SQLException {
		
		System.out.println("1.Search Book 2.View Book 3.Borrow Book 4.Return Book 5.Request New book");
		Scanner sc=new Scanner(System.in);
		UsersDao user=new UsersDao();
		BooksDao book=new BooksDao();
		SuppliersDao supply=new SuppliersDao();
		BookIssueDao bookIssue=new BookIssueDao();
		FinesDao fine=new FinesDao();
		OrderBookDao obDao=new OrderBookDao();
		
		int choice = Integer.parseInt(sc.nextLine());
		System.out.println(choice);
		switch(choice) {
		case 1:
			System.out.println("Search book by 1.Author 2.Category");
			int choice1 = Integer.parseInt(sc.nextLine());
			switch(choice1) {
			case 1:
				System.out.println("Enter Author Name");
				String author=sc.nextLine();
				ResultSet rs=book.authorFetch(author);
				while(rs.next()) {
					System.out.println(rs.getString(1));
					
				}
				break;
			case 2:
				System.out.println("Enter Category");
				String category=sc.nextLine();
				rs=book.categoryFetch(category);
				while(rs.next()) {
					System.out.println(rs.getString(1));
					
				}
				break;
			}
			break;
			
		case 2:
				System.out.println("View books");
				List Products=book.showBooks();
				for(int i=0;i<Products.size();i++)
				{
					System.out.println(Products.get(i));
					
				}
				break;
				
		case 3:
			System.out.println("Enter the book Name you want to Borrow");
			String book_title=sc.nextLine();
			String availability=book.bookBorrow(book_title);
			if(availability.equals("available")) {
				System.out.println("Do you want to borrow the book yes/no");
				String opinion=sc.nextLine();
				if(opinion.equals("yes")) {
					
				System.out.println("Here After admin will takeover");
				System.out.println("Hi admin Enter your user_name");
				String uname=sc.nextLine();
				System.out.println("Enter PassWord");
				String password=sc.nextLine();
				String adminCheck=user.fetch(uname,password);
				if(adminCheck.equals("admin")) {
					book.bookAvail(book_title,user_name);
					int rackNumber=book.getRack(book_title);
					System.out.println("The book is in Rack number "+rackNumber);
					System.out.println("Enter book issue no");
					int book_issue_no=Integer.parseInt(sc.nextLine());
					System.out.println("Enter Date Issue");
					String date_issue1=sc.nextLine();
					LocalDate date_issue=LocalDate.parse(date_issue1);
					System.out.println("Enter Date Return");
					String date_return1=sc.nextLine();
					LocalDate date_return=LocalDate.parse(date_return1);
					LocalDate date_returned=LocalDate.now();
					int fine_range_in_month=0;
					BookIssue p1= new BookIssue(book_issue_no,user_name,book_title,date_issue,date_return,date_returned,fine_range_in_month);
					book.updateBookIssue(book_title,book_issue_no);
					bookIssue.insert(p1);
					
				}
				
				
				
			}
				
			
				
			}
			else {
				System.out.println("The book is unavailable");
			}
			break;
		case 4:
			System.out.println("Enter the name of book you return");
			book_title=sc.nextLine();
			book.returnBook(book_title);
			System.out.println("Hi admin Enter your user_name");
			String uname=sc.nextLine();
			System.out.println("Enter PassWord");
			String password=sc.nextLine();
			String adminCheck=user.fetch(uname,password);
			if(adminCheck.equals("admin")) {
				System.out.println("Enter Date Returned");
				String date_returned=sc.nextLine();
				int userFine=bookIssue.returnBookIssue(date_returned,book_title);
				System.out.println(userFine);
				int fineAmount=fine.fineCalculation(userFine);
				System.out.println("FineAmount= "+fineAmount);
				user.update(fineAmount,user_name);
				
			}
			break;
		case 5:
			System.out.println("Enter the name of book you want to order");
			String book_name=sc.nextLine();
			System.out.println("Enter the author name");
			String author=sc.nextLine();
			String supplier_id=null;
			OrderBook p1=new OrderBook(user_name,book_name,author,supplier_id);
			obDao.insert(p1);
			System.out.println("Here After admin will takeover");
			System.out.println("Hi admin Enter your user_name");
			uname=sc.nextLine();
			System.out.println("Enter PassWord");
			password=sc.nextLine();
			adminCheck=user.fetch(uname,password);
			if(adminCheck.equals("admin")) {
				System.out.println("Enter Supplier Id");
				supplier_id=sc.nextLine();
				obDao.update(supplier_id, book_name);
				
			}
			
			
			
			
			
			
			
			}
			
		}
		
	}


