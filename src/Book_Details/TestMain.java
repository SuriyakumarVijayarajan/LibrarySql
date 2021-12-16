package Book_Details;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class TestMain {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Scanner sc = new Scanner(System.in);
		Connection con=ConnectionUtil.getDBConnect();
		System.out.println("Connection established");
		BooksDao bDao = new BooksDao();
		System.out.println("Enter your choice");
		int choice=Integer.parseInt(sc.nextLine());
		System.out.println("Enter product Details");
		String pDetail=sc.nextLine();
		
		switch(choice){
			
		case 1:
			Books p1=new Books(pDetail.split(",")[0],pDetail.split(",")[1],
			pDetail.split(",")[2],pDetail.split(",")[3],Integer.parseInt(pDetail.split(",")[4]),pDetail.split(",")[5],
			pDetail.split(",")[6],pDetail.split(",")[7]);
			bDao.insert(p1);
			break;
			
//		case 2:
//						
//			Books p2=new Books((pDetail));
//				
//			bDao.update(p2);
//		    break;
//			
//		case 3:            
//				Books p3=new Books((pDetail));
//				bDao.delete(p3);
//				break;
//				
		}				
//				
				
		

	}

}
