package com.testsession.business;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsptest.pojo.Product;
import com.mysql.jdbc.ResultSet;
import com.testlistener.dao.ProductDao;

/**
 * Servlet implementation class jstl
 */
@WebServlet("/jstl.do")
public class jstl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public jstl() {
        super();
        // TODO Auto-generated constructor stub
    }

@Override
protected void service(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	
	ProductDao productdao=new ProductDao();
	
	//ResultSet rs=product.selectproduct(condition)
	
	
	int updateId=Integer.parseInt(request.getParameter("updateId"));
	
	
	System.out.println(updateId);
	
	String condition=" and productId='"+updateId+"'";
	
	ResultSet res=(ResultSet) productdao.selectproduct(condition);
	
	try {
		res.next();
		
		
		Product product=new Product(res.getInt(1), res.getString(2), res.getInt(3), res.getString(4), res.getInt(5), res.getInt(6),  res.getString(7),res.getString(8),res.getInt(9),  res.getInt(10));
		
		
		//传过去一个对象 key和value  4种方式 apliction <session<request<pagecontext 
		String id = "111";
		
		  request.setAttribute("product", product);
		  
	
		 //返回给浏览器一个update.jsp页面
		request.getRequestDispatcher("update.jsp").forward(request, response);
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	
	
	
	
	
}

}
