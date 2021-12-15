package Book_Issue_Details;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import User_Details.ConnectionUtil;
import User_Details.Users;

public class BookIssueDao {
	
	public void insert(BookIssue p1) throws SQLException, ClassNotFoundException {
		
		String query="insert into book_issue_details (book_issue_id, user_id, book_code,date_issue,date_return,date_returned,fine_range) values (?,?,?,?,?,?,?)";
		Connection con=ConnectionUtil.getDBConnect();
		PreparedStatement pstmt = con.prepareStatement(query);
		
		pstmt.setInt(1,p1.getBook_issue_id());
		pstmt.setString(2, p1.getUser_id());
		pstmt.setString(3, p1.getBook_code());
		pstmt.setString(4, p1.getDate_issue());
		pstmt.setString(5, p1.getDate_return());
		pstmt.setString(6, p1.getDate_returned());
		pstmt.setString(7, p1.getFine_range());
		
		int i = pstmt.executeUpdate();
		
		System.out.println(i+"rows inserted successfully");
		
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

}
