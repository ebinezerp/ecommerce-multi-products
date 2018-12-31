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
	<section id="" class="col-md-4 offset-md-4"> <springform:form
		action="addsubcategory" method="post" modelAttribute="subcategory"
		class="form">
		<div class="form-group">
			<label for="category">Category</label>
			<springform:select path="category.categoryId" class="form-control">
				<c:forEach items="${categories}" var="category">
					<springform:option value="${category.categoryId}">${category.categoryName}</springform:option>
				</c:forEach>
			</springform:select>
		</div>
		<div class="form-group">
			<label for="subCategoryName">Sub Category Name</label>
			<springform:input path="subCategoryName" class="form-control" />
		</div>
		<div class="form-group">
			<label for="subCategoryDescription">Sub Category Description</label>
			<springform:input path="subCategoryDescription" class="form-control" />
		</div>
		<div class="form-group">
			<label for="attributes">Attributes</label>
			<springform:select path="attributes" class="form-control">
				<springform:options items="${attributes}" itemLabel="attributeName" itemValue="attributeId"/>
			</springform:select>
		</div>
		<div class="form-group">
			<springform:button value="submit">Add SubCategory</springform:button>
		</div>
	</springform:form> </section>

</body>
</html>