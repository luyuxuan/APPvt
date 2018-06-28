package com.testsession.business;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.ResultSet;
import com.testlistener.dao.UsersDao;

/**
 * Servlet implementation class managerseverlet
 */
@WebServlet("/usersseverlet.do")
public class usersseverlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public usersseverlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	protected void service(HttpServletRequest request , HttpServletResponse response)
			throws ServletException, IOException {
		
		
		
		
		
		String condition="";
		String account=request.getParameter("account");
		String email=request.getParameter("email");
		String stament=request.getParameter("stament");
		
		//获得删除id
		String delid=request.getParameter("delid");
		
		
		UsersDao users=new UsersDao();
		
		String pageNo=request.getParameter("pageNo");
    	int	pageNonew=0;
    	if(pageNo!=null&&!pageNo.equals(""))
    	{
    		//要判断一下是否为空  要是为空才能类型转换
    		pageNonew=Integer.parseInt(pageNo);
    		
    		
    		//没问题这步可以找到1 3
    		//System.out.println(tyForPar);
    	}
		//测试一下
		if(delid==null)
		{
			//System.out.println("大家好");
		}
		
		else
		{
			Boolean choose=users.delVip(Integer.parseInt(delid));
		}
		
		
		//Boolean choose=users.delVip(delid);
		
		//System.out.println(Integer.parseInt(delid));
		
		//对客户端传来的数据进行判断 只能在写空 ""写null会报错
		if(account!=null&&!account.equals("") )
		{
			condition+=" and userName='"+account+"'";
			
		}
		
		

		if(email!=null&&!email.equals("") )
		{
			
			condition+=" and userEmail='"+email+"'";
		}
		
		
		
		
		//那个option value="" 代表的就是空格 而不是空
		if(stament.equals(" "))
		{
			condition+=" ";
			
		}
		
		else
		{
			
			condition+=" and userState='"+stament+"'";
		}
		
	
		

		 condition+= " limit " + pageNonew * 2 + ",2";
		
		ResultSet rs=(ResultSet) users.selectVip(condition);
		
		String table="<table border=1  cellpadding=0 cellspacing=0><tr><th>编号</th><th>删除</th><th>图片</th><th>昵称</th><th>邮箱</th><th>积分</th><th>状态</th><th>操作</th></tr>";
		
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
				
				//展示图片
				table+=" <img src="+rs.getString(8)+">";
				
				table+="</td>";
				
				
				table+="<td>";
				
				table+=rs.getString(2);
				
				table+="</td>";
				
				
				
				table+="<td>";

				table+=rs.getString(5);
				
				
				table+="</td>";
				
				
				table+="<td>";
				
				
				table+=rs.getString(4);
				
				table+="</td>";
				
				
				
				
				table+="<td>";
				
//		  <select id="stament1">
//				<option ></option>
//				<option  value="正常">正常</option>
//				<option  value="冻结 ">冻结</option>
//				selected="selected"
//			</select>
				//用来判断
				String pd="正常";
			if(pd.equals(rs.getString(6)))
				
			{
				
				table+="<select>";
				table+="<option value="+"正常"+" selected="+"selected"+">";
				table+="正常";
				table+="</option>";
				
				table+="<option value="+"冻结"+">";
				table+="冻结";
				table+="</option>";
				table+="</select>";
				
				//table+=rs.getString(6);
			}	
			
			else
			{
				table+="<select>";
				table+="<option value="+"正常"+" >";
				table+="正常";
				table+="</option>";
				
				table+="<option value="+"冻结"+"  selected="+"selected"+">";
				table+="冻结";
				table+="</option>";
				table+="</select>";
			}
				table+="</td>";
				
				
				
				
				
				
				
				
				
				table+="<td>";
				
				//拼接字符串用+可以看作是常量
				//table+="<a herf="+"#"+">删除</a>";
				
				
				//拼接字符串用+可以看作是常量  onclick="delusers();"
				//table+="<a herf="+"#"+">删除</a>";
				table+="<a href="+"#"+"";
				table+=" onclick="+"delusers("+rs.getInt(1)+");"+"";
				table+=">";
				table+="删除";
				table+="</a>";
				
				table+="</td>";
				
				
				table+="</tr>";
				
				
				
				
			}
			
			table+="</table>";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		//把数据传过去
    	response.getWriter().write(table);
		
		
	}

}
