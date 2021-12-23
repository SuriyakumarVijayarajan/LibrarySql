package com.library.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.library.connection.*;
import com.library.dao.FinesDao;
import com.library.model.*;

public class FinesDaoImpl implements FinesDao {
	public void insert(Fines fine)  {

		String query = "insert into fine_details (fine_range_in_month,fine_amount) values (?,?)";
		try {
		Connection con = ConnectionUtil.getDBConnect();
		PreparedStatement pstmt = con.prepareStatement(query);

		pstmt.setInt(1, fine.getFine_range());
		pstmt.setInt(2, fine.getFine_amount());

		int i = pstmt.executeUpdate();

		System.out.println(i + "rows inserted successfully");
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void update(Fines fine) {

		String query = "update fine_details set fine_amount=? where fine_range_in_month=?";
		try {
		Connection con = ConnectionUtil.getDBConnect();
		PreparedStatement pstmt = con.prepareStatement(query);

		pstmt.setInt(1, fine.getFine_amount());
		pstmt.setInt(2, fine.getFine_range());

		int i = pstmt.executeUpdate();

		System.out.println(i + "rows updated successfully");
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void delete(Fines fine)  {

		String query = "delete fine_details where fine_range_in_month=?";
		try {
		Connection con = ConnectionUtil.getDBConnect();
		PreparedStatement pstmt = con.prepareStatement(query);

		pstmt.setInt(1, fine.getFine_range());

		int i = pstmt.executeUpdate();

		System.out.println(i + "rows deleted successfully");
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int fineCalculation(Fines fine) {
		// TODO Auto-generated method stub
		String query = "select fine_amount from fine_details where fine_range_in_month in ?";
		Connection con = null;
		try {
			con = ConnectionUtil.getDBConnect();
			PreparedStatement pstmt = null;
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, fine.getFine_range());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}



