<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="login" class="lich.im.loginLogic" scope="session"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>计算</title>
</head>
<body>
<% String input=request.getParameter("input");
%>
<% if(input!=null)
{  	   int length=input.length();
	   if(length!=0)
	   {
	   out.println("您输入的字符串是:"+input);
	   out.println("<br>长度是："+length);
	   }
	   else
	   {
	   out.println("字符串长度不能为0,请重新输入");
	   response.sendRedirect("inputString.jsp");
	   }
}
   else
   {
       out.println("字符串不能是null，请重新输入");
       response.sendRedirect("inputString.jsp");
   } 
   %>
<br>您的用户名是：<jsp:getProperty name="login" property="username"/>
<br>您的登录时间是：<jsp:getProperty name="login" property="logintime"/>
</body>
</html>