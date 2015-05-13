'use strict';

/**
 * @ngdoc function
 * @name partyBidApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the partyBidApp
 */
angular.module('userManagement')
    .controller('AccountsController', function ($scope, $location, $resource,$http) {

        var Account = $resource("/web/api/v1/accounts/:accountId");
        $scope.accounts = Account.query();

        $scope.deleteAccount = function(accountId){
            Account.delete({accountId:accountId}, function(){
                clear_account_in_scope(accountId);
            });
        };

        $scope.update = function(accountId){
            $location.path("/account/edit/"+accountId );
        };
        
        $scope.delete_all_selected_accounts = function(){
            var selected_accounts = _.chain($scope.accounts).where({selected:true}).pluck('id').value();
            $http.delete("/web/api/v1/accounts/:batch", {
                data:selected_accounts,
                headers:{'Content-Type':'application/json'}
            }).success(function(){
                _(selected_accounts).each(function(accountId){
                    clear_account_in_scope(accountId);
                });
            });
        };

        function clear_account_in_scope(accountId){
            $scope.accounts =_($scope.accounts).reject(function(account){
                return account.id == accountId;
            });
        };

        $scope.selectedAll = false;

        $scope.select_all_or_select_none = function(){
            if ($scope.selectedAll) {
                $scope.selectedAll = true;
            } else {
                $scope.selectedAll = false;
            }
            _($scope.accounts).each(function (account) {
                account.selected = $scope.selectedAll;
            });
        }

        $scope.go_to_create_account = function(){
            $location.path("/account/new");
        }

    });