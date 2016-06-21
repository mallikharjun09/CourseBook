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
    <div class="container" ng-app="imgApp" ng-controller="imgCtrl">
    <jsp:include page="header.jsp"/>
   <c:url var="addBook" value="addBook"></c:url>
   <form:form commandName="book" method="post" action="storeBook" enctype="multipart/form-data">
       <table class="table table-bordered" >
           <tr><td><form:label path="name">Book Name :</form:label></td>
               <td><form:input path="name"/></td>
           </tr>
           <tr><td><form:label path="description">Discription :</form:label></td>
               <td><form:input path="description"/></td>
           </tr>
           <tr><td><form:label path="proLang">Subject :</form:label></td>
               <td><form:input path="proLang"/></td>
           </tr>
           <tr><td><form:label path="author">Author Name :</form:label></td>
               <td><form:input path="author"/></td>
           </tr>
           <tr><td><form:label path="cost">Book Cost :</form:label></td>
               <td><form:input path="cost"/></td>
           </tr>
           <tr><td><form:label path="img">Book Cost :</form:label></td>
               <td><form:input path="img" type="file"/></td>
               
           </tr>
           <tr><td></td>
               <td><input type="submit" value="Update Image" class="btn"/></td>
           </tr>
           
       </table>
   </form:form> 
   
</body>
</html>