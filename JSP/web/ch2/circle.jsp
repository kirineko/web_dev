<%@ page language="java" contentType="text/html; Charset=UTF-8"
    pageEncoding="UTF-8"%>
<%! public String getArea(double r)
		{
			double area=3.14*r*r;
			return ""+area;
		}
%>
<%  String sideR=request.getParameter("sideR");
	double r=Double.parseDouble(sideR);
%>

<p><Font color=blue size=4>我负责计算圆的面积<Br>
圆的半径是:<%= sideR %>,面积是：<%= getArea(r) %>
</Font></p>
