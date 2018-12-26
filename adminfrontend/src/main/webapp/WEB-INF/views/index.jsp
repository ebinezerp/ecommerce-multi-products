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

	<section id="loginform" class="col-md-4 offset-md-4 d-flex flex-column">

	<div class="card align-middle">
		<div class="card-heading bg-primary text-center">
			<h1>Login</h1>
		</div>
		<div class="card-body">
			<form class="form" action="login" method="post">
				<div class="form-group">
					<label for="employeeId">Employee Id</label> <input type="text"
						name="employeeId" class="form-control">
				</div>
				<div class="form-group">
					<label for="password">Password</label> <input type="password"
						name="password" class="form-control">
				</div>
				<div class="form-group">
					<input type="submit" class="form-control btn btn-primary" />
				</div>

			</form>
		</div>
	</div>

	</section>

</body>
</html>