package com.library.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.library.connection.ConnectionUtil;
import com.library.dao.OrderBookDao;
import com.library.model.OrderBook;
import com.library.model.Suppliers;

public class OrderBookImpl implements OrderBookDao {
	
	public void insert(OrderBook orderBook)  {
		
		String query="insert into order_book (user_name,book_name,author,supplier_name) values (?,?,?,?)";
		try {
		Connection con=ConnectionUtil.getDBConnect();
		PreparedStatement pstmt = con.prepareStatement(query);
		
		pstmt.setString(1,orderBook.getUser_name());
		pstmt.setString(2, orderBook.getBook_name());
		pstmt.setString(3, orderBook.getAuthor());
		pstmt.setString(4, orderBook.getSupplier_id());
	
		
		int i = pstmt.executeUpdate();
		
		System.out.println(i+"rows inserted successfully");
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void update(OrderBook orderBook)  {
		
		String query="update order_book set supplier_name=? where book_name=?";
		try {
		Connection con=ConnectionUtil.getDBConnect();
		PreparedStatement pstmt = con.prepareStatement(query);
		
		pstmt.setString(1,orderBook.getSupplier_id());
		pstmt.setString(2,orderBook.getBook_name());
		
         int i = pstmt.executeUpdate();
		
		System.out.println(i+"rows updated successfully");
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
public void delete(OrderBook orderBook)  {
		
		String query="delete order_book where book_name=?";
		try {
		Connection con=ConnectionUtil.getDBConnect();
		PreparedStatement pstmt = con.prepareStatement(query);
		
		pstmt.setString(1,orderBook.getBook_name());
		
         int i = pstmt.executeUpdate();
		
		System.out.println(i+"rows deleted successfully");
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

public ResultSet view(OrderBook order)  {
	// TODO Auto-generated method stub
	String query="select * from order_book where supplier_name in ?";
	ResultSet rs=null;
	try {
	Connection con=ConnectionUtil.getDBConnect();
	PreparedStatement pstmt=con.prepareStatement(query);
	pstmt.setString(1, order.getUser_name());
	rs=pstmt.executeQuery();
	}catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return rs;
	
}	

}
