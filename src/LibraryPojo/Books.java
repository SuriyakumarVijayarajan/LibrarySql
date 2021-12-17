package LibraryPojo;

public class Books {
	
	private String book_code;
	private String book_title;
	private String category;
	private String author;
	private int price;
	private String rack_num;
	private String date_arrival;
	private String supplier_id;
	public Books(String book_code, String book_title, String category, String author, int price,
			String rack_num, String date_arrival, String supplier_id) {
		super();
		this.book_code = book_code;
		this.book_title = book_title;
		this.category = category;
		this.author = author;
		this.price = price;
		this.rack_num = rack_num;
		this.date_arrival = date_arrival;
		this.supplier_id = supplier_id;
	}
	public Books() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Books(String supplier_id) {
		// TODO Auto-generated constructor stub
	}
	public String getBook_code() {
		return book_code;
	}
	public void setBook_code(String book_code) {
		this.book_code = book_code;
	}
	public String getBook_title() {
		return book_title;
	}
	public void setBook_title(String book_title) {
		this.book_title = book_title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getRack_num() {
		return rack_num;
	}
	public void setRack_num(String rack_num) {
		this.rack_num = rack_num;
	}
	public String getDate_arrival() {
		return date_arrival;
	}
	public void setDate_arrival(String date_arrival) {
		this.date_arrival = date_arrival;
	}
	public String getSupplier_id() {
		return supplier_id;
	}
	public void setSupplier_id(String supplier_id) {
		this.supplier_id = supplier_id;
	}
	
	

}
