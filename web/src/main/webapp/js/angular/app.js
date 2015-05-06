'use strict';

/**
 * @ngdoc overview
 * @name partyBidApp
 * @description
 * # partyBidApp
 *
 * Main module of the application.
 */
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
                controller: 'UsersController'
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
