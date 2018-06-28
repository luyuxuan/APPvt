package com.testlistener.dao;

import java.sql.Connection;


public abstract class BaseDao {
	
	private static Connection conn;

	public static Connection getConn() {
		return conn;
	}

	public static void setConn(Connection conn) {
		BaseDao.conn = conn;
	}
	
	
	
}
