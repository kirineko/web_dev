<%-- 
    Document   : DML
    Created on : 2010-12-7, 21:00:48
    Author     : liyi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="lich.im.dml" %>
<jsp:useBean id="base" class="lich.im.dml" scope="session"/>
<jsp:setProperty  name="base" property="number" param="number"/>
<jsp:setProperty  name="base" property="salaryMin" param="salaryMin"/>
<jsp:setProperty  name="base" property="salaryMax" param="salaryMax"/>
<jsp:setProperty  name="base" property="number2" param="number2"/>
<jsp:setProperty  name="base" property="salaryMin2" param="salaryMin2"/>
<jsp:setProperty  name="base" property="salaryMax2" param="salaryMax2"/>
<jsp:setProperty  name="base" property="id" param="id"/>
<jsp:setProperty  name="base" property="sd" param="sd"/>
<jsp:setProperty  name="base" property="ziduan" param="ziduan"/>
<jsp:setProperty  name="base" property="keyWord" param="keyWord"/>
<jsp:setProperty  name="base" property="ziduan2" param="ziduan2"/>
<jsp:setProperty  name="base" property="keyWord2" param="keyWord2"/>
<!doctype html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style type="text/css">
.html1 {
	color: #CF0;
	font-weight: bold;
	font-size: 36px;
}
</style>
    </head>
   <BODY><Font size=2>
        <table width="1181" height="631" border="1">
  <tr>
    <td width="1171" height="103" bgcolor="#00CCFF"><div align="center" class="html1">作业6</div></td>
  </tr>
  <tr>
    <td height="495">
      <table width="937" height="147" border="1">
  <tr>
    <td width="205">客户查询(根据客户ID查询)</td>
    <td width="716"><FORM action="" Method="post">输入客户ID：<Input type=text name="number"><Input type=submit name="g1" value="提交">
            <Input type=hidden value="1" name="id"> </Form></td>
  </tr>
  <tr>
    <td>客户查询(根据收入查询) </td>
    <td><FORM action="" Method="post">收入在<Input type=text name="salaryMin" size=5>至
        <Input type=text name="salaryMax" size=5>之间
         <Input type=submit  value="提交">
         <Input type=hidden value="2" name="id"></Form></td>
  </tr>
  <tr>
    <td>模糊查询</td>
    <td><FORM action="" method=post name=form>
   选择:<Select name="ziduan">
         <Option value="Name">姓名 
         <Option value="ID">客户ID 
    </Select>
   含有:<INPUT type="text" name="keyWord"> 
        <Input type=submit name="g2" value="提交">
        <Input type=hidden value="3" name="id">
</Form></td>
  </tr>
  <tr>
    <td>组合查询</td>
    <td><Form action="" method=post name="form2">输入客户ID:<Input type=text name="number2">
       <br />收入在<Input type=text name="salaryMin2" size=5>至
        <Input type=text name="salaryMax2" size=5>之间
        <br/>选择:<Select name="ziduan2">
         <Option value="Name">姓名 
         <Option value="Phone">电话 
    </Select>
   含有:<INPUT type="text" name="keyWord2"> 
        <Input type=submit name="g3" value="提交">
        <Input type=hidden value="4" name="id">
       </form></td>
  </tr>
</table>
       <br>
查询结果为：
<BR><jsp:getProperty name="base" property="queryResult"/>
<br><% String username=(String)session.getAttribute("username");
   String password=(String)session.getAttribute("password");
   String logintime=(String)session.getAttribute("logintime");
   out.println("<br>您的用户名是："+username);
   out.println("<br>您的登录时间是："+logintime);
    %>
    </td>
  </tr>
  <tr>
    <td height="23"><div align="right">2010年11月</div></td>
  </tr>
</table>
</Font></BODY></HTML>