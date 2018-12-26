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
	<%@include file="header.jsp"%>

	<section class="col-md-4 offset-md-4">
	<table>
		<tr>
			<th>Category Name</th>
			<th>Category Description</th>
		</tr>
		<c:forEach items="${categories}" var="category">
			<tr>
				<td>${category.categoryName}</td>
				<td>${category.categoryDescription}</td>
			</tr>
		</c:forEach>
	</table>
	</section>

</body>
</html>