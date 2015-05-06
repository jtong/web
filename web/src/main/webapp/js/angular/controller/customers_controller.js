'use strict';

/**
 * @ngdoc function
 * @name partyBidApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the partyBidApp
 */
angular.module('userManagement')
    .controller('CustomersController', function ($scope, $location, $resource,$http) {

        var Customer = $resource("/web/api/v1/customers/:customerId");
        $scope.customers = Customer.query();

        $scope.deleteCustomer = function(customerId){
            Customer.delete({customerId:customerId}, function(){
                clear_customer_in_scope(customerId);
            });
        };

        $scope.delete_all_selected_customers = function(){
            var selected_customers = _.chain($scope.customers).where({selected:true}).pluck('id').value();
            $http.delete("/web/api/v1/customers/:batch", {
                data:selected_customers,
                headers:{'Content-Type':'application/json'}
            }).success(function(){
                _(selected_customers).each(function(customerId){
                    clear_customer_in_scope(customerId);
                });
            });
        };

        function clear_customer_in_scope(customerId){
            $scope.customers =_($scope.customers).reject(function(customer){
                return customer.id == customerId;
            });
        };

        $scope.selectedAll = false;

        $scope.select_all_or_select_none = function(){
            if ($scope.selectedAll) {
                $scope.selectedAll = true;
            } else {
                $scope.selectedAll = false;
            }
            _($scope.customers).each(function (customer) {
                customer.selected = $scope.selectedAll;
            });
        }

        $scope.go_to_create_customer = function(){
            $location.path("/new");
        }

    });