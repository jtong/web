angular.module('userManagement')
    .controller('AccountsNewController', function ($scope, $resource, $location) {
        var Account = $resource("/web/api/v1/accounts/");
        $scope.account = {};
        $scope.create = function(){
            var localAccount = new Account($scope.account);
            localAccount.$save().then(function(result){
                $location.path("/account");
            });

        }
    });