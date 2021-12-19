package LibraryDAOs;
import java.sql.Connection;
import LibraryPojo.*;
import Connection.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BooksDao {
	public void insert(Books p1) throws SQLException, ClassNotFoundException {
		
		String query="insert into book_details (book_code,book_title,category,author,price,rack_num,date_arrival,supplier_id) values (?,?,?,?,?,?,?,?)";
		Connection con=ConnectionUtil.getDBConnect();
		PreparedStatement pstmt = con.prepareStatement(query);
		
		pstmt.setString(1,p1.getBook_code());
		pstmt.setString(2, p1.getBook_title());
		pstmt.setString(3, p1.getCategory());
		pstmt.setString(4, p1.getAuthor());
		pstmt.setInt(5, p1.getPrice());
		pstmt.setString(6, p1.getRack_num());
		pstmt.setString(7, p1.getDate_arrival());
		pstmt.setString(8, p1.getSupplier_id());
		
		int i = pstmt.executeUpdate();
		
		System.out.println(i+"rows inserted successfully");
		
	}
//	public ResultSet showBooks(){
//		String query="Select book_title,author,category from book_details";
//		Connection con = null;
//		try {
//			con = ConnectionUtil.getDBConnect();
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		PreparedStatement pstmt = null;
//		try {
//			pstmt = con.prepareStatement(query);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		ResultSet rs=null;
//		try {
//			rs=pstmt.executeQuery();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return rs;
//		}
	
	public static List showBooks() 
	{
		List productsList=new ArrayList();
		
		String query="Select book_title,category,author from book_details";
		
		
		Connection con = null;
		try {
			con = ConnectionUtil.getDBConnect();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet rs=null;
		try {
			rs=pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while(rs.next())
			{
				Books product = null;
				try {
					product = new Books(rs.getString(1),rs.getString(2),rs.getString(3));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				productsList.add(product);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return productsList;
	}

	
	public ResultSet authorFetch(String author) {
		String query="select book_title from book_details where author in ?";
		Connection con;
		PreparedStatement pstmt=null;
		try {
			con = ConnectionUtil.getDBConnect();
			pstmt = con.prepareStatement(query);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		try {
			pstmt.setString(1, author);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ResultSet rs=null;
		try {
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
		
		
	}
	
public void delete(Books p2) throws SQLException, ClassNotFoundException {
		
		String query="delete book_details where book_code=?";
		Connection con=ConnectionUtil.getDBConnect();
		PreparedStatement pstmt = con.prepareStatement(query);
		
		pstmt.setString(1,p2.getBook_code());
		
         int i = pstmt.executeUpdate();
		
		System.out.println(i+"rows deleted successfully");
	}


	

	public void update(Books p2) {
		// TODO Auto-generated method stub
		String query="update book_details set availability=? where book_code=?";
		Connection con = null;
		try {
			con = ConnectionUtil.getDBConnect();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PreparedStatement pstmt = null;
		 int i = 0;
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1,p2.getAvailability());
			pstmt.setString(2, p2.getBook_code());
			i = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        
		
         
		
		System.out.println(i+"rows updated successfully");
		
	}


}

