package com.servlte.business.forandroid;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

import com.mysql.jdbc.ResultSet;
import com.testlistener.dao.ProductDao;
import com.testlistener.dao.ProductTypeDao;

/**
 * Servlet implementation class getimageforandroid
 */
@WebServlet("/getimageforandroid.do")
public class getimageforandroid extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getimageforandroid() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//设置图片的类型 
		
		response.setContentType("image/png;charset=GB2312");
		
		//输入流  从文件里读    输入输出针对 程序   读写针对文件
		
		
		//下面这个路径是客户端请求从服务器端获取来的
	
		//从客户端请求图片的id
		
		
		
		
		int id=Integer.parseInt(request.getParameter("id"));
		
		
		ProductDao product=new ProductDao();
		
		String condition=" and productId='"+id+"'";
		
		String address="";
		
		ResultSet rs=(ResultSet) product.selectproduct(condition);
		
		try {
			while(rs.next())
			{
				address=rs.getString(4);
				
				System.out.println(address);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		FileInputStream inputstream=new FileInputStream(address);
		
		//写
		
		BufferedOutputStream outputstream=new BufferedOutputStream(response.getOutputStream());
		
		
		byte[] buffer=new byte[1024];
		
		int count=0;
		
		while((count=inputstream.read(buffer))>=0)
		{
			outputstream.write(buffer);
		}
		
		
		System.out.println(outputstream);
		
		inputstream.close();
		outputstream.close();
		outputstream.close();
	}
}
