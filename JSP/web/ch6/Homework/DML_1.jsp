
<%-- 
    Document   : DML_1
    Created on : 2010-12-9, 23:15:48
    Author     : liyi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="lich.im.dml" %>
<jsp:useBean id="base" class="lich.im.dml" scope="session"/>
<jsp:setProperty  name="base" property="sd" param="sd"/>
<!doctype html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <BODY><Font size=2>
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
<BR><jsp:getProperty name="base" property="id"/>
<BR><jsp:getProperty name="base" property="sd"/>
<BR><jsp:getProperty name="base" property="keyWord"/>
<BR><jsp:getProperty name="base" property="ziduan"/>
  <BR><jsp:getProperty name="base" property="queryResult"/>
</Font></BODY>
</html>
