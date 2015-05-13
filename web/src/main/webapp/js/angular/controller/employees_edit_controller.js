angular.module('userManagement')
    .controller('EmployeesEditController', function ($scope, $resource, $location, $routeParams) {
        var User = $resource("/web/api/v1/employees/:id", null, {
            update: {method: "PUT"},
            get:    {method:'GET'}
        });

        $scope.employee = User.get({id: $routeParams.id});
        
        $scope.do_submit = function(){
            console.log("PUT")
            var localUser = User.update({id: $scope.employee.id},$scope.employee)
                .$promise.then(function(employee) {
                    $location.path("/employee");
                });

        }
    });