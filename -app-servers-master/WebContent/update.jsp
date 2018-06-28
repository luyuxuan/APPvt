<%@ page language="java" contentType="text/html; charset=gbk"
    pageEncoding="gbk"%>
 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>   
    
    
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk">
<title>Insert title here</title>
</head>
<body>
	<form action="updateserverlet.do?productId=${product.productId}" method="post"
		enctype="multipart/form-data">
		<h1>编辑</h1>


		<p>
			名称：<input type="text" name="name" value="${product.productName}"/>
		</p>
		<p>
			分类：<select name="stament1">

				<option value=""></option>
				<option value="1 " selected="selected">服装</option>
				<option value="3">家电</option>

				<option value="10 ">美妆</option>
				<option value="11 ">母婴</option>
				<option value="12 ">皮具</option>

				<option value="13 ">食品</option>
			</select> &nbsp;&nbsp;&nbsp;&nbsp; 二级分类：<select name="stament2">
				<option value=""></option>
				<option value="5">皮包</option>
				<option value="4">彩电</option>
				<option value="2" selected="selected">皮靴</option>

			</select>
		</p>
		<p>
			价格：<input type="text" name="price" value="${product.productprice}"/> 原价：<input type="text"
				name="yuanlai_price" value="${product.productprice}"/>
		</p>
		<p>
			库存：<input type="text" name="kucun" value="${product.productInventory}"/> 时间： <input type="text"
				name="time"  value="${product.posttime}"/>
		</p>
		<p>
			图片： <img alt="" src="getimageforandroid.do?id=${product.productId}"/><br> <input type="text"
				name="dataname" /> <br> <input type="file" name="file" /> <br>
			最多可上传10张图片，每张图片不超过5M<br>
		<p>
			描述
			<textarea rows="10" cols="30" name="introduction"> ${product.productIntroduction}
</textarea>
		</p>
		<p>
			<input type="submit" id="but" value="确定" />

			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

			<button>取消</button>
		</p>
	</form>
</body>
</html>