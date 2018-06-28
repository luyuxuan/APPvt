package com.testlistener.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.locks.Condition;



 

public class UsersDao extends BaseDao {
	
	
	
	
	
	Connection conn=getConn();
	
	//获得登录账号
	
	public int getVipCount(String managerName,String managerpassword)
	{
		
		//String sql="select count(*) from vip where account=? and email=?";
		String sql="select count(*) from manager where managerName=? and managerpassword=?";
		PreparedStatement statement;
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, managerName);
			statement.setString(2, managerpassword);
			ResultSet rs=statement.executeQuery();
			
			//只找到结果集里的第一条数据
			rs.next();
			
			//返回一个账号
			return rs.getInt(1);
		} catch (SQLException e) {
 
		}

		
	return 0;	
	}
	
	
	public int getUserCount(String userName,String userPassword)
	{
		
		//String sql="select count(*) from vip where account=? and email=?";
		String sql="select count(*) from users where userName=? and userPassword=?";
		PreparedStatement statement;
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, userName);
			statement.setString(2, userPassword);
			ResultSet rs=statement.executeQuery();
			
			//只找到结果集里的第一条数据
			rs.next();
			
			//返回一个账号
			return rs.getInt(1);
		} catch (SQLException e) {
 
		}

		
	return 0;	
	}
	
	public int getRegCount(String userName)
	{
		
		//String sql="select count(*) from vip where account=? and email=?";
		String sql="select count(*) from users where userName=?";
		PreparedStatement statement;
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, userName);
			
			ResultSet rs=statement.executeQuery();
			
			//只找到结果集里的第一条数据
			rs.next();
			
			//返回一个账号
			return rs.getInt(1);
		} catch (SQLException e) {
 
		}

		
	return 0;	
	}
	//默认调用父类的无参构造函数
	public boolean insert( String userName,String userPassword,String userEmail){
		
		String strsql="insert into users(userName,userPassword,userEmail) values(?,?,?)";
		try {
			java.sql.PreparedStatement statement =conn.prepareStatement(strsql);
			statement.setString(1,userName);
			statement.setString(2,userPassword);
			statement.setString(3,userEmail);
			int count=statement.executeUpdate();
			
			if(count>0){
				return true;
				
			}
			else
			{
				return false;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return false;
	}

	
	public Boolean insertVip(String account,String email,String scare,String stament,String aihao)
	{
		
		Boolean  bool = null;
		
		//String sql = "insert into vip (account,email,scare,stament,aihao) values ('"+account+"','"+email+"','"+scare+"','"+stament+"','"+aihao+"')";
		
		String sql = "insert into vip (account,email,scare,stament,aihao) values (?,?,?,?,?)";
		try {
			java.sql.PreparedStatement statement =conn.prepareStatement(sql);
			
			statement.setString(1,account);
			statement.setString(2,email);
			statement.setString(3,scare);
			statement.setString(4,stament);
			statement.setString(5,aihao);
			
		int count=statement.executeUpdate();
		
		if(count>0)
		{
			bool=true;
			
		}
		else
		{
			bool=false;
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
				//执行增加，删除，修改，与查找调用函数不同
				//int count=statement.executeUpdate(sql);
		return bool;
		
	}
	
	
	
	public Boolean delVip(int id)
	{
		
		Boolean  bool = null;
		
		//String sql = "insert into vip (account,email,scare,stament,aihao) values ('"+account+"','"+email+"','"+scare+"','"+stament+"','"+aihao+"')";
		
		String sql = "delete from users where usersId=?";
		try {
			java.sql.PreparedStatement statement =conn.prepareStatement(sql);
			
			statement.setInt(1,id);
			
		int count=statement.executeUpdate();
		
		if(count>0)
		{
			bool=true;
			
		}
		else
		{
			bool=false;
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
				//执行增加，删除，修改，与查找调用函数不同
				//int count=statement.executeUpdate(sql);
		return bool;
		
	}
	
	
	
	
	
	public ResultSet selectVip(String condition)
	{
		ResultSet rs = null;
		
		
		String sql="select *from users where 1=1 ";
		//String sql="select *from vip ";
		sql=sql+condition;
				
		
		try {
			Statement statement=conn.createStatement();
			
			
			//这个返回的是结果集
			rs=statement.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rs;
	}

}
