package User_Details;

public class Users {
	
	private String user_name;
	private String city;
	private String date_register;
	private String password;
	private long mobile_no;
	private String email_id;
	
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

	public Users(String password) {
		// TODO Auto-generated constructor stub
		this.password=password;
	}

	@Override
	public String toString() {
		return "Users [user_name=" + user_name + ", city=" + city + ", date_register=" + date_register + ", password="
				+ password + ", mobile_no=" + mobile_no + ", email_id=" + email_id + "]";
	}
	
	
	
	
	

}
