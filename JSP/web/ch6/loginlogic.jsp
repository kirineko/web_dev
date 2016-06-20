<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
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
    <td width="1171" height="103" bgcolor="#00CCFF"><div align="center" class="html1">作业5</div></td>
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
   } 
    Connection con;
    Statement sql;
    ResultSet rs;
    boolean flag=false;
    try{
    	Class.forName("net.sourceforge.jtds.jdbc.Driver");
    }
    catch(Exception e)
    {out.print(e);
    }
    try{ String url="jdbc:jtds:sqlserver://127.0.0.1:1433/users";
    String user="sa";
    String psw="as798360687";
    con=DriverManager.getConnection(url,user,psw);
    sql=con.createStatement();
    rs=sql.executeQuery("select * from login");
    while(rs.next())
    {
    	if(username.equals(rs.getString("userName"))&&password.equals(rs.getString("passWord")))
    	{
    		flag=true;
    	}	
    }
    }
    catch(Exception e)
    { out.print(e);
    } %>
 <% if(username.length()==0||password.length()==0)
 {
 %>   <p>用户名或密码不能为空，请重新输入！
 <a href="login.jsp">重新登录</a></p>
 <%
 }
    else if(flag==false)
   {
%>   <p>用户名或密码错误，请重新输入
<a href="login.jsp">重新登录</a></p>
<% 
 }
    else
{
%><p>单击超链接进入页面！
<a href="Homework/DML.jsp">欢迎！</a></p>
<%
}
%>
    </td>
  </tr>
  <tr>
    <td height="23"><div align="right"><a href="Homework/DML.jsp">作业6</a>&nbsp;2010年11月</div></td>
  </tr>
</table>
</body>
</html>