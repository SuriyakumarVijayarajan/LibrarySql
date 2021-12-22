package com.library.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.library.connection.*;
import com.library.pojo.*;

public class SuppliersDao {
	public void insert(Suppliers p1)  {
		
		String query="insert into supplier_details (supplier_name,address,contact) values (?,?,?)";
		try {
		Connection con=ConnectionUtil.getDBConnect();
		PreparedStatement pstmt = con.prepareStatement(query);
		
		pstmt.setString(1, p1.getSupplier_name());
		pstmt.setString(2, p1.getAddress());
		pstmt.setLong(3, p1.getContact());
	
		
		int i = pstmt.executeUpdate();
		
		System.out.println(i+"rows inserted successfully");
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void update(Suppliers p2)  {
		
		String query="update supplier_details set contact=? where supplier_name=?";
		try {
		Connection con=ConnectionUtil.getDBConnect();
		PreparedStatement pstmt = con.prepareStatement(query);
		
		pstmt.setString(2,p2.getSupplier_name());
		pstmt.setLong(1,p2.getContact());
		
         int i = pstmt.executeUpdate();
		
		System.out.println(i+"rows updated successfully");
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
public void delete(Suppliers p2)  {
		
		String query="delete supplier_details where supplier_name=?";
		try {
		Connection con=ConnectionUtil.getDBConnect();
		PreparedStatement pstmt = con.prepareStatement(query);
		
		pstmt.setString(1,p2.getSupplier_name());
		
         int i = pstmt.executeUpdate();
		
		System.out.println(i+"rows deleted successfully");
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

