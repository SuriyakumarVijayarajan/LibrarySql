package LibraryDAOs;
import java.sql.Connection;
import LibraryPojo.*;
import Connection.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FinesDao {
	public void insert(Fines p1) throws SQLException, ClassNotFoundException {
		
		String query="insert into fine_details (fine_range_in_month,fine_amount) values (?,?)";
		Connection con=ConnectionUtil.getDBConnect();
		PreparedStatement pstmt = con.prepareStatement(query);
		
		pstmt.setInt(1,p1.getFine_range());
		pstmt.setInt(2, p1.getFine_amount());
	
		int i = pstmt.executeUpdate();
		
		System.out.println(i+"rows inserted successfully");
		
	}
	
	public void update(Fines p2) throws SQLException, ClassNotFoundException {
		
		String query="update fine_details set fine_amount=? where fine_range_in_month=?";
		Connection con=ConnectionUtil.getDBConnect();
		PreparedStatement pstmt = con.prepareStatement(query);
		
		pstmt.setInt(1,p2.getFine_amount());
		pstmt.setInt(2,p2.getFine_range() );
		
         int i = pstmt.executeUpdate();
		
		System.out.println(i+"rows updated successfully");
	}
	
public void delete(Fines p2) throws SQLException, ClassNotFoundException {
		
		String query="delete fine_details where fine_range_in_month=?";
		Connection con=ConnectionUtil.getDBConnect();
		PreparedStatement pstmt = con.prepareStatement(query);
		
		pstmt.setInt(1,p2.getFine_range());
		
         int i = pstmt.executeUpdate();
		
		System.out.println(i+"rows deleted successfully");
	}

}

