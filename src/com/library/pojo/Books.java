package com.library.pojo;

public class Books {
	
	private String book_code;
	private String book_title;
	private String category;
	private String author;
	private int price;
	private String rack_num;
	private String availability;
	private String user_name;
	
	
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}
	public Books(String book_code, String book_title, String category, String author, int price,
			String rack_num) {
		super();
		this.book_code = book_code;
		this.book_title = book_title;
		this.category = category;
		this.author = author;
		this.price = price;
		this.rack_num = rack_num;
	}
	public Books() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Books(String book_title) {
		// TODO Auto-generated constructor stub
		this.book_title=book_title;
	}
	public Books(String book_title, String user_name) {
		this.book_title=book_title;
		this.user_name=user_name;
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

	
	
	public Books( String book_title, String category,String author) {
		this.book_title = book_title;
		this.category = category;
		this.author = author;
	}
	@Override
	public String toString() {
		return "\nBook_title=" + book_title + "\nCategory=" + category + "\nAuthor=" + author;
	}
	
	

}
