customerApp.factory('myAppFactory',function($http){
    var myAppFactory = {};
    myAppFactory.getAllCustomers = function(){
        return $http({method:'GET', url : 'http://localhost:8080/SpringRest/customers/' })
        .then(function(response){
            return response.data;
        });
    };

     myAppFactory.getCustomerById = function(id){
            return $http({method:'GET', url : 'http://localhost:8080/SpringRest/customers/' + id })
            .then(function(response){
                return response.data;
            });
        };

        myAppFactory.deleteCustomerById = function(id){
            return $http({method:'DELETE', url : 'http://localhost:8080/SpringRest/customers/' + id })
            .then(function(response){
                return response.data;
            });
        };
        myAppFactory.updateCustomer = function(customer){
            return $http({method:'PUT', url : 'http://localhost:8080/SpringRest/customers/' +customer.id, data: customer })
            .then(function(response){
                return response.data;
            });
        };
        myAppFactory.addCustomer = function(customer){
            return $http({method:'POST', url : 'http://localhost:8080/SpringRest/customers/', data: customer })
            .then(function(response){
                return response.data;
            });
        };

    return myAppFactory;
});