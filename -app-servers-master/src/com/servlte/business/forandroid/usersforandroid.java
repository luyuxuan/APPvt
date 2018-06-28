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
import com.jsptest.pojo.Users;
import com.mysql.jdbc.ResultSet;
import com.testlistener.dao.ProductDao;
import com.testlistener.dao.UsersDao;

/**
 * Servlet implementation class managerforandroid
 */
@WebServlet("/usersforandroid.do")
public class usersforandroid extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public usersforandroid() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		response.setCharacterEncoding("utf-8");
		
		//先把数据放在一个list中
		UsersDao usersdao=new UsersDao();
		
		
		ArrayList<Users>  arrlist=new ArrayList<Users>();
		
		String condition="";
		
		ResultSet rs=(ResultSet) usersdao.selectVip(condition);
		
		try {
			while(rs.next())
			{
				
				Users users=new Users(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),  rs.getString(6),  rs.getInt(7), rs.getString(8));
				
				
				arrlist.add(users);
				
				
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
