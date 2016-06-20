<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
        <% String username=request.getParameter("username");
   String password=request.getParameter("password");
   java.util.Date thisday = new java.util.Date();
   String datetime=thisday.toString() ;
   if(username==null)
   {
       username="";
   }
   else if(password==null)
   {
       password="";
   }
   else
   {
       session.setAttribute("username",username);
       session.setAttribute("password",password);
       session.setAttribute("logintime",datetime);
   } %>
 <% if(username.length()>0&&password.length()>0)
 {
 %>   <p>单击超链接，进入字符串输入页面
      <a href="inputString.jsp">欢迎！</a></p>
 <% } else
 {		out.println("用户名或密码不能为空，请重新输入！");	
 %>	<a href="login.jsp">返回输入用户名和密码</a>
 <% 	
 }
 %>  
    </td>
  </tr>
  <tr>
    <td height="23"><div align="right"><a href="../ch4/a.jsp">作业4</a>&nbsp;2010年11月</div></td>
  </tr>
</table>

</body>
</html>