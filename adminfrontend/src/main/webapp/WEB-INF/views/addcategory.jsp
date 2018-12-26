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
	
	<section id="" class="col-md-4 offset-md-4">
	
		<springform:form action="addcategory" method="post" modelAttribute="category" class="form">
			<div class="form-group">
				<label for="categoryName">Category Name</label>
				<springform:input path="categoryName" class="form-control"/>
			</div>
			<div class="form-group">
				<label for="categoryDescription">Category Description</label>
				<springform:input path="categoryDescription" class="form-control"/>
			</div>
			<div class="form-group">
				<springform:button value="submit">Add Category</springform:button>
			</div>
		</springform:form>
		
	</section>

</body>
</html>