package com.testsession.business;

import java.io.IOException;
import java.nio.charset.CodingErrorAction;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.ResultSet;
import com.testlistener.dao.ProductDao;
import com.testlistener.dao.ProductTypeDao;

/**
 * Servlet implementation class productseverlet
 */
@WebServlet("/productseverlet.do")
public class productseverlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public productseverlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    	
    	
    	ProductTypeDao producttype=new ProductTypeDao();
    	
    	String condition="";
    	
    	String tyidForPar=request.getParameter("stament1");
    	
    	String pageNo=request.getParameter("pageNo");
    	int	pageNonew=0;
    	if(pageNo!=null&&!pageNo.equals(""))
    	{
    		//要判断一下是否为空  要是为空才能类型转换
    		pageNonew=Integer.parseInt(pageNo);
    		
    		
    		//没问题这步可以找到1 3
    		//System.out.println(tyForPar);
    	}
    	
    	//一级分类
    
    	int  tyForPar=0;
    	
    	
    	if(tyidForPar!=null&&!tyidForPar.equals(""))
    	{
    		//要判断一下是否为空  要是为空才能类型转换
    		tyForPar=Integer.parseInt(tyidForPar);
    		
    		
    		//没问题这步可以找到1 3
    		//System.out.println(tyForPar);
    	}
    	
    	
    
    	
    	
    	
    	
    	
    	
    	
    	
    	//二级分类
    	String producttypeid=request.getParameter("stament2");
    	int  typeId=0;
    	
    	
    	if(producttypeid!=null&&!producttypeid.equals(""))
    	{
    		//要判断一下是否为空  要是为空才能类型转换
    		typeId=Integer.parseInt(producttypeid);
    	}
    	
    	//System.out.println(producttypeid);
    	String account=request.getParameter("account");
    	
    
    	String price1=request.getParameter("price1");
    	String sale1=request.getParameter("sale1");
    	String price2=request.getParameter("price2");
    	String sale2=request.getParameter("sale2");
    	
    	
    	//获得删除id
        String delid=request.getParameter("delid");
    	ProductDao productdao=new ProductDao();
    	
    	//给一个结果集
    	ResultSet sqlall=null;
    	
