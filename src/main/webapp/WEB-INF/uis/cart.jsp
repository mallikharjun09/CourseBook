<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<center>
			<h2>Please Enter your Cradit/Dabit card details</h2>
		</center>
		<c:url var="address" value="address"></c:url>
		<form:form role="form"  method="POST" action="address">
			<div class="form-group">
				<label for="usr">card number</label> <input type="number"
					class="form-control" id="usr">
			</div>
			<div class="form-group">
				<label for="usr">Card Name</label> <input type="text"
					class="form-control" id="usr">
			</div>
			<div class="form-group">
				<label for="usr">Valid Thru</label> <input type="date"
					class="form-control" id="usr">
			</div>
			<div class="form-group">
				<label for="usr">cvc number</label> <input type="number"
					class="form-control" id="usr">
			</div>
			<input type="submit" class="btn btn-primary" value="step 2"/>
		</form:form>
	</div>
</body>
</html>