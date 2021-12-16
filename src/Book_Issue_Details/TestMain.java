package Book_Issue_Details;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import User_Details.Users;
import User_Details.UsersDao;
public class TestMain {
	

		public static void main(String[] args) throws ClassNotFoundException, SQLException {
			
			Scanner sc = new Scanner(System.in);
			Connection con=ConnectionUtil.getDBConnect();
			System.out.println("Connection established");
			BookIssueDao biDao = new BookIssueDao();
			System.out.println("Enter your choice ");
			int choice=Integer.parseInt(sc.nextLine());
			System.out.println("Enter User Details");
			String pDetail=sc.nextLine();
			
			switch(choice){
				
			case 1:
				BookIssue p1=new BookIssue(pDetail.split(",")[0],pDetail.split(",")[1],
				pDetail.split(",")[2],pDetail.split(",")[3],pDetail.split(",")[4],
				pDetail.split(",")[5]);
				biDao.insert(p1);
				break;
				
			case 2:
							
				Users p2=new Users((pDetail));
					
				uDao.update(p2);
			    break;
				
			case 3:            
					Users p3=new Users((pDetail));
					uDao.delete(p3);
					break;
					
			}				
					
					
			

		}

	


}
