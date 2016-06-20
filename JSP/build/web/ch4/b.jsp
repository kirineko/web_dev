<%@ page language="java" contentType="text/html; Charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="ss" class="lich.im.s" scope="page"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; Charset=UTF-8">
<title>计算结果</title>
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
    <td width="1171" height="103" bgcolor="#00CCFF"><div align="center" class="html1">作业4</div></td>
  </tr>
  <tr>
    <td height="495">
        通过表单参数给bean赋值<jsp:setProperty property="*" name="ss"/><br/>
您输入的矩形的长为：<jsp:getProperty name="ss" property="length"/>
<br/>
您输入的矩形的宽为：<jsp:getProperty name="ss" property="width"/>
<br/>
矩形的面积为：<jsp:getProperty name="ss" property="area"/>
    </td>
  </tr>
  <tr>
    <td height="23"><div align="right"><a href="../ch6/login.jsp">作业5</a>&nbsp;2010年11月</div></td>
  </tr>
</table>

</body>
</html>