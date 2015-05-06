angular.module('userManagement')
    .controller('CustomersNewController', function ($scope, $resource, $location) {
        var Customer = $resource("/web/api/v1/customers/");
        $scope.customer = {};
        $scope.create = function(){
            var localCustomer = new Customer($scope.customer);
            localCustomer.$save().then(function(result){
                $location.path("/customer");
            });

        }
    });