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
    .controller('AccountsAnalyseController', function ($scope, $location, $resource,$http) {


            //console.log($scope.accounts);
        $.get("/web/api/v1/accounts/").then(function(accounts) {
            //accounts = $scope.accounts;
            var input = translate_account_to_period_data(accounts,"INCOME");
            var output = translate_account_to_period_data(accounts,"OUTPUT");
            var data = {
                labels: ["Jan", "Feb", "Mar", "Apr", "May", "Jul", "Jun", "Aug", "Sep", "Oct", "Nov", "Dec"],
                datasets: [
                    {
                        label: "收入",
                        fillColor: "rgba(52, 255, 163, 0.2)",
                        strokeColor: "rgba(52, 255, 163, 1)",
                        pointColor: "rgba(52, 255, 163, 1)",
                        pointStrokeColor: "#fff",
                        pointHighlightFill: "#fff",
                        pointHighlightStroke: "rgba(52, 255, 163, 1)",
                        data: input
                    },
                    {
                        label: "支出",
                        fillColor: "rgba(250, 100, 100, 0.2)",
                        strokeColor: "rgba(250, 100, 100, 1)",
                        pointColor: "rgba(250, 100, 100, 1)",
                        pointStrokeColor: "#fff",
                        pointHighlightFill: "#fff",
                        pointHighlightStroke: "rgba(250, 100, 100, 1)",
                        data: output
                    }
                ]
            };
            var ctx = document.getElementById("accountChart").getContext("2d");
            console.log(ctx.font);
            var myNewChart = new Chart(ctx).Line(data);
        });


    });

