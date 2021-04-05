package com.model;

public class Footwear {

	private int id;
	private String name;
	private String brand;
	private String price;
	private String productType;
	private String imageUrl;
	private String productDesc;
	private int quantity_purchased;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductDesc() {
		return productDesc;
	}
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
	public Footwear() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getQuantity_purchased() {
		return quantity_purchased;
	}
	public void setQuantity_purchased(int quantity_purchased) {
		this.quantity_purchased = quantity_purchased;
	}
	public Footwear(int id, String name, String brand, String price, String productType, String imageUrl,
			String productDesc, int quantity_purchased) {
		super();
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.price = price;
		this.productType = productType;
		this.imageUrl = imageUrl;
		this.productDesc = productDesc;
		this.quantity_purchased = quantity_purchased;
	}
	
}
