<%@ page language="java" contentType="text/html; charset=gbk"
    pageEncoding="gbk"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk">
<title>Insert title here</title>
</head>
<body>

<form action="senddataseverlet.do"  method="post"
enctype="multipart/form-data">

		<input type="text" name="dataname"/>
		<br>
		
		<input type="file" name="file" />
		<br>
		<input type="submit" value="开始上传"/>
</form>


</body>
</html>