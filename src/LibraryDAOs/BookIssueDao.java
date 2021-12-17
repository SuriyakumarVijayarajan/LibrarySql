package LibraryDAOs;

import java.sql.Connection;

import LibraryPojo.*;
import Connection.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class BookIssueDao {
	
	public void insert(BookIssue p1) throws SQLException, ClassNotFoundException {
		
		String query="insert into book_issue_details (book_issue_no, user_id, book_code,date_issue,date_return,date_returned,fine_range) values (?,?,?,?,?,?,?)";
		Connection con=ConnectionUtil.getDBConnect();
		PreparedStatement pstmt = con.prepareStatement(query);
		
		pstmt.setInt(1,p1.getBook_issue_id());
		pstmt.setInt(2, p1.getUser_id());
		pstmt.setString(3, p1.getBook_code());
		pstmt.setString(4, p1.getDate_issue());
		pstmt.setString(5, p1.getDate_return());
		pstmt.setString(6, p1.getDate_returned());
		pstmt.setInt(7, p1.getFine_range());
		
		int i = pstmt.executeUpdate();
		
		System.out.println(i+"rows inserted successfully");
		
	}
	
	public void update(BookIssue p1) throws SQLException, ClassNotFoundException {
		
		String query="update products set fine_range=? where user_id=?";
		Connection con=ConnectionUtil.getDBConnect();
		PreparedStatement pstmt = con.prepareStatement(query);
		
		pstmt.setInt(1,p1.getFine_range());
		pstmt.setInt(2,p1.getUser_id());
		
         int i = pstmt.executeUpdate();
		
		System.out.println(i+"rows inserted successfully");
	}
	
public void delete(BookIssue p1) throws SQLException, ClassNotFoundException {
		
		String query="delete products where book_issue_no=?";
		Connection con=ConnectionUtil.getDBConnect();
		PreparedStatement pstmt = con.prepareStatement(query);
		
		pstmt.setInt(1,p1.getBook_issue_id());
		
         int i = pstmt.executeUpdate();
		
		System.out.println(i+"rows deleted successfully");
	}

}
