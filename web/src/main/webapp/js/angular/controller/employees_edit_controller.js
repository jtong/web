angular.module('userManagement')
    .controller('EmployeesEditController', function ($scope, $resource, $location, $routeParams) {
        var Employee = $resource("/web/api/v1/employees/:id", null, {
            update: {method: "PUT"},
            get:    {method:'GET'}
        });

        $scope.employee = Employee.get({id: $routeParams.id});
        
        $scope.do_submit = function(){
            Employee.update({id: $scope.employee.id},$scope.employee)
                .$promise.then(function(employee) {
                    $location.path("/employee");
                });

        }
    });