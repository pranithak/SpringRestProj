<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html ng-app="myApp">
    <head>
        <title>Customer Management</title>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">
    </head>

    <body>
          <div class="container" ng-controller="CustomerController">
              <h1>Customer Management</h1>

               <table class="table">
                   <thead>
                     <tr>
                       <th>#</th>
                       <th>id</th>
                       <th>name</th>
                       <th>Age</th>
                       <th>Salary</th>
                     </tr>
                   </thead>
                   <tbody>

                     <tr ng-repeat="customer in customers">>
                       <td>test</td>
                       <td>{{customer.id}}</td>
                       <td>{{customer.name}}</td>
                       <td>{{customer.age}}</td>
                       <td>{{customer.salary}}</td>
                     </tr>

                   </tbody>
                 </table>

               <label>Name:</label>
               <input type="text" ng-model="yourName" placeholder="Enter a name here">
               <hr>
               <h1>Hello {{yourName}}!</h1>
          </div>
         <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.9/angular.min.js"></script>
         <script src="<c:url value='/static/js/app.js' />"></script>
         <script src="<c:url value='/static/js/controller/customer_controller.js' />"></script>
      </body>

</html>