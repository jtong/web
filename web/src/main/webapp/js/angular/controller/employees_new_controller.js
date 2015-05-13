angular.module('userManagement')
    .controller('EmployeesNewController', function ($scope, $resource, $location) {
        var User = $resource("/web/api/v1/employees/");
        $scope.employee = {};
        $scope.do_submit = function(){
            var localUser = new User($scope.employee);
            localUser.$save().then(function(result){
                $location.path("/employee");
            });

        }
    });