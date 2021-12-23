package com.library.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.library.connection.*;
import com.library.dao.SuppliersDao;
import com.library.model.*;

public class SuppliersImpl implements SuppliersDao{
	public void insert(Suppliers supply)  {
		
		 String   query="insert into supplier_details (supplier_name,address,contact) values (?,?,?)";
		try {
		Connection con=ConnectionUtil.getDBConnect();
		PreparedStatement pstmt = con.prepareStatement(query);
		
		pstmt.setString(1, supply.getSupplier_name());
		pstmt.setString(2, supply.getAddress());
		pstmt.setLong(3, supply.getContact());
	
		
		int i = pstmt.executeUpdate();
		
		System.out.println(i+"rows inserted successfully");
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void update(Suppliers supply)  {
	    String query="update supplier_details set contact=? where supplier_name=?";
		try {
		Connection con=ConnectionUtil.getDBConnect();
		PreparedStatement pstmt = con.prepareStatement(query);
		
		pstmt.setString(2,supply.getSupplier_name());
		pstmt.setLong(1,supply.getContact());
		
         int i = pstmt.executeUpdate();
		
		System.out.println(i+"rows updated successfully");
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
public void delete(Suppliers supply)  {
		
		String query="delete supplier_details where supplier_name=?";
		try {
		Connection con=ConnectionUtil.getDBConnect();
		PreparedStatement pstmt = con.prepareStatement(query);
		
		pstmt.setString(1,supply.getSupplier_name());
		
         int i = pstmt.executeUpdate();
		
		System.out.println(i+"rows deleted successfully");
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

