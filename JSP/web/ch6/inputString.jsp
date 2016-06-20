<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>字符串输入</title>
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
<% String username=(String)session.getAttribute("username");
   String password=(String)session.getAttribute("password");
   String logintime=(String)session.getAttribute("logintime");
   out.println("<br>您的用户名是："+username);
   out.println("<br>您的登录时间是："+logintime);
    %>
    </td>
  </tr>
  <tr>
    <td height="23"><div align="right"><a href="Homework/DML.jsp">作业6</a>&nbsp;2010年11月</div></td>
  </tr>
</table>
</body>
</html>