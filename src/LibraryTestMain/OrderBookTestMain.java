package LibraryTestMain;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import com.library.connection.ConnectionUtil;
import com.library.dao.OrderBookDao;
import com.library.dao.SuppliersDao;
import com.library.pojo.OrderBook;
import com.library.pojo.Suppliers;

public class OrderBookTestMain {

public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Scanner sc = new Scanner(System.in);
		Connection con=ConnectionUtil.getDBConnect();
		System.out.println("Connection established");
		OrderBookDao obDao = new OrderBookDao();
		System.out.println("Enter your choice");
		int choice=Integer.parseInt(sc.nextLine());
		
		
		switch(choice){
			
		case 1:
			System.out.println("Enter User Name");
			String user_name=sc.nextLine();
			System.out.println("Enter Book name");
			String book_name=sc.nextLine();
			System.out.println("Enter Author");
			String author=sc.nextLine();
			System.out.println("Enter Contact");
			String supplier_id=sc.nextLine();
			OrderBook p1=new OrderBook(user_name,book_name,author,supplier_id);
			obDao.insert(p1);
			break;
			
		case 2:
			System.out.println("Enter Supplier Id");
			supplier_id=sc.nextLine();	
			System.out.println("Enter book name");
			book_name=sc.nextLine();
		//	OrderBook p2=new OrderBook(supplier_id,book_name);
				
			obDao.update(supplier_id,book_name);
		    break;
			
		case 3:
			System.out.println("Enter book name");
			book_name=sc.nextLine();
	//			OrderBook p3=new OrderBook((book_name));
				obDao.delete(book_name);
				break;
				
	}	
}
}
