package com.medical.servlet;

import java.util.Date;

public class Medicine {

	private int id;
	private String name;
	private String manu;
	private String expr;
	private String price;

	public Medicine(int id, String name, String manu, String expr, String price) {
		this.id = id;
		this.name = name;
		this.manu = manu;
		this.expr = expr;
		this.price = price;
	}

	public Medicine(String name, String manu, String expr, String price) {
		this.name = name;
		this.manu = manu;
		this.expr = expr;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getManu() {
		return manu;
	}

	public void setManu(String manu) {
		this.manu = manu;
	}

	public String getExpr() {
		return expr;
	}

	public void setExpr(String expr) {
		this.expr = expr;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

}
