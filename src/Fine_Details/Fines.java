package Fine_Details;

public class Fines {
	
	private String fine_range;
	private int fine_amount;
	public String getFine_range() {
		return fine_range;
	}
	public void setFine_range(String fine_range) {
		this.fine_range = fine_range;
	}
	public int getFine_amount() {
		return fine_amount;
	}
	public void setFine_amount(int fine_amount) {
		this.fine_amount = fine_amount;
	}
	public Fines(String fine_range, int fine_amount) {
		super();
		this.fine_range = fine_range;
		this.fine_amount = fine_amount;
	}
	public Fines() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Fines(int fine_amount) {
		// TODO Auto-generated constructor stub
	}
	

}
