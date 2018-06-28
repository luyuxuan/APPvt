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

/**
 * Servlet implementation class managerforandroid
 */
@WebServlet("/managerforandroid.do")
public class managerforandroid extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public managerforandroid() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		response.setCharacterEncoding("utf-8");
		
		//先把数据放在一个list中
		ProductDao  productdao=new ProductDao();
		
		
		ArrayList<Product>  arrlist=new ArrayList<Product>();
		
		String condition="";
		
		ResultSet rs=(ResultSet) productdao.selectproduct(condition);
		
		try {
			while(rs.next())
			{
				
				Product product=new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getInt(6),  rs.getString(7),rs.getString(8),rs.getInt(9),  rs.getInt(10));
				
				
				arrlist.add(product);
				
				
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
