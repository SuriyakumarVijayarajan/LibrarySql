package Supplier_Details;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class TestMain {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Scanner sc = new Scanner(System.in);
		Connection con=ConnectionUtil.getDBConnect();
		System.out.println("Connection established");
		SuppliersDao sDao = new SuppliersDao();
		System.out.println("Enter your choice");
		int choice=Integer.parseInt(sc.nextLine());
		System.out.println("Enter Supplier Details");
		String pDetail=sc.nextLine();
		
		switch(choice){
			
		case 1:
			Suppliers p1=new Suppliers(pDetail.split(",")[0],pDetail.split(",")[1],
			pDetail.split(",")[2],Integer.parseInt(pDetail.split(",")[3]));
			sDao.insert(p1);
			break;
			
		case 2:
						
			Suppliers p2=new Suppliers((pDetail));
				
			sDao.update(p2);
		    break;
			
		case 3:            
				Suppliers p3=new Suppliers((pDetail));
				sDao.delete(p3);
				break;
				
		}				
				
				
		

	}

}
