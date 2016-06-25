<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

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
           <font color="red">
           <span>${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}</span>
           </font>
           <form action="j_spring_security_chain" method="post">
               <tr>
                   <td>User name :</td><td><input type="text" name="j_username"/></td>
               </tr>
               <tr><td>Password  :</td><td><input type="password" name="j_password"/></td></tr>
               <tr><td><input type="submit" value="Login"/></td></tr>
           </form>
	    </div>	
    </div>
</body>
</html>