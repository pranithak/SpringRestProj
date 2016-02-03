'use strict';

var myApp = angular.module('myApp', []);
myApp.controller('CustomerController', ['$scope', '$http',
        function($scope, $http) {
        	$http({
        			method : 'GET',
        			url : 'http://localhost:8080/SpringRest/customers/'
        		}).success(function(data, status, headers, config) {
        			$scope.customers = data;
        		}).error(function(data, status, headers, config) {
        			alert( "failure");
        		});

        }]);