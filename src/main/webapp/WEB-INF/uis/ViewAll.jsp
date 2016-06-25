<%@taglib prefix="x" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
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

<div ng-app="myApp" ng-controller="customersCtrl">
<center>
<input type="text" name="search" ng-model="search" style="width:70%;height:5%;margin-top:3%;border-radius:3%;text-size:10%" placeholder="Search">

</input>
</center>
<table class="table table-hover table-bordered" style="margin-top:3%">
  <tr>
       <th>Name of the Book</th>
       <th>Author</th>
       <th>Subject</th>
       <th>Cost</th>
       <th>Options</th>
  </tr>
  <tr ng-repeat="x in names|filter:search">
    
      <td>{{x.name}}</td>
    <td>{{x.author}}</td>
    <td>{{x.proLang}}</td>
    <td>{{x.cost}}</td>
    <td><a href="viewPro?id={{x.id}}" class="btn btn-info">View</a><a href="editBook?id={{x.id}}" class="btn btn-info">Edit</a>  <a href="delete?id={{x.id}}" class="btn btn-info">Delete</a><class="form-control"></td>
  </tr>
</table>

</div>

<script>
var app = angular.module('myApp', []);
app.controller('customersCtrl', function($scope, $http) {
    $http.get("list")
    .then(function (response) {$scope.names = response.data;});
});
</script>
</div>
</body>
</html>

