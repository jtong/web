angular.module('userManagement')
    .controller('CoursesNewController', function ($scope, $resource, $location) {
        var Course = $resource("/web/api/v1/courses/");
        $scope.course = {};
        $scope.create = function(){
            var localCourse = new Course($scope.course);
            localCourse.$save().then(function(result){
                $location.path("/course");
            });

        }
    });