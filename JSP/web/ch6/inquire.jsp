<%-- 
    Document   : inquire
    Created on : 2010-12-6, 17:36:21
    Author     : liyi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="database.operation.QueryBean" %>
<jsp:useBean id="base" class="database.operation.QueryBean" scope="session"/>
<jsp:setProperty name="base" property="*" />
<!doctype html>
<html>
    <body bgcolor="cyan">
        <Font size="2">
        <form action="" method="post">
            输入数据库名：<input type="text" name="databaseName" size="8">
            输入表的名字：<input type="text" name="tableName" size="8">
            <br>输入用户名：<input type="text" name="user" size="6">
            输入密码：<input type="password" name="secret" size="6">
            <input type="submit" name="g" value="提交">
        </form>
        在<jsp:getProperty name="base" property="tableName"/>表查询到记录:
<BR> <jsp:getProperty name="base" property="queryResult"/>
      </font>
    </body>
</html>
