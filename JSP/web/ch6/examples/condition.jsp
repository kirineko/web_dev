<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import="database.operation.*" %>
<jsp:useBean id="base" class="database.operation.ConditionQuery" scope="session"/>
<jsp:setProperty  name="base" property="number" param="number"/>
<jsp:setProperty  name="base" property="salaryMin" param="salaryMin"/>
<jsp:setProperty  name="base" property="salaryMax" param="salaryMax"/>
<HTML><BODY><Font size=2>
<FORM action="" Method="post">
 雇员查询(根据雇员号查询)
 输入雇员号:<Input type=text name="number"><Input type=submit name="g" value="提交">
</Form>
<FORM action="" Method="post">
  雇员查询(根据薪水查询)
  <BR> 薪水在<Input type=text name="salaryMin" size=5>至
        <Input type=text name="salaryMax" size=5>之间
         <Input type=submit  value="提交">
</Form>
 根据雇员号<jsp:getProperty name="base" property="number"/>查询到的记录:
<BR><jsp:getProperty  name="base" property="queryResultByNumber"/>
 薪水在<jsp:getProperty name="base" property="salaryMin"/>至
        <jsp:getProperty name="base" property="salaryMax"/>之间的记录:
<BR><jsp:getProperty  name="base" property="queryResultBySalary"/>
</Font></BODY></HTML>

