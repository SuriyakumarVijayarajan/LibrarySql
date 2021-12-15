package User_Details;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersDao {
	public boolean insert(Users p1) throws SQLException, ClassNotFoundException {
		
		String query="insert into user_details (user_id,user_name,city,date_register,date_expire,user_role,password) values (?,?,?,?,?,?,?)";
		Connection con=ConnectionUtil.getDBConnect();
		PreparedStatement pstmt = con.prepareStatement(query);
		
		pstmt.setString(1,p1.getUser_id());
		pstmt.setString(2, p1.getUser_name());
		pstmt.setString(3, p1.getCity());
		pstmt.setString(4, p1.getDate_register());
		pstmt.setString(5, p1.getDate_expire());
		pstmt.setString(6, p1.getUser_role());
		pstmt.setString(7, p1.getPassword());
		
		int i = pstmt.executeUpdate();
		if(i>0)
			return true;
		
		return false;
		
		//System.out.println(i+"rows inserted successfully");
		
	}
	
	public void update(Users p2) throws SQLException, ClassNotFoundException {
		
		String query="update products set category_id=? where product_id=100";
		Connection con=ConnectionUtil.getDBConnect();
		PreparedStatement pstmt = con.prepareStatement(query);
		
		pstmt.setString(1,p2.getPassword());
		
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

}

