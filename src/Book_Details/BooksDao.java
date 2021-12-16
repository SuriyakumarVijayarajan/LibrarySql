package Book_Details;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	
	public void authorFetch(String author) throws ClassNotFoundException, SQLException {
		String query="select book_title from book_details where author in ?";
		Connection con=ConnectionUtil.getDBConnect();
		PreparedStatement pstmt=con.prepareStatement(query);
		pstmt.setString(1, author);
		
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getString(1));
		}
		
	
//	public void update(Books p2) throws SQLException, ClassNotFoundException {
//		
//		String query="update products set category_id=? where product_id=100";
//		Connection con=ConnectionUtil.getDBConnect();
//		PreparedStatement pstmt = con.prepareStatement(query);
//		
//		pstmt.setString(1,p2.getSupplier_id());
//		
//         int i = pstmt.executeUpdate();
//		
//		System.out.println(i+"rows inserted successfully");
//	}
//	
//public void delete(Books p2) throws SQLException, ClassNotFoundException {
//		
//		String query="delete products where category_id=?";
//		Connection con=ConnectionUtil.getDBConnect();
//		PreparedStatement pstmt = con.prepareStatement(query);
//		
//		pstmt.setString(1,p2.getSupplier_id());
//		
//         int i = pstmt.executeUpdate();
//		
//		System.out.println(i+"rows deleted successfully");
//	}


	
}

}

