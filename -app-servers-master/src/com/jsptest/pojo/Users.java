package com.jsptest.pojo;

import java.io.BufferedOutputStream;

public class Users {

	private  int usersId;
	private String userName;
	
	private String  userPassword;
	private  int userIntegration;
	private String  userEmail;
	
	
	
	private  String userState;
	private  int shoppingCartId;
	private String  userpicture;
	public Users(int usersId, String userName, String userPassword,
			int userIntegration, String userEmail, String userState,
			int shoppingCartId, String userpicture) {
		super();
		this.usersId = usersId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userIntegration = userIntegration;
		this.userEmail = userEmail;
		this.userState = userState;
		this.shoppingCartId = shoppingCartId;
		this.userpicture = userpicture;
	}
	public int getUsersId() {
		return usersId;
	}
	public void setUsersId(int usersId) {
		this.usersId = usersId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public int getUserIntegration() {
		return userIntegration;
	}
	public void setUserIntegration(int userIntegration) {
		this.userIntegration = userIntegration;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserState() {
		return userState;
	}
	public void setUserState(String userState) {
		this.userState = userState;
	}
	public int getShoppingCartId() {
		return shoppingCartId;
	}
	public void setShoppingCartId(int shoppingCartId) {
		this.shoppingCartId = shoppingCartId;
	}
	public String getUserpicture() {
		return userpicture;
	}
	public void setUserpicture(String userpicture) {
		this.userpicture = userpicture;
	}
	
	
	
}
