package com.library.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.library.connection.*;
import com.library.dao.BookIssueDao;
import com.library.model.*;


public class BookIssueImpl implements BookIssueDao {
	
	public void insert(BookIssue bookIssue)  {
		
		String query="insert into book_issue_details (user_name,book_title,date_issue,date_return,date_returned) values (?,?,?,?,?)";
		
		try {
		Connection con=ConnectionUtil.getDBConnect();
		PreparedStatement pstmt = con.prepareStatement(query);
		
		pstmt.setString(1, bookIssue.getUser_name());
		pstmt.setString(2, bookIssue.getBook_code());
		pstmt.setDate(3, java.sql.Date.valueOf(bookIssue.getDate_issue()));
		pstmt.setDate(4, java.sql.Date.valueOf(bookIssue.getDate_return()));
		pstmt.setDate(5, java.sql.Date.valueOf(bookIssue.getDate_returned()));
		int i = pstmt.executeUpdate();
		
		System.out.println(i+"rows inserted successfully");
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void update(BookIssue bookIssue)  {
		
		String query="update book_issue_details set fine_range_in_month=? where user_name=?";
		try {
		Connection con=ConnectionUtil.getDBConnect();
		PreparedStatement pstmt = con.prepareStatement(query);
		
		pstmt.setInt(1,bookIssue.getFine_range());
		pstmt.setString(2,bookIssue.getUser_name());
		
         int i = pstmt.executeUpdate();
		
		System.out.println(i+"rows inserted successfully");
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
public void delete(BookIssue bookIssue)  {
		
		String query="delete book_issue_details where book_issue_no=?";
		try {
		Connection con=ConnectionUtil.getDBConnect();
		PreparedStatement pstmt = con.prepareStatement(query);
		
		pstmt.setInt(1,bookIssue.getBook_issue_id());
		
         int i = pstmt.executeUpdate();
		
		System.out.println(i+"rows deleted successfully");
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

public int getBookIssueNo(BookIssue book) {
	
	String query="Select book_issue_no from book_issue_details where user_name in ? and book_title in ? and date_issue in ? and date_return in ?";
	
	try {
		Connection con=ConnectionUtil.getDBConnect();
		PreparedStatement pstmt=con.prepareStatement(query);
		pstmt.setString(1, book.getUser_name());
		pstmt.setString(2, book.getBook_code());
		pstmt.setDate(3, java.sql.Date.valueOf(book.getDate_issue()));
		pstmt.setDate(4, java.sql.Date.valueOf(book.getDate_return()));
		
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()){
			return rs.getInt(1);
		}
	}catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return 0;
	
}

public int returnBookIssue(BookIssue bookIssue) {
	// TODO Auto-generated method stub
	String query= "update book_issue_details set date_returned = ? where book_issue_no in ?";
	String query1="Update BOOK_ISSUE_DETAILS set FINE_RANGE_IN_MONTH = (Round(Months_between(DATE_RETURNED,DATE_RETURN)))";
	
	Connection con=null;
	try {
		System.out.println("Return Book Issue");
		System.out.println(bookIssue.getBook_code());
		con=ConnectionUtil.getDBConnect();
		PreparedStatement pstmt = null;
		pstmt = con.prepareStatement(query);
		pstmt.setString(1,bookIssue.getDate_returned());
		pstmt.setInt(2,bookIssue.getBook_issue_id());
		int rs=pstmt.executeUpdate();
		pstmt=con.prepareStatement(query1);
		int rs1=pstmt.executeUpdate();
		String query2="select fine_range_in_month from book_issue_details where book_issue_no in ?";
		PreparedStatement pstmt1=con.prepareStatement(query2);
		pstmt1.setInt(1,bookIssue.getBook_issue_id());
		ResultSet rs2=pstmt1.executeQuery();
		
		while(rs2.next()) {
			return rs2.getInt(1);
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return 0;
	
	
}


}
