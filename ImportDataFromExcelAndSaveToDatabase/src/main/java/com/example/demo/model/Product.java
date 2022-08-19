package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {

	@Id
	private int productId;
	
	private String productName;
	
	private String productDesc;
	
	private Double productPrice;

	public Product(int productId, String productName, String productDesc, Double productPrice) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productDesc = productDesc;
		this.productPrice = productPrice;
	}

	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public Double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}
	
	
}
