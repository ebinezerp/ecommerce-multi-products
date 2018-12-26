<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@include file="headtag.jsp"%>
</head>
<body>
	<%@include file="mainheader.jsp"%>


	<section class="col-md-8 offset-md-2">
		<section class="col-md-4">
			
		</section>
		<section class="col-md-4">
		<springform:form action="sellerreg" method="post" modelAttribute="seller">
			<springform:input path=""/>
		</springform:form>
		</section>
	</section>
</body>
</html>