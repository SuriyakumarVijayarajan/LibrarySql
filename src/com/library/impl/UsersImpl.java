package com.library.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.library.connection.*;
import com.library.dao.UsersDao;
import com.library.model.*;

public class UsersImpl implements UsersDao{
	public boolean insert(Users user)  {
		
		String query="insert into user_details (user_name,city,password,mobile_no,email_id) values (?,?,?,?,?)";
		try {
		Connection con=ConnectionUtil.getDBConnect();
		PreparedStatement pstmt = con.prepareStatement(query);
		
		pstmt.setString(1,user.getUser_name());
		pstmt.setString(2, user.getCity());
		pstmt.setString(3,user.getPassword());
		pstmt.setLong(4, user.getMobile_no());
		pstmt.setString(5, user.getEmail_id());
		
		int i = pstmt.executeUpdate();
		if(i>0)
			return true;
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
		
		//System.out.println(i+"rows inserted successfully");
		
	}
public boolean adminInsert(Users user)  {
		
		String query="insert into user_details (user_name,city,user_role,password,mobile_no,email_id) values (?,?,?,?,?,?)";
		try {
		Connection con=ConnectionUtil.getDBConnect();
		PreparedStatement pstmt = con.prepareStatement(query);
		System.out.println("hi");
		
		pstmt.setString(1,user.getUser_name());
		pstmt.setString(2, user.getCity());
		pstmt.setString(3, user.getUser_role());
		pstmt.setString(4,user.getPassword());
		pstmt.setLong(5, user.getMobile_no());
		pstmt.setString(6, user.getEmail_id());
		System.out.println(user.getCity()+user.getEmail_id()+user.getMobile_no()+user.getPassword()+user.getUser_name()+user.getUser_role());
		int i = pstmt.executeUpdate();
		if(i>0)
			return true;
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
		
		//System.out.println(i+"rows inserted successfully");
		
	}
	
	
public String fetch(Users user) {
	
	String query="select user_name,password from user_details where user_name in ? and password in ?";
	try {
	Connection con=ConnectionUtil.getDBConnect();
	PreparedStatement pstmt = con.prepareStatement(query);
	pstmt.setString(1, user.getUser_name());
	pstmt.setString(2, user.getPassword());
	ResultSet rs = pstmt.executeQuery();
	if(rs.next()) {
		String query1="select user_role from user_details where user_name in ?";
		PreparedStatement pstmt1 = con.prepareStatement(query1);
		pstmt1.setString(1, user.getUser_name());
		ResultSet rs1 = pstmt1.executeQuery();
		rs1.next();
		return rs1.getString(1);
	}
	}catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
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

public void delete(Users user)  {
	
	String query="delete from user_details where user_id=?";
	try {
	Connection con=ConnectionUtil.getDBConnect();
	PreparedStatement pstmt = con.prepareStatement(query);
	
	pstmt.setString(1,user.getPassword());
	
     int i = pstmt.executeUpdate();
	
	System.out.println(i+"rows deleted successfully");
	}catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}


public void update(Users user)  {
	// TODO Auto-generated method stub
	String query="update user_details set fine_amount=? where user_name=?";
	try {
	Connection con=ConnectionUtil.getDBConnect();
	PreparedStatement pstmt=con.prepareStatement(query);
	pstmt.setInt(1, user.getFine_amount());
	pstmt.setString(2, user.getUser_name());
	int i=pstmt.executeUpdate();
	System.out.println(i);
	}catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}
public int getFine(Users user)  {
	// TODO Auto-generated method stub
	String query="Select fine_amount from user_details where user_name in ?";
	try {
	Connection con=ConnectionUtil.getDBConnect();
	PreparedStatement pstmt=con.prepareStatement(query);
	pstmt.setString(1, user.getUser_name());
	ResultSet rs=pstmt.executeQuery();
	while(rs.next()) {
		return rs.getInt(1);
	}
	
	}catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return 0;
}
public int setFine(Users user)  {
	// TODO Auto-generated method stub
	String query1="select userwallet,fine_amount from user_details where user_name in ?";
	String query="update user_details set userwallet =?,fine_amount=0 where user_name in ?";
	try {
	Connection con=ConnectionUtil.getDBConnect();
	PreparedStatement pstmt=con.prepareStatement(query1);
	
	pstmt.setString(1, user.getUser_name());
	ResultSet rs=pstmt.executeQuery();
	int userWallet=0;
	while(rs.next()) {
		userWallet=rs.getInt(1)-rs.getInt(2);
		System.out.println(user.getFine_amount());
	
	}
	
	PreparedStatement pstmt1=con.prepareStatement(query);
	System.out.println(userWallet);
	pstmt1.setInt(1, userWallet);
	//pstmt1.setInt(2, u3.getFine_amount());
	pstmt1.setString(2, user.getUser_name());
	pstmt1.executeUpdate();
	}catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return 0;
	
	
}



}

