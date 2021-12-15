package Book_Issue_Details;

public class BookIssue {
	
	private int book_issue_id;
	private String user_id;
	private String book_code;
	private String date_issue;
	private String date_return;
	private String date_returned;
	private String fine_range;
	public BookIssue(int book_issue_id, String user_id, String book_code, String date_issue, String date_return,
			String date_returned, String fine_range) {
		super();
		this.book_issue_id = book_issue_id;
		this.user_id = user_id;
		this.book_code = book_code;
		this.date_issue = date_issue;
		this.date_return = date_return;
		this.date_returned = date_returned;
		this.fine_range = fine_range;
	}
	public int getBook_issue_id() {
		return book_issue_id;
	}
	public void setBook_issue_id(int book_issue_id) {
		this.book_issue_id = book_issue_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getBook_code() {
		return book_code;
	}
	public void setBook_code(String book_code) {
		this.book_code = book_code;
	}
	public String getDate_issue() {
		return date_issue;
	}
	public void setDate_issue(String date_issue) {
		this.date_issue = date_issue;
	}
	public String getDate_return() {
		return date_return;
	}
	public void setDate_return(String date_return) {
		this.date_return = date_return;
	}
	public String getDate_returned() {
		return date_returned;
	}
	public void setDate_returned(String date_returned) {
		this.date_returned = date_returned;
	}
	public String getFine_range() {
		return fine_range;
	}
	public void setFine_range(String fine_range) {
		this.fine_range = fine_range;
	}
	@Override
	public String toString() {
		return "BookIssue [book_issue_id=" + book_issue_id + ", user_id=" + user_id + ", book_code=" + book_code
				+ ", date_issue=" + date_issue + ", date_return=" + date_return + ", date_returned=" + date_returned
				+ ", fine_range=" + fine_range + "]";
	}
	public BookIssue() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
