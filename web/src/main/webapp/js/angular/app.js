'use strict';

/**
 * @ngdoc overview
 * @name partyBidApp
 * @description
 * # partyBidApp
 *
 * Main module of the application.
 */
function checkLogin(){
    $(document).ready(function(){
        $.get("/web/logedin").then(function(user){
            if(user == ''||!user){
                location.href= "/web/"
            }else{
                localStorage.setItem("user", JSON.stringify(user));
            }
        })

    })
}
checkLogin();
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
            .when('/account/edit/:id', {
                templateUrl: 'views/account/new.html',
                controller: 'AccountsEditController'
            })
            .when('/course', {
                templateUrl: 'views/course/list.html',
                controller: 'CoursesController'
            })
            .when('/course/new', {
                templateUrl: 'views/course/new.html',
                controller: 'CoursesNewController'
            })
            .when('/course/edit/:id', {
                templateUrl: 'views/course/new.html',
                controller: 'CoursesEditController'
            })
            .when('/customer', {
                templateUrl: 'views/customer/list.html',
                controller: 'CustomersController'
            })
            .when('/customer/new', {
                templateUrl: 'views/customer/new.html',
                controller: 'CustomersNewController'
            })
            .when('/customer/edit/:id', {
                templateUrl: 'views/customer/new.html',
                controller: 'CustomersEditController'
            })
            .when('/equipment', {
                templateUrl: 'views/equipment/list.html',
                controller: 'EquipmentsController'
            })
            .when('/equipment/new', {
                templateUrl: 'views/equipment/new.html',
                controller: 'EquipmentsNewController'
            })
            .when('/equipment/edit/:id', {
                templateUrl: 'views/equipment/new.html',
                controller: 'EquipmentsEditController'
            })
            .when('/employee', {
                templateUrl: 'views/employee/list.html',
                controller: 'EmployeesController'
            })
            .when('/employee/new', {
                templateUrl: 'views/employee/new.html',
                controller: 'EmployeesNewController'
            })
            .when('/employee/edit/:id', {
                templateUrl: 'views/employee/new.html',
                controller: 'EmployeesEditController'
            })
            .otherwise({
                redirectTo: '/equipment'
            });
    });

angular
    .module('userManagement')
    .controller('MainCtrl', ['$scope', function($scope, myService) {

        $scope.currentUser = JSON.parse(localStorage.getItem("user"));
        
        $scope.logout = function(){
            $.get("/web/logout").then(function(user){
                location.href= "/web/"
            })
        }
    }]);