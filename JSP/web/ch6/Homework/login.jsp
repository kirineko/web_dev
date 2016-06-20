<%@ page language="java" contentType="text/html; Charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; Charset=UTF-8">
<title>用户登录</title>
</head>
<body>
<form id="form1" name="login" method="post" action="loginlogic.jsp">
  <label for="textfield"></label>
  <table width="535" border="1">
    <tr>
      <td colspan="2"><div align="center">用户登录</div></td>
    </tr>
    <tr>
      <td width="94">用户名：</td>
      <td width="425"><label for="textfield2"></label>
      <input type="text" name="username" id="textfield2" /></td>
    </tr>
    <tr>
      <td>密码：</td>
      <td><label for="textfield3"></label>
      <input type="password" name="password" id="textfield3" /></td>
    </tr>
    <tr>
      <td colspan="2"><input type="submit" name="login" id="login" value="登录" />
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="reset" name="reset" id="reset" value="重置" /></td>
    </tr>
  </table>
</form>
</body>
</html>