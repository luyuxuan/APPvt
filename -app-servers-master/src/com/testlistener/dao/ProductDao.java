package com.testlistener.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

public class ProductDao extends BaseDao {
	
	Connection conn=getConn();
	
	public boolean updateproduct(int productId,
            String productName,
            String productpicture,
            int productclassificationid,
            int productprice,
            int productInventory,
            int productSales)
	{

    String strsql="update product set productName=?,productpicture=?,productclassificationid=?, productprice=?,productInventory=?, productSales=? where productId=?";
	try {
	PreparedStatement statement=(PreparedStatement) conn.prepareStatement(strsql);
	statement.setString(1,productName);
	statement.setString(2,productpicture);
	statement.setInt(3,productclassificationid);
	statement.setInt(4,productprice);
	statement.setInt(5,productInventory);
	statement.setInt(6,productSales);
	statement.setInt(7,productId);
	int count=statement.executeUpdate();
	
	if(count>0){
		return true;
		
	}
	else
	{
		return false;
	}
	
	} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}
	
	return false;
	
	
	}
	
	
	public boolean updateProduct(String condition)
	{

    String strsql="update product";
    
    		strsql+=condition;
	try {
	PreparedStatement statement=(PreparedStatement) conn.prepareStatement(strsql);
	
	int count=statement.executeUpdate();
	
	if(count>0){
		return true;
		
	}
	else
	{
		return false;
	}
	
	} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}
	
	return false;
	
	
	}
	//新增商品
	public boolean insertproduct( String productName,
			 		int productprice,
	             String productpicture,
	             int productInventory,
	            
	             int productSales,
	             String productIntroduction,
	             String posttime,
	             int discount,
	             int producttypeId
	){

	String strsql=" insert into product(productName,productprice,productpicture,productInventory,productSales,productIntroduction,posttime,discount,producttypeId) values(?,?,?,?,?,?,?,?,?)";
	try {
	PreparedStatement statement=(PreparedStatement) conn.prepareStatement(strsql);
	statement.setString(1,productName);
	statement.setInt(2,productprice);
	statement.setString(3,productpicture);
	statement.setInt(4,productInventory);
	statement.setInt(5,productSales);
	statement.setString(6,productIntroduction);
	statement.setString(7,posttime);
	statement.setInt(8,discount);
	statement.setInt(9,producttypeId);
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
	public com.mysql.jdbc.ResultSet getUsers(String string) {
	// TODO Auto-generated method stub
	return null;
	}
	
	
	
	//删除商品
	public boolean deleteproduct(int productId)
	{
	
	String sql="delete from product where productId=?";
	try {
	//PreparedStatement statement=(PreparedStatement) conn.prepareStatement(sql);
	java.sql.PreparedStatement statement =conn.prepareStatement(sql);
	statement.setInt(1, productId);
	int count=statement.executeUpdate();
	if(count>0){
		
		return true;
	}
	} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}
	
	return false;
	}
	
	//查询所有商品 shift+table往左移一个table单位
	public ResultSet selectproduct(String condition)
	{
		ResultSet rs = null;
		
		
		String sql="select *from product where 1=1 ";
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
	
	
	public ResultSet selectproductCondition(String condition,String resAll)
	{
		ResultSet rs = null;
		String sql="";
		if(resAll==null)
		{
			 sql="select *from product where 1=1 ";
		}
		
		
		else
		{
			sql="select *from "+resAll+" where 1=1 ";
			
		}
		//String sql="select *from product where 1=1 ";
		//String sql="select *from vip ";
		sql=sql+condition;
			
		
		//System.out.println(sql);
		
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



