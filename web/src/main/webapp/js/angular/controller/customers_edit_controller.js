angular.module('userManagement')
    .controller('CustomersEditController', function ($scope, $resource, $location, $routeParams) {
        var Customer = $resource("/web/api/v1/customers/:id", null, {
            update: {method: "PUT"},
            get:    {method:'GET'}
        });
        $scope.customer = Customer.get({id: $routeParams.id});
        
        $scope.do_submit = function(){
            Customer.update({id: $scope.customer.id},$scope.customer)
                .$promise.then(function(customer) {
                $location.path("/customer");
            });

        }
    });