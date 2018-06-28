package com.jsptest.pojo;

public class FirstType {
	
	private int producttypeId;
	private  String producttypeParentName;

	private String producttypeChildName;

	public int getProducttypeId() {
		return producttypeId;
	}

	public void setProducttypeId(int producttypeId) {
		this.producttypeId = producttypeId;
	}

	public String getProducttypeParentName() {
		return producttypeParentName;
	}

	public void setProducttypeParentName(String producttypeParentName) {
		this.producttypeParentName = producttypeParentName;
	}

	public String getProducttypeChildName() {
		return producttypeChildName;
	}

	public void setProducttypeChildName(String producttypeChildName) {
		this.producttypeChildName = producttypeChildName;
	}

	public FirstType(int producttypeId, String producttypeParentName,
			String producttypeChildName) {
		super();
		this.producttypeId = producttypeId;
		this.producttypeParentName = producttypeParentName;
		this.producttypeChildName = producttypeChildName;
	}

	
	

}
