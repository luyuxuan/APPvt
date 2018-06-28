package com.testlistener.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductTypeDao extends BaseDao {
	
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

	
	//默认调用父类的无参构造函数
	
	
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
		
		String sql = "delete from vip where id=?";
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
	
	
	
	
	
	public ResultSet selectProductType(String condition)
	{
		ResultSet rs = null;
		
		
		String sql="select *from producttype where 1=1 ";
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
	
	

	public int selectParentid(String condition)
	{
		int id = 0;
		ResultSet rs=null;
		
		String sql="select typeParentid from producttype where 1=1 ";
		//String sql="select *from vip ";
		sql=sql+condition;
				
		
		try {
			Statement statement=conn.createStatement();
			
			
			//这个返回的是结果集
			rs=statement.executeQuery(sql);
			
			//rs.next()是移到第一条数据
			rs.next();
			id=rs.getInt("typeParentid");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return id;
	}

	
//	public int selectParentTypeid(String condition)
//	{
//		int id = 0;
//		ResultSet rs=null;
//		
//		String sql="select * from producttype as a,product as b where 1=1 and a.producttypeId=b.producttypeId ";
//		//String sql="select *from vip ";
//		sql=sql+condition;
//				
//		
//		try {
//			Statement statement=conn.createStatement();
//			
//			
//			//这个返回的是结果集
//			rs=statement.executeQuery(sql);
//			
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			id=rs.getInt(2);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return id;
//	}

}
