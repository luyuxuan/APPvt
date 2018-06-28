package com.jsptest.pojo;

public class Manager {
	
	private int managerId;
	
	private String managerName;
	
	private String managerpassword;
	
	
		
	public Manager(int managerId, String managerName, String managerpassword) {
		super();
		this.managerId = managerId;
		this.managerName = managerName;
		this.managerpassword = managerpassword;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getManagerpassword() {
		return managerpassword;
	}

	public void setManagerpassword(String managerpassword) {
		this.managerpassword = managerpassword;
	}
	
	

	

}
