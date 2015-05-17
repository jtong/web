'use strict';

/**
 * @ngdoc function
 * @name partyBidApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the partyBidApp
 */
angular.module('userManagement')
    .controller('CoursesController', function ($scope, $location, $resource,$http) {

        var Course = $resource("/web/api/v1/courses/:courseId");
        var Search = $
        $scope.courses = Course.query();

        $scope.delete = function(courseId){
            Course.delete({courseId:courseId}, function(){
                clear_course_in_scope(courseId);
            });
        };
        
        $scope.update = function(courseId){
            $location.path("/course/edit/"+courseId );
        };
        
        $scope.delete_all_selected_courses = function(){
            var selected_courses = _.chain($scope.courses).where({selected:true}).pluck('id').value();
            $http.delete("/web/api/v1/courses/:batch", {
                data:selected_courses,
                headers:{'Content-Type':'application/json'}
            }).success(function(){
                _(selected_courses).each(function(courseId){
                    clear_course_in_scope(courseId);
                });
            });
        };

        function clear_course_in_scope(courseId){
            $scope.courses =_($scope.courses).reject(function(course){
                return course.id == courseId;
            });
        };

        $scope.selectedAll = false;

        $scope.select_all_or_select_none = function(){
            if ($scope.selectedAll) {
                $scope.selectedAll = true;
            } else {
                $scope.selectedAll = false;
            }
            _($scope.courses).each(function (course) {
                course.selected = $scope.selectedAll;
            });
        }

        $scope.go_to_create_course = function(){
            $location.path("/course/new");
        }

        $scope.query_string = "";

        $scope.search = function(){
            $http.get("/web/api/v1/courses/search",{ params: {keyword: $scope.query_string}}).success(function(data){

                $scope.courses = data;
            })

        }
    });