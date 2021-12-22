package com.library.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.library.connection.*;
import com.library.pojo.*;

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
public boolean adminInsert(Users p1) throws SQLException, ClassNotFoundException {
		
		String query="insert into user_details (user_name,city,user_role,password,mobile_no,email_id) values (?,?,?,?,?,?)";
		
		Connection con=ConnectionUtil.getDBConnect();
		PreparedStatement pstmt = con.prepareStatement(query);
		System.out.println("hi");
		
		pstmt.setString(1,p1.getUser_name());
		pstmt.setString(2, p1.getCity());
		pstmt.setString(3, p1.getUser_role());
		pstmt.setString(4,p1.getPassword());
		pstmt.setLong(5, p1.getMobile_no());
		pstmt.setString(6, p1.getEmail_id());
		System.out.println(p1.getCity()+p1.getEmail_id()+p1.getMobile_no()+p1.getPassword()+p1.getUser_name()+p1.getUser_role());
		int i = pstmt.executeUpdate();
		if(i>0)
			return true;
		
		return false;
		
		//System.out.println(i+"rows inserted successfully");
		
	}
	
	
public String fetch(Users u1) throws ClassNotFoundException, SQLException {
	
	String query="select user_name,password from user_details where user_name in ? and password in ?";
	Connection con=ConnectionUtil.getDBConnect();
	PreparedStatement pstmt = con.prepareStatement(query);
	pstmt.setString(1, u1.getUser_name());
	pstmt.setString(2, u1.getPassword());
	ResultSet rs = pstmt.executeQuery();
	if(rs.next()) {
		String query1="select user_role from user_details where user_name in ?";
		PreparedStatement pstmt1 = con.prepareStatement(query1);
		pstmt1.setString(1, u1.getUser_name());
		ResultSet rs1 = pstmt1.executeQuery();
		rs1.next();
		return rs1.getString(1);
	}
	return "invalid";
	
}

//public void update(int fineAmount,String user_name) throws SQLException, ClassNotFoundException {
//	
//	String query="update user_details set fine_amount=? where user_name=?";
//	Connection con = null;
//
//
//			
//		con = ConnectionUtil.getDBConnect();
//	    PreparedStatement pstmt1 = con.prepareStatement(query);
//		
//		pstmt1.setInt(1,fineAmount);
//		pstmt1.setString(2,user_name);
//		int i=pstmt1.executeUpdate();
//		System.out.println(fineAmount);
//		
//
//	
//	
//	System.out.println("rows inserted successfully");
//}

public void delete(Users p2) throws SQLException, ClassNotFoundException {
	
	String query="delete from user_details where user_id=?";
	Connection con=ConnectionUtil.getDBConnect();
	PreparedStatement pstmt = con.prepareStatement(query);
	
	pstmt.setString(1,p2.getPassword());
	
     int i = pstmt.executeUpdate();
	
	System.out.println(i+"rows deleted successfully");
}


public void update(Users u2) throws ClassNotFoundException, SQLException {
	// TODO Auto-generated method stub
	String query="update user_details set fine_amount=? where user_name=?";
	Connection con=ConnectionUtil.getDBConnect();
	PreparedStatement pstmt=con.prepareStatement(query);
	pstmt.setInt(1, u2.getFine_amount());
	pstmt.setString(2, u2.getUser_name());
	int i=pstmt.executeUpdate();
	System.out.println(i);
	
	
}
public int getFine(Users u3) throws Exception {
	// TODO Auto-generated method stub
	String query="Select fine_amount from user_details where user_name in ?";
	Connection con=ConnectionUtil.getDBConnect();
	PreparedStatement pstmt=con.prepareStatement(query);
	pstmt.setString(1, u3.getUser_name());
	ResultSet rs=pstmt.executeQuery();
	while(rs.next()) {
		return rs.getInt(1);
	}
	return 0;
}
public void setFine(Users u3) throws Exception {
	// TODO Auto-generated method stub
	String query="update user_details set fine_amount=0 where user_name in ?";
	Connection con=ConnectionUtil.getDBConnect();
	PreparedStatement pstmt=con.prepareStatement(query);
	pstmt.setString(1, u3.getUser_name());
	pstmt.executeUpdate();
	
	
}



}

