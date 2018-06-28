<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<%

	//这个cookie不仅包括你所建的cookie还有一个jssessioned的cookie
	
	Cookie[] cookies=request.getCookies();
	
	String account="";
	
	if(cookies!=null)
	{
		for(Cookie cookie:cookies)
		{
			if(cookie.getName().equals("account"))
			{
				account=cookie.getValue();
			}
		
		}
		//得到第一个cookie
		//account=cookies[0].getValue();
	}

%>

</head>
<body>



<form action="logsession.do" method="post">
账号:
<input type="text" name="account" value="<%=account %>"/>
<br>
密码:
<input type="password" name="password"/>
<br>
<input type="submit" value="登录">
</form>
</body>
</html>