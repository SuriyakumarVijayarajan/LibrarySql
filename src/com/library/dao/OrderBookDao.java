package com.library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.library.connection.ConnectionUtil;
import com.library.pojo.OrderBook;
import com.library.pojo.Suppliers;

public class OrderBookDao {
	
	public void insert(OrderBook p1)  {
		
		String query="insert into order_book (user_name,book_name,author,supplier_name) values (?,?,?,?)";
		try {
		Connection con=ConnectionUtil.getDBConnect();
		PreparedStatement pstmt = con.prepareStatement(query);
		
		pstmt.setString(1,p1.getUser_name());
		pstmt.setString(2, p1.getBook_name());
		pstmt.setString(3, p1.getAuthor());
		pstmt.setString(4, p1.getSupplier_id());
	
		
		int i = pstmt.executeUpdate();
		
		System.out.println(i+"rows inserted successfully");
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void update(String supplier_name,String book_name)  {
		
		String query="update order_book set supplier_name=? where book_name=?";
		try {
		Connection con=ConnectionUtil.getDBConnect();
		PreparedStatement pstmt = con.prepareStatement(query);
		
		pstmt.setString(1,supplier_name);
		pstmt.setString(2,book_name);
		
         int i = pstmt.executeUpdate();
		
		System.out.println(i+"rows updated successfully");
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
public void delete(String book_name)  {
		
		String query="delete order_book where book_name=?";
		try {
		Connection con=ConnectionUtil.getDBConnect();
		PreparedStatement pstmt = con.prepareStatement(query);
		
		pstmt.setString(1,book_name);
		
         int i = pstmt.executeUpdate();
		
		System.out.println(i+"rows deleted successfully");
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

public ResultSet view(String user_name)  {
	// TODO Auto-generated method stub
	String query="select * from order_book where supplier_name in ?";
	ResultSet rs=null;
	try {
	Connection con=ConnectionUtil.getDBConnect();
	PreparedStatement pstmt=con.prepareStatement(query);
	pstmt.setString(1, user_name);
	rs=pstmt.executeQuery();
	}catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return rs;
	
}	

}
