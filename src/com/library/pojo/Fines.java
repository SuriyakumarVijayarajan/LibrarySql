package com.library.pojo;

public class Fines {
	
	private int fine_range;
	private int fine_amount;
	public int getFine_range() {
		return fine_range;
	}
	public void setFine_range(int fine_range) {
		this.fine_range = fine_range;
	}
	public int getFine_amount() {
		return fine_amount;
	}
	public void setFine_amount(int fine_amount) {
		this.fine_amount = fine_amount;
	}
	public Fines(int fine_range, int fine_amount) {
		super();
		this.fine_range = fine_range;
		this.fine_amount = fine_amount;
	}
	public Fines() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Fines(int fine_range) {
		// TODO Auto-generated constructor stub
		this.fine_range=fine_range;
	}
	

}
