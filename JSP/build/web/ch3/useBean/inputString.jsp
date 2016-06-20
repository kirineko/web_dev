<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="login" class="lich.im.loginLogic" scope="session"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>字符串输入</title>
</head>
<body>
<form id="form1" name="input" method="post" action="computer.jsp">
  <p>请输入一个字符串：
    <label for="textfield"></label>
  <input type="text" name="input" id="textfield" />
  </p>
  <p>
    <input type="submit" name="button" id="button" value="确认" />
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  <input type="reset" name="button2" id="button2" value="重置" />
  </p>
</form>
<br>您的用户名是：<jsp:getProperty name="login" property="username"/>
<br>您的登录时间是：<jsp:getProperty name="login" property="logintime"/>
</body>
</html>