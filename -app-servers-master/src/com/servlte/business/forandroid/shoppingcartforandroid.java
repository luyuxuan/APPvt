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

import com.jsptest.pojo.ShopCart;
import com.mysql.jdbc.ResultSet;
import com.testlistener.dao.ProductDao;
import com.testlistener.dao.ShoppingCartDao;
import com.testlistener.dao.UsersDao;

/**
 * Servlet implementation class shoppingcartforandroid
 */
@WebServlet("/shoppingcartforandroid.do")
public class shoppingcartforandroid extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public shoppingcartforandroid() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		
		//int productId=Integer.parseInt(request.getParameter("productId"));
		//int usersId=Integer.parseInt(request.getParameter("usersId"));
		//int productnum=Integer.parseInt(request.getParameter("productnum"));
		
		//传过来userName
		String userName=request.getParameter("userName");
		int usersId=0;
		UsersDao user=new UsersDao();
		String c=" and userName='"+userName+"' ";
		ResultSet resset=(ResultSet) user.selectVip(c);
		
		try {
			resset.next();
			usersId=resset.getInt(1);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		ShoppingCartDao shopcartdao=new ShoppingCartDao();
		
		ProductDao product=new ProductDao();
		
		String condition=" and usersId='"+usersId+"' ";
		//String condition=" and usersId='1' ";
		ResultSet res=(ResultSet) shopcartdao.selectshoppingcart(condition);
		
		ArrayList<ShopCart> list=new ArrayList<ShopCart>();
		
		try {
			while(res.next())
			{
				//获得商品的Id
				String con=" and productId='"+res.getInt(1)+"'";
				
				
				System.out.println(con);
				
				ResultSet rs=(ResultSet) product.selectproduct(con);
				//oneallprice, oneproductnum,
				while(rs.next())
				{
					ShopCart shopcart=new ShopCart(rs.getString(2), rs.getInt(3), 123, 3, rs.getInt(5));
					
					
					list.add(shopcart);
				}
				
				
			}
			
			JSONArray json=JSONArray.fromObject(list);
			
			
			response.getWriter().write(json.toString());
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Boolean bol=shopcart.insertshoppingcart(productId, usersId, productnum);
		
	}

}
