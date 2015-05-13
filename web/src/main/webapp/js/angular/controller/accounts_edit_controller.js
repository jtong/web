angular.module('userManagement')
    .controller('AccountsEditController', function ($scope, $resource, $location, $routeParams) {
        var Account = $resource("/web/api/v1/accounts/:id", null, {
            update: {method: "PUT"},
            get:    {method:'GET'}
        });
        $scope.account = Account.get({id: $routeParams.id});
        
        $scope.do_submit = function(){
            Account.update({id: $scope.account.id},$scope.account)
                .$promise.then(function(account) {
                $location.path("/account");
            });

        }
    });