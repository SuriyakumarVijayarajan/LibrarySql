package com.library.model;

public class FineHistory {
	
	private String user_name;
	private int fine_amount;
	private String collected_time;
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public int getFine_amount() {
		return fine_amount;
	}
	public void setFine_amount(int fine_amount) {
		this.fine_amount = fine_amount;
	}
	
	public String getCollected_time() {
		return collected_time;
	}
	public void setCollected_time(String collected_time) {
		this.collected_time = collected_time;
	}
	public FineHistory(String user_name, int fine_amount) {
		super();
		this.user_name = user_name;
		this.fine_amount = fine_amount;
	}
	public FineHistory(String user_name, int fine_amount, String collected_time) {
		super();
		this.user_name = user_name;
		this.fine_amount = fine_amount;
		this.collected_time = collected_time;
	}
	@Override
	public String toString() {
		return "FineHistory [user_name=" + user_name + ", fine_amount=" + fine_amount + ", collected_time="
				+ collected_time + "]";
	}
	
	
	

}
