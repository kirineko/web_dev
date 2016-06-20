<%@ page language="java" contentType="text/html; Charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; Charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%  String  sR=request.getParameter("r");
	String  sA=request.getParameter("a");
	String  sB=request.getParameter("b");
	String  sH=request.getParameter("h");
    double r=Double.parseDouble(sR);
    double a=Double.parseDouble(sA);
    double b=Double.parseDouble(sB);
    double h=Double.parseDouble(sH);
     %>
<br>加载circle.jsp计算半径为<%= r %>的圆的面积：
	<jsp:include page="circle.jsp">
	<jsp:param value="<%= r %>" name="sideR"/>
	</jsp:include>
<br>加载ladder.jsp计算上底为<%= a %>,下底为<%= b %>,高为<%= h %>的梯形的面积：
	<jsp:include page="ladder.jsp">
	<jsp:param value="<%= a %>" name="sideA"/>
	<jsp:param value="<%= b %>" name="sideB"/>
	<jsp:param value="<%= h %>" name="sideH"/>	
	</jsp:include>
</body>
</html>