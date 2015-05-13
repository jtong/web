'use strict';

/**
 * @ngdoc function
 * @name partyBidApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the partyBidApp
 */
angular.module('userManagement')
    .controller('EmployeesController', function ($scope, $location, $resource,$http) {

        var Employee = $resource("/web/api/v1/employees/:employeeId");
        $scope.employees = Employee.query();

        $scope.delete = function(employeeId){
            Employee.delete({employeeId:employeeId}, function(){
                clear_employee_in_scope(employeeId);
            });
        };

        $scope.update = function(employeeId){
            $location.path("/employee/edit/"+employeeId);
        };

        $scope.delete_all_selected_employees = function(){
            var selected_employees = _.chain($scope.employees).where({selected:true}).pluck('id').value();
            $http.delete("/web/api/v1/employees/:batch", {
                data:selected_employees,
                headers:{'Content-Type':'application/json'}
            }).success(function(){
                _(selected_employees).each(function(employeeId){
                    clear_employee_in_scope(employeeId);
                });
            });
        };

        function clear_employee_in_scope(employeeId){
            $scope.employees =_($scope.employees).reject(function(employee){
                return employee.id == employeeId;
            });
        };

        $scope.selectedAll = false;

        $scope.select_all_or_select_none = function(){
            if ($scope.selectedAll) {
                $scope.selectedAll = true;
            } else {
                $scope.selectedAll = false;
            }
            _($scope.employees).each(function (employee) {
                employee.selected = $scope.selectedAll;
            });
        }

        $scope.go_to_create_employee = function(){
            $location.path("/employee/new");
        }

    });