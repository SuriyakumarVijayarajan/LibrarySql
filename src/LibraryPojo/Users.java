package LibraryPojo;

public class Users {
	
	private String user_name;
	private String city;
	private String password;
	private long mobile_no;
	private String email_id;
	private int user_id;
	private int fine_amount;
	
	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getFine_amount() {
		return fine_amount;
	}

	public void setFine_amount(int fine_amount) {
		this.fine_amount = fine_amount;
	}

	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Users(String user_name, String city, String password, long mobile_no,String email_id) {
		super();
		this.user_name = user_name;
		this.city = city;
		this.password = password;
		this.mobile_no = mobile_no;
		this.email_id = email_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getMobile_no() {
		return mobile_no;
	}

	public void setMobile_no(long mobile_no) {
		this.mobile_no = mobile_no;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public Users(int user_id, int fine_amount) {
		// TODO Auto-generated constructor stub
		this.user_id=user_id;
		this.fine_amount=fine_amount;
	}

	public Users(int user_id) {
		// TODO Auto-generated constructor stub
		this.user_id=user_id;
	}

	@Override
	public String toString() {
		return "Users [user_name=" + user_name + ", city=" + city + ", password=" + password + ", mobile_no="
				+ mobile_no + ", email_id=" + email_id + ", user_id=" + user_id + ", fine_amount=" + fine_amount + "]";
	}

	
	
	
	
	
	

}
