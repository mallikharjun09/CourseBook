<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
  <link rel="stylesheet" href='<c:url value="/resources/css/bootstrap.min.css"></c:url>' />
  <script src='<c:url value="/resources/js/jquery.min.js"></c:url>'></script>
  <script src='<c:url value="/resources/js/bootstrap.min.js"></c:url>'></script>
  <script src='<c:url value="/resources/js/angular.min.js"></c:url>'></script>
</head>
<body>
    
    <jsp:include page="header.jsp"/>
   <c:url var="addUser" value="addUser"></c:url>
   <form:form commandName="user" method="post" action="storeUser">
       <table class="table table-bordered" >
           <tr><td><form:label path="name">User Name :</form:label></td>
               <td><form:input path="name"/></td>
           </tr>
           <tr><td><form:label path="mail">Email ID :</form:label></td>
               <td><form:input path="mail"/></td>
           </tr>
           <tr><td><form:label path="phone">Phone Number :</form:label></td>
               <td><form:input path="phone"/></td>
           </tr>
           <tr><td><form:label path="password">Password :</form:label></td>
               <td><form:password path="password"/></td>
               <form:hidden path="role" value="User"/>
           </tr>
           <tr><td></td>
               <td><input type="submit" value="Register" class="btn"/></td>
           </tr>
           
       </table>
   </form:form> 
   
</body>
</html>