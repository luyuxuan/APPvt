package com.servlte.business.forandroid;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.jsptest.pojo.Manager;
import com.testlistener.dao.UsersDao;

/**
 * Servlet implementation class ForServlteAndroid
 */
@WebServlet("/ForServlteAndroid.do")
public class ForServlteAndroid extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForServlteAndroid() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    	
    	request.setCharacterEncoding("utf-8");
    	response.setCharacterEncoding("utf-8");
    	UsersDao dao=new UsersDao();
		ResultSet rs=dao.selectVip("");
		//把rs转换为arraylist
		ArrayList<Manager> users=new ArrayList<Manager>();
		try {
			while(rs.next())
			{
				Manager user=new Manager(rs.getInt(1), 
						rs.getString(2), rs.getString(3));
				users.add(user);
			}
      
			//安卓与servlte交互的桥梁
			JSONArray arr=JSONArray.fromObject(users);
			
			
			response.getWriter().write(arr.toString());
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    	
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
