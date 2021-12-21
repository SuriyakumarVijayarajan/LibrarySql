package com.library.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.library.connection.*;
import com.library.pojo.*;

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
public int fineCalculation(Fines f1) {
	// TODO Auto-generated method stub
	String query="select fine_amount from fine_details where fine_range_in_month in ?";
	Connection con = null;
	try {
		con = ConnectionUtil.getDBConnect();
	} catch (ClassNotFoundException e4) {
		// TODO Auto-generated catch block
		e4.printStackTrace();
	} catch (SQLException e4) {
		// TODO Auto-generated catch block
		e4.printStackTrace();
	}
	PreparedStatement pstmt = null;
	try {
		pstmt = con.prepareStatement(query);
	} catch (SQLException e3) {
		// TODO Auto-generated catch block
		e3.printStackTrace();
	}
	try {
		pstmt.setInt(1,f1.getFine_range());
	} catch (SQLException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	}
	ResultSet rs = null;
	try {
		rs = pstmt.executeQuery();
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	try {
		while(rs.next()) {
			try {
				return rs.getInt(1);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return 0;
	}
	
	
}



