<%@ page language="java" contentType="text/html; charset=gbk"
    pageEncoding="gbk"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk">
<title>Insert title here</title>
</head>
<body>
	<form action="addserverlet.do" method="post"
		enctype="multipart/form-data">
		<h1>新增</h1>


		<p>
			名称：<input type="text" name="name" />
		</p>
		<p>
			分类：<select name="stament1">

				<option value=""></option>
				<option value="1 ">服装</option>
				<option value="3">家电</option>

				<option value="10 ">美妆</option>
				<option value="11 ">母婴</option>
				<option value="12 ">皮具</option>

				<option value="13 ">食品</option>
			</select> &nbsp;&nbsp;&nbsp;&nbsp; 二级分类：<select name="stament2">
				<option value=""></option>
				<option value="5">皮包</option>
				<option value="4">彩电</option>
				<option value="2">皮靴</option>

			</select>
		</p>
		<p>
			价格：<input type="text" name="price" /> 原价：<input type="text"
				name="yuanlai_price" />
		</p>
		<p>
			库存：<input type="text" name="kucun" /> 时间： <input type="text"
				name="time" />
		</p>
		<p>
			图片： <img alt="" /><br> <input type="text"
				name="dataname" /> <br> <input type="file" name="file" /> <br>
			最多可上传10张图片，每张图片不超过5M<br>
		<p>
			描述
			<textarea rows="10" cols="30" name="introduction">
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