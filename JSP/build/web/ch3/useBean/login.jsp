<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; Charset=utf-8" />
<title>Untitled Document</title>
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
    <td width="1171" height="103" bgcolor="#00CCFF"><div align="center" class="html1">作业3</div></td>
  </tr>
  <tr>
    <td height="495"><% session.invalidate();  %>
<form id="form1" name="login" method="post" action="loginlogic.jsp">
  <label for="textfield"></label>
  <div align="center">
    <table width="719" border="1">
      <tr>
        <td colspan="2"><div align="center">用户登录</div></td>
        </tr>
      <tr>
        <td width="94">用户名：</td>
        <td width="1058"><label for="textfield2"></label>
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
  </div>
</form></td>
  </tr>
  <tr>
    <td height="23"><div align="right">2010年11月</div></td>
  </tr>
</table>
</body>
</html>
