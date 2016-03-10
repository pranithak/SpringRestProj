'use strict';

//var myApp = angular.module('myApp', []);
//customerController.controller('CustomerController', ['$scope', '$http',
//        function($scope, $http) {
//        	$http({
//        			method : 'GET',
//        			url : 'http://localhost:8080/SpringRest/customers/'
//        		}).success(function(data, status, headers, config) {
//        			$scope.customers = data;
//        		}).error(function(data, status, headers, config) {
//        			alert( "failure");
//        		});
//
//        }]);

customerController.controller('CustomerCntrl',function ($scope, myAppFactory){

$scope.isDeleted = false;

	$scope.getEveryCustomer = function(){
		myAppFactory.getAllCustomers().then(function(response){
			$scope.customers = response;
		});
	};

	$scope.getEveryCustomer();

	$scope.getCustomer = function(id){
		myAppFactory.getCustomerById(id).then(function(response){
			$scope.customerDetails = response;
		})
	};

	$scope.deleteCustomer = function(id,name){
		myAppFactory.deleteCustomerById(id).then(function(response){
			$scope.message = name + "  deleted sucessfully ";
			$scope.isDeleted = true;
			$scope.getEveryCustomer();
		});
	};

	$scope.updateCustomer = function(customer){
			console.log(customer);
			myAppFactory.updateCustomer(customer).then(function(response){
				$scope.customerDetails = response;
				$scope.getEveryCustomer();
			});
		};

	$scope.addCustomer = function(customer){
    			myAppFactory.addCustomer(customer).then(function(response){
    				$scope.customerDetails = response;
    				$scope.getEveryCustomer();
    			});
    		};


});