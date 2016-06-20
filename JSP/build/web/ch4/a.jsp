<%@ page language="java" contentType="text/html; Charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; Charset=UTF-8">
<title>输入矩形的长和宽</title>
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
       <form id="form1" name="input" method="post" action="b.jsp">
  <table width="555" border="1">
    <tr>
      <td colspan="2">请输入矩形的长和宽：</td>
    </tr>
    <tr>
      <td>长：
        <label for="textfield"></label>
      <input type="text" name="length" id="textfield" />
      cm</td>
      <td>宽：
        <label for="textfield2"></label>
      <input type="text" name="width" id="textfield2" />
      cm</td>
    </tr>
    <tr>
      <td colspan="2"><input type="submit" name="submit" id="button" value="确定" /> 
       &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
       <input type="reset" name="reset" id="button2" value="重置" />       &nbsp;&nbsp;&nbsp;<br /></td>
    </tr>
  </table>
</form>
    </td>
  </tr>
  <tr>
    <td height="23"><div align="right"><a href="../ch6/login.jsp">作业5</a>&nbsp;2010年11月</div></td>
  </tr>
</table>

</body>
</html>