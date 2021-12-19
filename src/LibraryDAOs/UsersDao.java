package LibraryDAOs;
import java.sql.Connection;
import LibraryPojo.*;
import Connection.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersDao {
	public boolean insert(Users p1) throws SQLException, ClassNotFoundException {
		
		String query="insert into user_details (user_name,city,password,mobile_no,email_id) values (?,?,?,?,?)";
		Connection con=ConnectionUtil.getDBConnect();
		PreparedStatement pstmt = con.prepareStatement(query);
		
		pstmt.setString(1,p1.getUser_name());
		pstmt.setString(2, p1.getCity());
		pstmt.setString(3,p1.getPassword());
		pstmt.setLong(4, p1.getMobile_no());
		pstmt.setString(5, p1.getEmail_id());
		
		int i = pstmt.executeUpdate();
		if(i>0)
			return true;
		
		return false;
		
		//System.out.println(i+"rows inserted successfully");
		
	}
	
	
public String fetch(String uname,String pass) throws ClassNotFoundException, SQLException {
	
	String query="select user_name,password from user_details where user_name in ? and password in ?";
	Connection con=ConnectionUtil.getDBConnect();
	PreparedStatement pstmt = con.prepareStatement(query);
	pstmt.setString(1, uname);
	pstmt.setString(2, pass);
	ResultSet rs = pstmt.executeQuery();
	if(rs.next()) {
		String query1="select user_role from user_details where user_name in ?";
		PreparedStatement pstmt1 = con.prepareStatement(query1);
		pstmt1.setString(1, uname);
		ResultSet rs1 = pstmt1.executeQuery();
		rs1.next();
		return rs1.getString(1);
	}
	return "invalid";
	
}

public void update(Users p2) throws SQLException, ClassNotFoundException {
	
	String query="update products set fine_amount=? where user_id=?";
	Connection con=ConnectionUtil.getDBConnect();
	PreparedStatement pstmt = con.prepareStatement(query);
	
	pstmt.setInt(1,p2.getFine_amount());
	pstmt.setInt(2, p2.getUser_id());
	
     int i = pstmt.executeUpdate();
	
	System.out.println(i+"rows inserted successfully");
}

public void delete(Users p2) throws SQLException, ClassNotFoundException {
	
	String query="delete products where category_id=?";
	Connection con=ConnectionUtil.getDBConnect();
	PreparedStatement pstmt = con.prepareStatement(query);
	
	pstmt.setString(1,p2.getPassword());
	
     int i = pstmt.executeUpdate();
	
	System.out.println(i+"rows deleted successfully");
}

}