//    	//一级分类  在第一次查询结果后面要加一个别名
//		if(tyForPar==0)
//		{
//			condition+=" ";
//			
//		}
//		
//		else
//		{
//			int id=0;
//			//获得一级分类的id 根据id去找Pid为id的二级分类的id
//			
//			String co=" and typeParentid='"+tyForPar+"'";
//			
//			
//			//可能会有多条数据
//			ResultSet res=(ResultSet) producttype.selectProductType(co);
//			
//			
//			
//			try {
//				
//				res.next();
//				
//			
//				
//				id=res.getInt(1);
//				condition+=" and producttypeId='"+id+"'";
//				
//				while(res.next())
//				{
//					id=res.getInt(1);
//					
//					
//					//能找到二级分类的 typeid
//					//System.out.println(id);
//					
//					condition+=" or producttypeId='"+id+"'";
//					
//					System.out.println(condition);
//				}
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//			
//			
//			
//		}
//    	
    	
    	//测试一下
    			if(delid==null)
    			{
    				//System.out.println("大家好");
    			}
    			
    			else
    			{
    				Boolean choose=productdao.deleteproduct(Integer.parseInt(delid));
    			}
    			
    			
    			
    			String  resAll=null;
    			
    			//一级分类  在第一次查询结果后面要加一个别名
    			if(tyForPar==0)
    			{
    				condition+=" ";
    				
    			}
    			
    			else
    			{
    				int id=0;
    				//获得一级分类的id 根据id去找Pid为id的二级分类的id
    				
    				String co=" and typeParentid='"+tyForPar+"'";
    				
    				
    				//可能会有多条数据
    				ResultSet res=(ResultSet) producttype.selectProductType(co);
    				
    				
    				
    				try {
    					
    					res.next();
    					
    				
    					
    					id=res.getInt(1);
    					condition+=" and producttypeId='"+id+"'";
    					
    					while(res.next())
    					{
    						id=res.getInt(1);
    						
    						
    						//能找到二级分类的 typeid
    						//System.out.println(id);
    						
    						String tiaojian=condition;
    						
    						condition+=" or producttypeId='"+id+"'";
    						
    						
    						
    						resAll="(select *from product where 1=1"+condition+")b";
    						
    						//System.out.println(resAll);
    						
    					}
    				} catch (SQLException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				}
    				
    				
    				
    				
    			}
    	    	
    			
    			condition="";
    			
    			
    			//二级分类
    			if(typeId==0)
    			{
    				condition+=" ";
    				
    			}
    			
    			else
    			{
    				
    				condition+=" and producttypeId='"+typeId+"'";
    				
    				System.out.println(condition);
    			}
    			
    			if(account!=null&&!account.equals(""))
    			{
    				condition+=" and productName='"+account+"'";
    				
    			}
    			
    			
    			//判断什么价钱之间kucun!=null&&!kucun.equals("")
    			
    			if(price1!=null&&!price1.equals("") &&price2!=null&&!price2.equals(""))
    			{
    				condition+=" and productprice between '"+price1+"' and '"+price2+"'";
    				
    			}
    			
    			
    			//判断什么销量之间
    			
    		   if(sale1!=null&&!sale1.equals("") &&sale2!=null&&!sale2.equals(""))
    			{
    				condition+=" and productSales between '"+sale1+"' and '"+sale2+"'";
    				
    			}
    			
    			
    			//System.out.println(condition);
    			
    			
    	//ResultSet rs=(ResultSet) productdao.selectproduct(condition);
    			
    			
    			//分页 每页2条
    			 condition+= " limit " + pageNonew * 2 + ",2";
    			 
    			System.out.println(condition);
    	
    	ResultSet rs=(ResultSet) productdao.selectproductCondition(condition, resAll);
    	String table = "<Table border=1  cellpadding=0 cellspacing=0>";
    	
    	
    

		table += "<tr><th>编号</th><th>删除</th><th>图片</th><th>分类</th><th>二级分类</th><th>名称</th><th>单价</th><th>商品信息</th><th>销量</th><th>总额</th><th>操作</th></tr>";
		//table+="<th>名称</th><th>单价</th><th>库存</th><th>销量</th><th>总额</th><th>操作</th></tr>";
    	try {
    		
    		
			while(rs.next())
			{
				table+="<tr>";
				
				table+="<td>";
				
				table+=rs.getInt(1);
				
				
				table+="</td>";
				
				table+="<td>";
				
				table+="<input type="+"checkbox"+" ";
				//table+="id="+"checkid"+"";
				table+="id=\"checkid\"";
				
				//转义字符分开""
				table+="value=\""+rs.getInt(1)+"\" ";
				table+="/>";
				
				table+="</td>";
				
				

				table+="<td>";
				 //<img alt="" src="getimageAndroid.do">
				
				//变量这样写
				table+=" <img src="+rs.getString(4)+">";
				//table+=rs.getString(6);
				
				table+="</td>";
				
				
				table+="<td>";
	
				
				
				//求一级分类
				
				String condi=" and producttypeId='"+rs.getInt(10)+"'";
			
				
				int Parentid=producttype.selectParentid(condi);
				
				//System.out.println(Parentid);
				String con2=" and producttypeId='"+Parentid+"'";
				
			//	ResultSet resset2=(ResultSet) producttype.selectProductType(con2);
				
				ResultSet resset=(ResultSet) producttype.selectProductType(con2);
				
				
				//当resset有next才可以
				while(resset.next())
				{
					table+=resset.getString(3);
				}
				table+="</td>";
				
				
				
				table+="<td>";

				//table+=rs.getString(4);
				
				//显示二级分类直接获取商品表中获得肯定是
				
				String con=" and producttypeId='"+rs.getInt(10)+"'";
				
				
				//System.out.println(condi);
				
//				int Parentid=producttype.selectParentid(con);
//				String con2=" and typeParentid='"+Parentid+"'";
				
			//	ResultSet resset2=(ResultSet) producttype.selectProductType(con2);
				ResultSet resset2=(ResultSet) producttype.selectProductType(con);
				
				
				String updatecon="";
				//当resset有next才可以
				while(resset2.next())
				{
					table+=resset2.getString(3);
				}
				table+="</td>";
				
				
				table+="<td>";
				
				
				table+=rs.getString(2);
				
				table+="</td>";
				
				
				
				
				table+="<td>";
				
				
				table+=rs.getString(5);
				
				table+="</td>";
				
				
				table+="<td>";
				
				table+=rs.getString(7);
				
				
				table+="</td>";
				
				table+="<td>";
				
				table+=rs.getString(6);
				
				
				table+="</td>";
				
				table+="<td>";
				
				table+=rs.getString(5);
				
				
				table+="</td>";
				
				table+="<td>";
				
				//拼接字符串用+可以看作是常量
				//table+="<a herf="+"#"+">删除</a>";
				table+="<a href="+"#"+"";
				table+=" onclick="+"update("+rs.getInt(1)+");"+"";
				table+=">";
				table+="编辑";
				table+="</a>";
				
				//下面为编辑代码
				
				
				
				
				table+="<br>";
				
				table+="<a href="+"#"+"";
				table+=" onclick="+"delusers("+rs.getInt(1)+");"+"";
				table+=">";
				table+="删除";
				table+="</a>";
				
				table+="</td>";
				
				table+="</tr>";
				
			}
			
			table+="</table>";
			
    	}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    	//把数据传过去
    	response.getWriter().write(table);
    }

}
