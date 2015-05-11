'use strict';

/**
 * @ngdoc overview
 * @name partyBidApp
 * @description
 * # partyBidApp
 *
 * Main module of the application.
 */
var checkLoggedin = function ($q, $timeout, $http, $location, $rootScope) {
    // Initialize a new promise
    var deferred = $q.defer();
    // Make an AJAX call to check if the user is logged in
    $http.get('/loggedin').success(function (user) {
        // Authenticated
        if (user !== '0') {
            deferred.resolve();
        // Not Authenticated
        } else {
            $rootScope.message = 'You need to log in.';
            deferred.reject();
            location.href="/web/";
        }
    });
    return deferred.promise;
};
angular
    .module('userManagement', [
        'ngResource',
        'ngRoute',
        'checklist-model'
    ])
    .config(function ($routeProvider) {
        $routeProvider
            .when('/user', {
                templateUrl: 'views/user/list.html',
                controller: 'UsersController',
                resolve: {
                    loggedin: checkLoggedin
                }
            })
            .when('/user/new', {
                templateUrl: 'views/user/new.html',
                controller: 'UsersNewController'
            })
            .when('/account', {
                templateUrl: 'views/account/list.html',
                controller: 'AccountsController'
            })
            .when('/account/new', {
                templateUrl: 'views/account/new.html',
                controller: 'AccountsNewController'
            })
            .when('/customer', {
                templateUrl: 'views/customer/list.html',
                controller: 'CustomersController'
            })
            .when('/customer/new', {
                templateUrl: 'views/customer/new.html',
                controller: 'CustomersNewController'
            })
            .when('/equipment', {
                templateUrl: 'views/equipment/list.html',
                controller: 'EquipmentsController'
            })
            .when('/equipment/new', {
                templateUrl: 'views/equipment/new.html',
                controller: 'EquipmentsNewController'
            })
            .when('/employee', {
                templateUrl: 'views/employee/list.html',
                controller: 'EmployeesController'
            })
            .when('/employee/new', {
                templateUrl: 'views/employee/new.html',
                controller: 'EmployeesNewController'
            })
            .otherwise({
                redirectTo: '/user'
            });
    });
