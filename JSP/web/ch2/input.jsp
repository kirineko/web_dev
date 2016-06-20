<%@ page language="java" contentType="text/html; Charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; Charset=UTF-8">
<title>用户输入</title>
</head>
<body>
<form id="form1" name="form1" method="post" action="main.jsp">
<table width="663" height="226" border="1">
  <tr>
    <td colspan="2"><div align="center">请输入相关数据：</div></td>
  </tr>
  <tr>
    <td width="132">圆（circle）</td>
    <td width="521">
    半径：
    <input type="text" name="r" id="textfield" />
  </td>
  </tr>
  <tr>
    <td>梯形（ladder）</td>
    <td>
        <p>
        上底：        
          <input type="text" name="a" id="textfield2" />
        </p>
        <p>
        下底：        
          <input type="text" name="b" id="textfield3" />
        </p>
        <p>&nbsp;高 ： 
           <input type="text" name="h" id="textfield5" value=""/>
        </p>
    </td>
  </tr>
  <tr>
    <td>
    <input type="submit" name="submit" id="button" value="提交" />
    </td>
    <td>
    <input type="reset" name="reset" id="button2" value="重置" />
    </td>
  </tr>
</table>
</form>
</body>
</html>