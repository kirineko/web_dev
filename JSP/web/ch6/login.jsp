<%@ page language="java" contentType="text/html; Charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; Charset=UTF-8">
<title>用户登录</title>
<style type="text/css">
.html1 {
	color: #CF0;
	font-weight: bold;
	font-size: 36px;
}
</style>
</head>

<body>
    <table width="1181" height="631" border="1">
  <tr>
    <td width="1171" height="103" bgcolor="#00CCFF"><div align="center" class="html1">作业5</div></td>
  </tr>
  <tr>
    <td height="495">
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
    </td>
  </tr>
  <tr>
    <td height="23"><div align="right"><a href="Homework/DML.jsp">作业6</a>&nbsp;2010年11月</div></td>
  </tr>
</table>

</body>
</html>