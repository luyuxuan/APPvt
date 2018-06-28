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

import com.jsptest.pojo.FirstType;
import com.jsptest.pojo.Product;
import com.mysql.jdbc.ResultSet;
import com.testlistener.dao.ProductDao;
import com.testlistener.dao.ProductTypeDao;

/**
 * Servlet implementation class firsttypeforandroid
 */
@WebServlet("/firsttypeforandroid.do")
public class firsttypeforandroid extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public firsttypeforandroid() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		request.setCharacterEncoding("utf-8");
		
		response.setCharacterEncoding("utf-8");
		
		
		
		//先把数据放在一个list中
				ProductTypeDao  producttype=new ProductTypeDao();
				
				
				ArrayList<FirstType>  arrlist=new ArrayList<FirstType>();
				
				String condition="and typeParentid='0'";
				
				ResultSet rs=(ResultSet) producttype.selectProductType(condition);
				
				try {
					while(rs.next())
					{
						
						String producttypeChildName="";
					//为了找它的孩子name 先获得父亲id 1 3 10 11 12 13 没问题
						String con2="and typeParentid='"+rs.getInt(1)+"'";
						
						
					
						ResultSet rs2=(ResultSet) producttype.selectProductType(con2);
						
						if(rs2.next()==false)
						{
							producttypeChildName+="";
						}
					
						else
						{
							producttypeChildName+=rs2.getString(3);
							
							
							while(rs2.next())
							{
								producttypeChildName+="  ";
								producttypeChildName+=rs2.getString(3);
								producttypeChildName+=" ";
							}
							rs2.close();
						
					
						}
						System.out.println(producttypeChildName);
						FirstType ftype=new FirstType(rs.getInt(1), rs.getString(3),producttypeChildName);
						
						
						arrlist.add(ftype);
						
						
						
					}
					//每次都要close
					rs.close();
					
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
