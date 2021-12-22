package com.library.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.library.connection.*;
import com.library.pojo.*;


public class BookIssueDao {
	
	public void insert(BookIssue p1) throws SQLException, ClassNotFoundException {
		
		String query="insert into book_issue_details (book_issue_no,user_name,book_title,date_issue,date_return,date_returned) values (?,?,?,?,?,?)";
		Connection con=ConnectionUtil.getDBConnect();
		PreparedStatement pstmt = con.prepareStatement(query);
		
		pstmt.setInt(1,p1.getBook_issue_id());
		pstmt.setString(2, p1.getUser_name());
		pstmt.setString(3, p1.getBook_code());
		pstmt.setDate(4, java.sql.Date.valueOf(p1.getDate_issue()));
		pstmt.setDate(5, java.sql.Date.valueOf(p1.getDate_return()));
		pstmt.setDate(6, java.sql.Date.valueOf(p1.getDate_returned()));
		int i = pstmt.executeUpdate();
		
		System.out.println(i+"rows inserted successfully");
		
	}
	
	public void update(BookIssue p1) throws SQLException, ClassNotFoundException {
		
		String query="update book_issue_details set fine_range_in_month=? where user_name=?";
		Connection con=ConnectionUtil.getDBConnect();
		PreparedStatement pstmt = con.prepareStatement(query);
		
		pstmt.setInt(1,p1.getFine_range());
		pstmt.setString(2,p1.getUser_name());
		
         int i = pstmt.executeUpdate();
		
		System.out.println(i+"rows inserted successfully");
	}
	
public void delete(BookIssue p1) throws SQLException, ClassNotFoundException {
		
		String query="delete book_issue_details where book_issue_no=?";
		Connection con=ConnectionUtil.getDBConnect();
		PreparedStatement pstmt = con.prepareStatement(query);
		
		pstmt.setInt(1,p1.getBook_issue_id());
		
         int i = pstmt.executeUpdate();
		
		System.out.println(i+"rows deleted successfully");
	}

public int returnBookIssue(String date_returned,String book_title) {
	// TODO Auto-generated method stub
	String query= "update book_issue_details set date_returned = ? where book_title in ?";
	String query1="Update BOOK_ISSUE_DETAILS set FINE_RANGE_IN_MONTH = (Round(Months_between(DATE_RETURNED,DATE_RETURN)))";
	
	Connection con=null;
	try {
		con=ConnectionUtil.getDBConnect();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	PreparedStatement pstmt = null;
	try {
		pstmt = con.prepareStatement(query);
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	try {
		pstmt.setString(1,date_returned);
		pstmt.setString(2,book_title);
		int rs=pstmt.executeUpdate();
		pstmt=con.prepareStatement(query1);
		int rs1=pstmt.executeUpdate();
		String query2="select fine_range_in_month from book_issue_details where book_title in ? and date_returned in ?";
		PreparedStatement pstmt1=con.prepareStatement(query2);
		pstmt1.setString(1,book_title);
		pstmt1.setString(2, date_returned);
		ResultSet rs2=pstmt1.executeQuery();
		
		while(rs2.next()) {
			return rs2.getInt(1);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return 0;
	
	
}


}
