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

	<section class="col-sm-4 offset-sm-4"> <springform:form
		action="addattribute" method="post" modelAttribute="attribute">
		<div class="form-group">
			<label for="attributeName">Attribute Name</label>
			<springform:input path="attributeName" class="form-control" />
		</div>
		<div class="form-group">
			<label for="subCategories">Sub Categories</label>
			<springform:select path="subCategories" items="${subCategories}" itemLabel="subCategoryName" itemValue="subCategoryId" multiple="true"></springform:select>
		</div>
		<div class="form-group">
			<springform:button value="submit" class="form-control btn btn-primary">Submit</springform:button>
		</div>
	</springform:form> </section>
</body>
</html>