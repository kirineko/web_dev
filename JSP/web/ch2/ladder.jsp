<%@ page language="java" contentType="text/html; Charset=UTF-8"
    pageEncoding="UTF-8"%>
<%! public String getArea(double a,double b,double h)
		{
			double area=(a+b)*h/2;
			return ""+area;
		}
%>
<%  String sideA=request.getParameter("sideA");
	String sideB=request.getParameter("sideB");
	String sideH=request.getParameter("sideH");
	double a=Double.parseDouble(sideA);
	double b=Double.parseDouble(sideB);
	double h=Double.parseDouble(sideH);
%>

<p><Font color=blue size=4>我负责计算梯形的面积<Br>
梯形的上底是:<%= sideA %>,下底是：<%= sideB %>,高是：<%= sideH %>,面积是：<%= getArea(a,b,h) %>
</Font></p>
