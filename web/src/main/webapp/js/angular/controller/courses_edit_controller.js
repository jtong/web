angular.module('userManagement')
    .controller('CoursesEditController', function ($scope, $resource, $location, $routeParams) {
        var Course = $resource("/web/api/v1/courses/:id", null, {
            update: {method: "PUT"},
            get:    {method:'GET'}
        });
        $scope.course = Course.get({id: $routeParams.id});
        
        $scope.do_submit = function(){
            Course.update({id: $scope.course.id},$scope.course)
                .$promise.then(function(course) {
                $location.path("/course");
            });

        }
    });