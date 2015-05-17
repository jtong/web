'use strict';
function translate_account_to_period_data(accounts,type) {
    var input_grouped_object = _.chain(accounts).filter(function (account) {
        return account.type == type
    }).groupBy(function (account) {
        return new Date(account.paidTime).getMonth()
    });
    var input_grouped_object_value = input_grouped_object.value();
    if (input_grouped_object.keys().value().length < 12) {
        var count = 0;
        while (count < 12) {
            if (!input_grouped_object_value[count]) {
                input_grouped_object_value[count] = [{price: 0}]
            }
            count++;
        }
    }

    return _.chain(input_grouped_object_value).pairs()
        .sort(function (item) {
            return item[0];

        }).map(function (item) {
            return _(item[1]).reduce(function (memo, account) {
                return memo + account.price;
            }, 0)

        }).value()
}
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

        $scope.delete = function(accountId){
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
            //console.log($scope.accounts);

        $scope.analyse = function(){
            $location.path("/account/analyse");
        }
        
        $scope.query_string = "";

        $scope.search = function(){
            $http.get("/web/api/v1/accounts/search",{ params: {keyword: $scope.query_string}}).success(function(data){

                $scope.accounts = data;
            })

        }
    });

