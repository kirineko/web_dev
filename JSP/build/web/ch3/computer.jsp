<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>计算</title>
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
    <td height="495">
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
<% String username=(String)session.getAttribute("username");
   String password=(String)session.getAttribute("password");
   String logintime=(String)session.getAttribute("logintime");
   out.println("<br>您的用户名是："+username);
   out.println("<br>您的登录时间是："+logintime);
%>
    </td>
  </tr>
  <tr>
    <td height="23"><div align="right"><a href="../ch4/a.jsp">作业4</a>&nbsp;2010年11月</div></td>
  </tr>
</table>

</body>
</html>