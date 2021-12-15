package User_Details;

public class Users {
	
	private String user_id;
	private String user_name;
	private String city;
	private String date_register;
	private String date_expire;
	private String password;
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
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
	public String getDate_register() {
		return date_register;
	}
	public void setDate_register(String date_register) {
		this.date_register = date_register;
	}
	public String getDate_expire() {
		return date_expire;
	}
	public void setDate_expire(String date_expire) {
		this.date_expire = date_expire;
	}
//	public String getUser_role() {
//		return user_role;
//	}
//	public void setUser_role(String user_role) {
//		this.user_role = user_role;
//	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Users(String user_id, String user_name, String city, String date_register,String date_expire,String password) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.city = city;
		this.date_register = date_register;
		this.date_expire = date_expire;
		//this.user_role = user_role;
		this.password = password;
	}
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Users(String password) {
		// TODO Auto-generated constructor stub
		this.password=password;
	}
	
	
	
	
	

}
