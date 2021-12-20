package com.library.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.library.connection.*;
import com.library.pojo.*;

public class SuppliersDao {
	public void insert(Suppliers p1) throws SQLException, ClassNotFoundException {
		
		String query="insert into supplier_details (supplier_id,supplier_name,address,contact) values (?,?,?,?)";
		Connection con=ConnectionUtil.getDBConnect();
		PreparedStatement pstmt = con.prepareStatement(query);
		
		pstmt.setString(1,p1.getSupplier_id());
		pstmt.setString(2, p1.getSupplier_name());
		pstmt.setString(3, p1.getAddress());
		pstmt.setLong(4, p1.getContact());
	
		
		int i = pstmt.executeUpdate();
		
		System.out.println(i+"rows inserted successfully");
		
	}
	
	public void update(Suppliers p2) throws SQLException, ClassNotFoundException {
		
		String query="update supplier_details set contact=? where supplier_id=?";
		Connection con=ConnectionUtil.getDBConnect();
		PreparedStatement pstmt = con.prepareStatement(query);
		
		pstmt.setString(2,p2.getSupplier_id());
		pstmt.setLong(1,p2.getContact());
		
         int i = pstmt.executeUpdate();
		
		System.out.println(i+"rows updated successfully");
	}
	
public void delete(Suppliers p2) throws SQLException, ClassNotFoundException {
		
		String query="delete supplier_details where supplier_id=?";
		Connection con=ConnectionUtil.getDBConnect();
		PreparedStatement pstmt = con.prepareStatement(query);
		
		pstmt.setString(1,p2.getSupplier_id());
		
         int i = pstmt.executeUpdate();
		
		System.out.println(i+"rows deleted successfully");
	}

}

