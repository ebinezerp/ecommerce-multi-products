<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@include file="headtag.jsp"%>
</head>
<body>
	<%@include file="header.jsp"%>
	<section> 
		 <springform:form class="form" action="addproduct" method="post" modelAttribute="product">
		 <springform:select path=""></springform:select>
		 </springform:form>
	</section>
</body>
</html>