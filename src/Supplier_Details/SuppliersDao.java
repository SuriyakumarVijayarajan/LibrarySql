package Supplier_Details;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SuppliersDao {
	public void insert(Suppliers p1) throws SQLException, ClassNotFoundException {
		
		String query="insert into supplier_details (supplier_id,supplier_name,address,contact) values (?,?,?,?)";
		Connection con=ConnectionUtil.getDBConnect();
		PreparedStatement pstmt = con.prepareStatement(query);
		
		pstmt.setString(1,p1.getSupplier_id());
		pstmt.setString(2, p1.getSupplier_name());
		pstmt.setString(3, p1.getAddress());
		pstmt.setInt(4, p1.getContact());
	
		
		int i = pstmt.executeUpdate();
		
		System.out.println(i+"rows inserted successfully");
		
	}
	
	public void update(Suppliers p2) throws SQLException, ClassNotFoundException {
		
		String query="update supplier_details set category_id=? where product_id=100";
		Connection con=ConnectionUtil.getDBConnect();
		PreparedStatement pstmt = con.prepareStatement(query);
		
		pstmt.setString(1,p2.getSupplier_id());
		
         int i = pstmt.executeUpdate();
		
		System.out.println(i+"rows inserted successfully");
	}
	
public void delete(Suppliers p2) throws SQLException, ClassNotFoundException {
		
		String query="delete supplier_details where category_id=?";
		Connection con=ConnectionUtil.getDBConnect();
		PreparedStatement pstmt = con.prepareStatement(query);
		
		pstmt.setString(1,p2.getSupplier_id());
		
         int i = pstmt.executeUpdate();
		
		System.out.println(i+"rows deleted successfully");
	}

}

