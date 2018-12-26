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
			<th>Sub Category Name</th>
			<th>Sub Category Description</th>
			<th>Category Name</th>
		</tr>
		<c:forEach items="${subCategories}" var="subCategory">
			<tr>
				<td>${subCategory.subCategoryName}</td>
				<td>${subCategory.subCategoryDescription}</td>
				<td>${subCategory.category.categoryName}</td>
			</tr>
		</c:forEach>
	</table>
	</section>

</body>
</html>