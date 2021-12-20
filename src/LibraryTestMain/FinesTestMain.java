package LibraryTestMain;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import com.library.connection.*;
import com.library.dao.*;
import com.library.pojo.*;

public class FinesTestMain {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Scanner sc = new Scanner(System.in);
		Connection con=ConnectionUtil.getDBConnect();
		System.out.println("Connection established");
		FinesDao fDao = new FinesDao();
		System.out.println("Enter your choice");
		int choice=Integer.parseInt(sc.nextLine());
		System.out.println("Enter Fine_range");
		int fine_range=Integer.parseInt(sc.nextLine());
		System.out.println("Enter Fine_amount");
		int fine_amount=Integer.parseInt(sc.nextLine());
		System.out.println(fine_range);
		switch(choice){
			
		case 1:
			Fines p1=new Fines(fine_range,fine_amount);
			fDao.insert(p1);
			break;
			
		case 2:
						
			Fines p2=new Fines(fine_range,fine_amount);
				
			fDao.update(p2);
		    break;
			
		case 3:            
				Fines p3=new Fines(fine_range);
				fDao.delete(p3);
				break;
				
		}				
				
				
		

	}

}
