package LibraryTestMain;
import java.sql.Connection;
import LibraryDAOs.*;
import LibraryPojo.*;
import Connection.*;
import java.sql.SQLException;
import java.util.Scanner;

public class BookIssueTestMain {
	

		public static void main(String[] args) throws ClassNotFoundException, SQLException {
			
			Scanner sc = new Scanner(System.in);
			Connection con=ConnectionUtil.getDBConnect();
			System.out.println("Connection established");
			BookIssueDao biDao = new BookIssueDao();
			System.out.println("Enter your choice ");
			int choice=Integer.parseInt(sc.nextLine());
			System.out.println("Enter Book Issue Details");
			String pDetail=sc.nextLine();
			System.out.println("Enter Book Issue no");
			int book_issue_no=Integer.parseInt(sc.nextLine());
			System.out.println("Enter User ID");
			int user_id=Integer.parseInt(sc.nextLine());
			System.out.println("Enter Book Code");
			String book_code=sc.nextLine();
			System.out.println("Enter Date Issue");
			String date_issue=sc.nextLine();
			System.out.println("Enter Date Return");
			String date_return=sc.nextLine();
			System.out.println("Enter Date Returned");
			String date_returned=sc.nextLine();
			System.out.println("Enter Fine Range");
			int fine_range=Integer.parseInt(sc.nextLine());
			BookIssue p1=new BookIssue(book_issue_no,user_id,book_code,date_issue,date_return,date_returned,fine_range);
			
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
