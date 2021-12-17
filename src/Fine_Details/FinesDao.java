package Fine_Details;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FinesDao {
	public void insert(Fines p1) throws SQLException, ClassNotFoundException {
		
		String query="insert into fine_details (fine_range,fine_amount) values (?,?)";
		Connection con=ConnectionUtil.getDBConnect();
		PreparedStatement pstmt = con.prepareStatement(query);
		
		pstmt.setString(1,p1.getFine_range());
		pstmt.setInt(2, p1.getFine_amount());
	
		int i = pstmt.executeUpdate();
		
		System.out.println(i+"rows inserted successfully");
		
	}
	
	public void update(Fines p2) throws SQLException, ClassNotFoundException {
		
		String query="update fine_details set fine_range=? where fine_amount=100";
		Connection con=ConnectionUtil.getDBConnect();
		PreparedStatement pstmt = con.prepareStatement(query);
		
		pstmt.setInt(1,p2.getFine_amount());
		
         int i = pstmt.executeUpdate();
		
		System.out.println(i+"rows inserted successfully");
	}
	
public void delete(Fines p2) throws SQLException, ClassNotFoundException {
		
		String query="delete fine_details where category_id=?";
		Connection con=ConnectionUtil.getDBConnect();
		PreparedStatement pstmt = con.prepareStatement(query);
		
		pstmt.setInt(1,p2.getFine_amount());
		
         int i = pstmt.executeUpdate();
		
		System.out.println(i+"rows deleted successfully");
	}

}

