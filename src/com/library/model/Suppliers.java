package com.library.model;

public class Suppliers {
	
	private String supplier_name;
	private String address;
	private long contact;
	
	public String getSupplier_name() {
		return supplier_name;
	}
	public void setSupplier_name(String supplier_name) {
		this.supplier_name = supplier_name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getContact() {
		return contact;
	}
	public void setContact(long contact) {
		this.contact = contact;
	}
	public Suppliers(String supplier_name, String address, long contact) {
		super();
		this.supplier_name = supplier_name;
		this.address = address;
		this.contact = contact;
	}
	public Suppliers() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Suppliers(String supplier_name) {
		// TODO Auto-generated constructor stub
		this.supplier_name=supplier_name;
	}
	public Suppliers(String supplier_name, long contact) {
		// TODO Auto-generated constructor stub
		this.supplier_name = supplier_name;
		this.contact = contact;
	}
	
	

}
