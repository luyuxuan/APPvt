package com.send.datatest;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

/**
 * Servlet implementation class senddataseverlet
 */
@WebServlet("/senddataseverlet2.do")
public class senddataseverlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public senddataseverlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("gbk");
		response.setCharacterEncoding("gbk");
		
		SmartUpload smart=new SmartUpload();
		
		//给smart初始化
		smart.initialize(getServletConfig(), request, response);
		
		
		try {
			
			//开始上传
			smart.upload();
			
			//保存到服务端  count为保存文件的数量  可设置数量的多少
			//int count = smart.save("d:/upload");
			
			
			//设置文件名字 比如abc
			String name=smart.getRequest().getParameter("dataname");
			
			
			//文件的后缀名   比如jpg
			String  ext=smart.getFiles().getFile(0).getFileExt();
			
			//另存为拼出文件的路径 比如你起的名字abc.jpg
			smart.getFiles().getFile(0).saveAs("d:/upload/"+name+"."+ext);
			
			//获取文件全称
			String fileName = smart.getFiles().getFile(0).getFileName();
			 
			//测试
			response.getWriter().write(name+":"+fileName+"."+ext);
			

		} catch (SmartUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
