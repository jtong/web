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
            .when('/', {
                templateUrl: 'views/user/list.html',
                controller: 'UsersController'
            })
            .when('/new', {
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
            
            .otherwise({
                redirectTo: '/'
            });
    });
