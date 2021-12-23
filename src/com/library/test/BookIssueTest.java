package com.library.test;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Scanner;

import com.library.connection.*;
import com.library.dao.impl.*;
import com.library.model.*;

public class BookIssueTest {
	

		public static void main(String[] args) throws ClassNotFoundException, SQLException, ParseException {
			
			Scanner sc = new Scanner(System.in);
			Connection con=ConnectionUtil.getDBConnect();
			System.out.println("Connection established");
			BookIssueDaoImpl biDao = new BookIssueDaoImpl();
			System.out.println("Enter your choice ");
			int choice=Integer.parseInt(sc.nextLine());
			System.out.println("Enter Book Issue Details");
			String pDetail=sc.nextLine();
			System.out.println("Enter Book Issue no");
			int book_issue_no=Integer.parseInt(sc.nextLine());
			System.out.println("Enter User Name");
			String user_name=sc.nextLine();
			System.out.println("Enter Book Code");
			String book_title=sc.nextLine();
			System.out.println("Enter Date Issue");
			String date_issue1=sc.nextLine();
			LocalDate date_issue = LocalDate.parse(date_issue1);
			System.out.println("Enter Date Return");
			String date_return1=sc.nextLine();
			LocalDate date_return = LocalDate.parse(date_return1);
			System.out.println("Enter Date Returned");
			String date_returned1=sc.nextLine();
			LocalDate date_returned = LocalDate.parse(date_returned1);
			System.out.println("Enter Fine Range");
			int fine_range=Integer.parseInt(sc.nextLine());
			BookIssue p1=new BookIssue(book_issue_no,user_name,book_title);
			
			switch(choice){
				
			case 1:
				
				biDao.insert(p1);
				break;
				
			case 2:
							
					
				biDao.update(p1);
			    break;
				
			case 3:  
				
					biDao.delete(p1);
					break;
					
			}				
					
					
			

		}

	

}
