package com.testsession.business;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import com.mysql.jdbc.ResultSet;
import com.testlistener.dao.ProductDao;

/**
 * Servlet implementation class addserverlet
 */
@WebServlet("/addserverlet.do")
public class addserverlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addserverlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		name:name,
//		 stament1:stament1,
//		 stament2:stament2,
//		 account:account,
//		 price:price,
//		 yuanlai_price:yuanlai_price,
//		 kucun:kucun,
//		 time:time,
//		 introduction:introduction,
		
//		request.setCharacterEncoding("utf-8");
//		response.setCharacterEncoding("utf-8");
		
		request.setCharacterEncoding("gbk");
		response.setCharacterEncoding("gbk");
		
		SmartUpload smart=new SmartUpload();
		
		//给smart初始化
		smart.initialize(getServletConfig(), request, response);

    	
    	
    	
    	ProductDao product=new ProductDao();
    	
		try {
			
			//开始上传
			smart.upload();
			
			//保存到服务端  count为保存文件的数量  可设置数量的多少
			//int count = smart.save("d:/upload");
		
			
			//一级分类
	    	//int idOne=0;
	    	int priceint=0;
			
			
			
			String  ext="";
			//获取图片路径名
	    	String file="";

		 	String name=smart.getRequest().getParameter("name");
	    	
		 	
		 	//System.out.println(name);
		    
	    	String stament1=smart.getRequest().getParameter("stament1");
	    	String stament2=smart.getRequest().getParameter("stament2");
	    	
	    	//均不为空
	    	String price=smart.getRequest().getParameter("price");
	    	String yuanlai_price=smart.getRequest().getParameter("yuanlai_price");
	    	String kucun=smart.getRequest().getParameter("kucun");
	    	
	    	
	    	System.out.println(kucun);
	    	//String yuanlai_price=request.getParameter("yuanlai_price");
	    	
	    	
	    	//String kucun=request.getParameter("kucun");
	    	String time=smart.getRequest().getParameter("time");
	    	String introduction=smart.getRequest().getParameter("introduction");
			
			//设置文件名字 比如abc
			String namefile=smart.getRequest().getParameter("dataname");
			
			
			//文件的后缀名   比如jpg
			 ext=smart.getFiles().getFile(0).getFileExt();
			
			//另存为拼出文件的路径 比如你起的名字abc.jpg
			smart.getFiles().getFile(0).saveAs("d:/upload/"+namefile+"."+ext);
			
			//获取文件全称
			String fileName = smart.getFiles().getFile(0).getFileName();
			 
			//测试
			//response.getWriter().write(name+":"+fileName+"."+ext);
			 file="d:/upload/"+namefile+"."+ext;
			 
			 
			 if(price!=null&&!price.equals(""))
		    	{
		    		//要判断一下是否为空  要是为空才能类型转换
		    		priceint=Integer.parseInt(price);
		    		
		    		
		    		//没问题这步可以找到1 3
		    		//System.out.println(tyForPar);
		    	}
		    	
		    	//原价
		    	int yuanint=0;
		    	
		    	
		    
		    	
		    	if(yuanlai_price!=null&&!yuanlai_price.equals(""))
		    	{
		    		//要判断一下是否为空  要是为空才能类型转换
		    		yuanint=Integer.parseInt(yuanlai_price);
		    		
		    		
		    		//没问题这步可以找到1 3
		    		//System.out.println(tyForPar);
		    	}
		    	
		    	
		    	int kucunint=0;
		    	
		    	
		    
		    	
		    	if(kucun!=null&&!kucun.equals(""))
		    	{
		    		//要判断一下是否为空  要是为空才能类型转换
		    		kucunint=Integer.parseInt(kucun);
		    		
		    		
		    		//没问题这步可以找到1 3
		    		//System.out.println(tyForPar);
		    	}
		    	
		    	
		    	
//		    	if(stament1!=null&&!stament1.equals(""))
//		    	{
//		    		//要判断一下是否为空  要是为空才能类型转换
//		    		idOne=Integer.parseInt(stament1);
//		    		
//		    		
//		    		//没问题这步可以找到1 3
//		    		//System.out.println(tyForPar);
//		    	}
		    	
		    	//二级分类
		    	int idTwo=0;
		    	
		    	//打折
		    	int discount=0;
		    	if(yuanint!=0)
		    	{
		    		discount=priceint/yuanint;
		    	}
		    	if(stament2!=null&&!stament1.equals(""))
		    	{
		    		//要判断一下是否为空  要是为空才能类型转换
		    		idTwo=Integer.parseInt(stament2);
		    		
		    		
		    		//没问题这步可以找到1 3
		    		//System.out.println(tyForPar);
		    	}
		    	
		    	String condition=" and productName='"+name+"'";
		    	
		    	
		    	ResultSet rs=(ResultSet) product.selectproduct(condition);
		    	
		    	int choose=1;
		    	
		    	//代表已经有了这件商品
		    	try {
					while(rs.next())
					{
						response.getWriter().write("该商品已存在");
						
						choose=0;
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    	//Boolean bol=product.insertproduct(name, price, file, kucun, 0, introduction, time, discount, idTwo);
		    	
		    	if(choose==1)
		    	{
		    	Boolean bol=product.insertproduct(name, priceint, file, kucunint, 0, introduction, time, discount, idTwo);
		    	
		    	if(bol=true)
		    	{
		    		response.getWriter().write("添加成功!");
		    	}
		    	
		    	else
		    	{
		    		response.getWriter().write("添加失败!");
		    	}
		    	
		    	
		    	}

		} catch (SmartUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		 
	    	
	    	
	    
	    	
	    	
	}

}
