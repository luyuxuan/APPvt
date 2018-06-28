package com.testsession.business;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.testlistener.dao.UsersDao;

/**
 * Servlet implementation class logsession
 */
@WebServlet("/logsession.do")
public class logsession extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public logsession() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String account=request.getParameter("account");
		
		String password=request.getParameter("password");
		
		
		UsersDao managerdao=new UsersDao();
		
		int count=managerdao.getVipCount(account, password);
		
		if(count>0)
		{
			//把数据放入到Session
			//得到session如果没有则创建  如果有就直接获得
			
			//访问次数  通过getServletContext()来获得  application存放记录条数 从程序开始到查询关闭
//			Object logcount=getServletContext().getAttribute("logcount");
//			
//			
//			//打印通过system.print.out
//			
//			if(logcount!=null)
//			{
//				getServletContext().setAttribute("logcount", Integer.parseInt(logcount.toString())+1);
//			}
//			
//			
//			else
//			{
//				getServletContext().setAttribute("logcount", 1);
//			}
//			
			Cookie cookie=new Cookie("account", account);
			
			
			//cookie过期时间 单位是秒
			cookie.setMaxAge(3600);
			
			
			//服务器端发给浏览器信息
			response.addCookie(cookie);
			
			//当浏览器请求服务器时  要找一下浏览器里的session  来标识是哪一个客户端   jssessioned来判断
			//jssessioned存在客户端  用来判断是哪一个session即客户
			request.getSession(true).setAttribute("account", account);
        	response.sendRedirect("main.html");
		}
	}

}
