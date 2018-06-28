package com.servlte.business.forandroid;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.jsptest.pojo.Product;
import com.mysql.jdbc.ResultSet;
import com.testlistener.dao.ProductDao;
import com.testlistener.dao.ProductTypeDao;

/**
 * Servlet implementation class productforandroid
 */
@WebServlet("/productforandroid.do")
public class productforandroid extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public productforandroid() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		request.setCharacterEncoding("utf-8");
		
		response.setCharacterEncoding("utf-8");
		
		
		//从客户端获得传值过来productId
		
		int producttypeId=Integer.parseInt(request.getParameter("id"));
		
		//先把数据放在一个list中
		ProductDao  productdao=new ProductDao();
		
		
		ProductTypeDao producttype=new ProductTypeDao();
		
		ArrayList<Product>  arrlist=new ArrayList<Product>();
		
//		//根据商品表里直接找producttypeId
//		String condition="and productId='"+productId+"'";
//		
//		ResultSet res=(ResultSet) productdao.selectproduct(condition);
		
//			try {
//				while(res.next())
//				{
//					
////				System.out.println(res.getInt(1));
////				
////				System.out.println(res.getString(2));
////				
////				System.out.println(res.getString(3));
//					
//					
//					Product product=new Product(res.getInt(1), res.getString(2), res.getInt(3), res.getString(4), res.getInt(5), res.getInt(6),  res.getString(7),res.getString(8),res.getInt(9),  res.getInt(10));
//					
//					
//					arrlist.add(product);
//
//				//Product product=new Product(res.getInt(1), res.getString(2), res.getInt(3), res.getString(4), res.getInt(5), res.getInt(6),  rs.getString(7),res.getString(8),res.getInt(9),  res.getInt(10));
//				//arrlist.add(product);
//				}
//				
//				res.close();
//				JSONArray jsarray=JSONArray.fromObject(arrlist);
//				
//				response.getWriter().write(jsarray.toString());
//			
//				
//				
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//		
//	}
	
	//把list放在 js里面
	//安卓与servlte交互的桥梁
	
	
		
		String condition="and typeParentid='"+producttypeId+"'";
		//String condition="and typeParentid='1'";
		
		//找到父亲id为1  3 10 11 12 13的一级分类  这里没问题
		ResultSet rs=(ResultSet) producttype.selectProductType(condition);
		
		
		
		try {
			while(rs.next())
			{
				
				String con="and producttypeId='"+rs.getInt(1)+"'";
				
				
				
					ResultSet res=(ResultSet) productdao.selectproduct(con);
				
					while(res.next())
					{
						
//						System.out.println(res.getInt(1));
//						
//						System.out.println(res.getString(2));
//						
//						System.out.println(res.getString(3));
						
						
						Product product=new Product(res.getInt(1), res.getString(2), res.getInt(3), res.getString(4), res.getInt(5), res.getInt(6),  res.getString(7),res.getString(8),res.getInt(9),  res.getInt(10));
						
						
						arrlist.add(product);
				
					//Product product=new Product(res.getInt(1), res.getString(2), res.getInt(3), res.getString(4), res.getInt(5), res.getInt(6),  rs.getString(7),res.getString(8),res.getInt(9),  res.getInt(10));
					//arrlist.add(product);
					}
					
					res.close();
				
			}
			
			//把list放在 js里面
			//安卓与servlte交互的桥梁
			JSONArray jsarray=JSONArray.fromObject(arrlist);
			
			response.getWriter().write(jsarray.toString());
			
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
