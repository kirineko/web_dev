<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="login" class="lich.im.loginLogic" scope="session"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<% java.util.Date thisday = new java.util.Date();
   String datetime=thisday.toString(); %>
<jsp:setProperty property="username" param="username" name="login"/>
<jsp:setProperty property="password" param="password" name="login"/>
<jsp:setProperty property="logintime" value="<%=datetime%>" name="login"/><br/>
<% if(login.getResult())
{
 %>   <p>单击超链接，进入字符串输入页面
      <a href="inputString.jsp">欢迎！</a></p><br/>
                您输入的用户名是为：<jsp:getProperty name="login" property="username"/>
	  <br/>
   	      您的登录时间是：<jsp:getProperty name="login" property="logintime"/>
<br/>
 <% } else
 {		
 %>		<p>用户名或密码不能为空，请重新输入！
 		<a href="login.jsp">返回输入用户名和密码</a></p>
 <% 	
 }
 %>  
 </body>
</html>