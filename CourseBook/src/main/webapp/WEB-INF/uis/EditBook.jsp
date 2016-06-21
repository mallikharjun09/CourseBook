<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:url var="addBook" value="saveBook"/>
  <form:form id="addBook" modelAttribute="book" method="post" action="update?id=${book.id}">
      <tr><td><form:label path="name">Book Name :</form:label></td>
               <td><form:input path="name" value="${book.name}"/></td>
           </tr>
           <tr><td><form:label path="description">Discription :</form:label></td>
               <td><form:input path="description" value="${book.description}"/></td>
           </tr>
           <tr><td><form:label path="proLang">Subject :</form:label></td>
               <td><form:input path="proLang" value="${book.proLang}"/></td>
           </tr>
           <tr><td><form:label path="author">Author Name :</form:label></td>
               <td><form:input path="author" value="${book.author}"/></td>
           </tr>
           <tr><td><form:label path="cost">Book Cost :</form:label></td>
               <td><form:input path="cost" value="${book.cost}"/></td>
           </tr>
           <tr><td></td>
               <td><input type="submit" value="Update Book"/></td>
           </tr>
           
 
  </form:form>   
</body>
</html>