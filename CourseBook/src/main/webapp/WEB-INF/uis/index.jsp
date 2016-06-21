<%@taglib prefix="x" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
  <link rel="stylesheet" href='<x:url value="/resources/css/bootstrap.min.css"></x:url>' />
  <script src='<x:url value="/resources/js/jquery.min.js"></x:url>'></script>
  <script src='<x:url value="/resources/js/bootstrap.min.js"></x:url>'></script>
</head>
<body>
    <div class="container">
        <jsp:include page="header.jsp"/>
        <jsp:include page="Courosel.jsp"/>
        <jsp:include page="Images.jsp"/>
        <a href="newbook">addNew</a>
       
    </div>
</body>
</html>
