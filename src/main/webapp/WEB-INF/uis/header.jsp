<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">CourseBook</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Home</a></li>
      <li><a href="ViewAll">View Books</a></li> 
      <li><a href="#">FeedBack</a></li>
      <li><a href="#">Careers</a></li>
      
      <li><a href="newbook">AddBook</a>
      
       <li><a href="<c:url value='login'/>">Login</a></li>
      <li><a href="logout"/>Logout</a></li>
    </ul>
  </div>
</nav>