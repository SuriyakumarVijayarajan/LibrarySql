package com.library.pojo;

public class Suppliers {
	
	private String supplier_id;
	private String supplier_name;
	private String address;
	private long contact;
	public String getSupplier_id() {
		return supplier_id;
	}
	public void setSupplier_id(String supplier_id) {
		this.supplier_id = supplier_id;
	}
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
	public Suppliers(String supplier_id, String supplier_name, String address, long contact) {
		super();
		this.supplier_id = supplier_id;
		this.supplier_name = supplier_name;
		this.address = address;
		this.contact = contact;
	}
	public Suppliers() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Suppliers(String supplier_id) {
		// TODO Auto-generated constructor stub
		this.supplier_id=supplier_id;
	}
	public Suppliers(String supplier_id, long contact) {
		// TODO Auto-generated constructor stub
		this.supplier_id = supplier_id;
		this.contact = contact;
	}
	
	

}
