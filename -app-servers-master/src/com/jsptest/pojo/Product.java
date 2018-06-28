package com.jsptest.pojo;

public class Product {
	
	
	private  int productId;
	private String productName;
	
	private  int productprice;
	private String  productpicture;
	private  int productInventory;
	private  int productSales;
	private String  productIntroduction;
	private String  posttime;
	private  int discount;
	
	private  int producttypeId;

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

	public int getProductprice() {
		return productprice;
	}

	public void setProductprice(int productprice) {
		this.productprice = productprice;
	}

	public String getProductpicture() {
		return productpicture;
	}

	public void setProductpicture(String productpicture) {
		this.productpicture = productpicture;
	}

	public int getProductInventory() {
		return productInventory;
	}

	public void setProductInventory(int productInventory) {
		this.productInventory = productInventory;
	}

	public int getProductSales() {
		return productSales;
	}

	public void setProductSales(int productSales) {
		this.productSales = productSales;
	}

	public String getProductIntroduction() {
		return productIntroduction;
	}

	public void setProductIntroduction(String productIntroduction) {
		this.productIntroduction = productIntroduction;
	}

	public String getPosttime() {
		return posttime;
	}

	public void setPosttime(String posttime) {
		this.posttime = posttime;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public int getProducttypeId() {
		return producttypeId;
	}

	public void setProducttypeId(int producttypeId) {
		this.producttypeId = producttypeId;
	}

	public Product(int productId, String productName, int productprice,
			String productpicture, int productInventory, int productSales,
			String productIntroduction, String posttime, int discount,
			int producttypeId) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productprice = productprice;
		this.productpicture = productpicture;
		this.productInventory = productInventory;
		this.productSales = productSales;
		this.productIntroduction = productIntroduction;
		this.posttime = posttime;
		this.discount = discount;
		this.producttypeId = producttypeId;
	}
	
	
	
	
	
	
	
	
	
	
}
