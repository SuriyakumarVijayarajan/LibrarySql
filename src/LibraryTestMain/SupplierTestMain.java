package LibraryTestMain;

import java.sql.Connection;
import LibraryDAOs.*;
import LibraryPojo.*;
import Connection.*;
import java.sql.SQLException;
import java.util.Scanner;

public class SupplierTestMain {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Scanner sc = new Scanner(System.in);
		Connection con=ConnectionUtil.getDBConnect();
		System.out.println("Connection established");
		SuppliersDao sDao = new SuppliersDao();
		System.out.println("Enter your choice");
		int choice=Integer.parseInt(sc.nextLine());
		System.out.println("Enter Supplier Id");
		String supplier_id=sc.nextLine();
		System.out.println("Enter Supplier Name");
		String supplier_name=sc.nextLine();
		System.out.println("Enter Address");
		String address=sc.nextLine();
		System.out.println("Enter Contact");
		long contact=Long.parseLong(sc.nextLine());
		
		switch(choice){
			
		case 1:
			Suppliers p1=new Suppliers(supplier_id,supplier_name,address,contact);
			sDao.insert(p1);
			break;
			
//		case 2:
//						
//			Suppliers p2=new Suppliers((pDetail));
//				
//			sDao.update(p2);
//		    break;
//			
//		case 3:            
//				Suppliers p3=new Suppliers((pDetail));
//				sDao.delete(p3);
//				break;
//				
	}				
				
			
		

	}

}
