package LibraryTestMain;
import java.sql.Connection;
import LibraryDAOs.*;
import LibraryPojo.*;
import Connection.*;
import java.sql.SQLException;
import java.util.Scanner;

public class BooksTestMain {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Scanner sc = new Scanner(System.in);
		Connection con=ConnectionUtil.getDBConnect();
		System.out.println("Connection established");
		BooksDao bDao = new BooksDao();
		System.out.println("Enter your choice");
		int choice=Integer.parseInt(sc.nextLine());
		
		
		switch(choice){
			
		case 1:
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
			bDao.insert(p1);
			break;
			
		case 2:
			System.out.println("Enter book_code");
			book_code=sc.nextLine();
			System.out.println("Enter availability");
			String availability=sc.nextLine();
	
			Books p2=new Books(book_code,availability);
				
			bDao.update(p2);
		    break;
			
		case 3:    
			System.out.println("Enter book_id");
			book_code=sc.nextLine();
				Books p3=new Books(book_code);
				bDao.delete(p3);
				break;
				
		}				
			
				
		

	}

}
