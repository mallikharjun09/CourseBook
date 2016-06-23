<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
  <link rel="stylesheet" href='<c:url value="/resources/css/bootstrap.min.css"></c:url>' />
  <script src='<c:url value="/resources/js/jquery.min.js"></c:url>'></script>
  <script src='<c:url value="/resources/js/bootstrap.min.js"></c:url>'></script>
</head>
<body>
    <div class="container">
        <jsp:include page="header.jsp"/>
        <div class="container">
	    	<div class="row">
    	    	<div class="col-sm-6 col-md-4 col-md-offset-4">
            		<h1 class="text-center login-title">Sign in to continue</h1>
            		<div class="account-wall">
                    <form class="form-signin form-signin-bordered" method="post" action='<c:url value='j_spring_security_check'></c:url>' >
                    <tr><td colspan="2" style="color:red">${msg}</td></tr>
                    <tr><td>
                	<input type="text" class="form-control" placeholder="Email-ID" name="user" required autofocus></td></tr>
                	<tr><td>
                	<input type="password" class="form-control" placeholder="Password" name="password" required >
                	<button class="btn btn-lg btn-primary btn-block" type="submit">
                    Sign in</button>
                	<label class="checkbox pull-right">
                    </label>
                	<span class="clearfix"></span>
                </form>
            </div>
            <p align="center"><a href="register" >Create an account </a></p>
        </div>
    </div>
</div>
</div>
</body>
</html>