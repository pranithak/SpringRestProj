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
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
      <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    </head>

    <body>
    <nav class="navbar navbar-inverse">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Logo</a>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
          <ul class="nav navbar-nav">
            <li><a href="home">Home</a></li>
            <li class="active"><a href="#">Customer Management</a></li>
          </ul>
          <ul class="nav navbar-nav navbar-right">
            <li><a href="login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
          </ul>
        </div>
      </div>
    </nav>
          <div class="container-fluid" ng-controller="CustomerCntrl">
          <div ng-if = "isDeleted">
                   <p class="bg-success">Customer - {{message}}</p>

                  </div>
              <h1>Customer List</h1>
              <hr>
                 <label>Name:</label>
                  <input type="text" ng-model="yourName" placeholder="Enter a name here"><br/><br/>
            <label>Id:</label>
            <input type="text" ng-model="custId" ng-enter = "getCustomer(custId)" ><br/>
                <a href = "" data-toggle="modal" data-target="#myAddModal" ng-click = "getCustomer(customer.id)" >Add Customer</a></td>



               <table class="table">
                   <thead>
                     <tr>
                       <th>id</th>
                       <th>name</th>
                       <th>actions</th>

                     </tr>
                   </thead>
                   <tbody>

                     <tr ng-repeat="customer in customers | orderBy:'id' | filter:yourName">
                       <td>{{customer.id}}</td>
                       <td><a href = "" data-toggle="modal" data-target="#myDisplayModal"ng-click = "getCustomer(customer.id)">{{customer.name}}</a></td>
                        <td><a href = "" data-toggle="modal" data-target="#myModal" ng-click = "getCustomer(customer.id)">edit</a> |
                        <a href = "" data-toggle="modal" data-target="#myDeleteModal" ng-click = "getCustomer(customer.id)" >delete</a></td>
                     </tr>

                   </tbody>
                 </table>

                <div class="modal fade" id="myDisplayModal" role="dialog">
                <div class="modal-dialog">

                  <!-- Modal content-->
                  <div class="modal-content">
                    <div class="modal-header">
                      <button type="button" class="close" data-dismiss="modal">&times;</button>
                      <h4 class="modal-title">Display Customer</h4>
                    </div>
                    <div class="modal-body">

                <div ng-if = "customerDetails">
                <h1>Customer Details - {{customerDetails.name}}</h1>
                <h4> Id : {{customerDetails.id}}</h4>
                <h4> Name : {{customerDetails.name}}</h4>
                <h4> Age : {{customerDetails.age}}</h4>
                <h4> Salary : {{customerDetails.salary}}</h4>


              </div>
                    </div>

                  </div>

                </div>

            </div>




            <div class="modal fade" id="myModal" role="dialog">
                <div class="modal-dialog">

                  <!-- Modal content-->
                  <div class="modal-content">
                    <div class="modal-header">
                      <button type="button" class="close" data-dismiss="modal">&times;</button>
                      <h4 class="modal-title">Edit Customer</h4>
                    </div>
                    <div class="modal-body">
                     Name: <input type="text" ng-model="customerDetails.name" ><br/><br/>
                     Age: <input type="text" ng-model="customerDetails.age" ><br/><br/>
                     Salary : <input type="text" ng-model="customerDetails.salary" ><br/><br/>
                     <button type = "button" class="btn btn-default" data-dismiss="modal" ng-click = "updateCustomer(customerDetails)">save</button>
                     <button type = "button" class="btn btn-default" data-dismiss="modal">cancel</button>

                    </div>

                  </div>

                </div>

            </div>

       <div class="modal fade" id="myDeleteModal" role="dialog">
                <div class="modal-dialog">

                  <!-- Modal content-->
                  <div class="modal-content">
                    <div class="modal-header">
                      <button type="button" class="close" data-dismiss="modal">&times;</button>
                      <h4 class="modal-title">Delete Customer</h4>
                    </div>
                    <div class="modal-body">
                     <p> Are you sure you want to delete <b>{{customerDetails.name}}</b></p>
                     <button type = "button" class="btn btn-default" data-dismiss="modal" ng-click = "deleteCustomer(customerDetails.id,customerDetails.name)">Yes</button>

                     <button type = "button" class="btn btn-default" data-dismiss="modal">Cancel</button>

                    </div>

                  </div>

                </div>

       </div>
       <div class="modal fade" id="myAddModal" role="dialog">
                 <div class="modal-dialog">

                         <!-- Modal content-->
                         <div class="modal-content">
                           <div class="modal-header">
                             <button type="button" class="close" data-dismiss="modal">&times;</button>
                             <h4 class="modal-title">Add Customer</h4>
                           </div>
                           <div class="modal-body">
                                 Name: <input type="text" ng-model="customerDetails.name" ><br/><br/>
                                 Age: <input type="text" ng-model="customerDetails.age"  ><br/><br/>
                                 Salary : <input type="text" ng-model="customerDetails.salary" ><br/><br/>
                                 <button type = "button" class="btn btn-default" data-dismiss="modal" ng-click = "addCustomer(customerDetails)">save</button>
                                 <button type = "button" class="btn btn-default" data-dismiss="modal">cancel</button>
                           </div>

                         </div>

                 </div>


       </div>

    </div>
         <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.9/angular.min.js"></script>
         <script src="<c:url value='/static/js/app.js' />"></script>
         <script src="<c:url value='/static/js/controller/customer_controller.js' />"></script>
         <script src="<c:url value='/static/js/factory/customer_factory.js' />"></script>
         <script src="<c:url value='/static/js/directive/cust_components.js' />"></script>
      </body>

</html>