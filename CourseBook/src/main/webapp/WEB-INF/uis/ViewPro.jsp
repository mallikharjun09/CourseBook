<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="x" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
     <link rel="stylesheet" href='<x:url value="/resources/css/bootstrap.min.css"></x:url>' />
  <script src='<x:url value="/resources/js/jquery.min.js"></x:url>'></script>
  <script src='<x:url value="/resources/js/bootstrap.min.js"></x:url>'></script>
  <script src='<x:url value="/resources/js/angular.min.js"></x:url>'></script>
   
</head>
   <body>
      <div class="container">
            <jsp:include page="header.jsp"/>
            <table class="table table-hover table-bordered">
            <tr><td rowspan="5">
            <img src='<x:url value="/resources/images/${book.image}"/>'/></td></tr>
            <tr><td>${book.name}</td></tr>
            <tr><td>${book.description}</td></tr>
            <tr><td>${book.proLang }</td></tr>
            <tr><td>${book.cost}</td></tr>
            <tr><td></td><td><a href="" class="btn btn-info">Add Cart</a>
            </table>
      </div>
   </body>
</html>