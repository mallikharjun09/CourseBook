<%@taglib prefix="x" uri="http://java.sun.com/jsp/jstl/core"%>
    <div class="carousel slide" data-ride="carousel">
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
    <li data-target="#myCarousel" data-slide-to="1"></li>
    <li data-target="#myCarousel" data-slide-to="2"></li>
    <li data-target="#myCarousel" data-slide-to="3"></li>
  </ol>

  <!-- Wrapper for slides -->
  <div class="carousel-inner" role="listbox" align="center">
    <div class="item active">
      <img src="<x:url value="/resources/images/C.jpg"/>" alt="C" style="width:70%;height:50%"/>
    </div>
    <div class="item">
      <img src='<x:url value="/resources/images/java.jpg"/>' alt="Java" style="width:70%;height:50%"/>
    </div>

    <div class="item">
      <img src='<x:url value="/resources/images/advjava.jpg"/>' alt="Advanced java" style="width:70%;height:50%"/>
    </div>
    
    <div class="item">
      <img src='<x:url value="/resources/images/SQL.jpg"/>' alt="SQL"style="width:70%;height:50%"/>
    </div>
    
    <div class="item">
      <img src='<x:url value="/resources/images/PLSQL.jpg"/>' alt="PLSQL"style="width:70%;height:50%"/>
    </div>
  </div>

  <!-- Left and right controls -->
  <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>
