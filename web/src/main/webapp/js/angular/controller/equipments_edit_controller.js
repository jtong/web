angular.module('userManagement')
    .controller('EquipmentsEditController', function ($scope, $resource, $location, $routeParams) {
        var Equipment = $resource("/web/api/v1/equipments/:id", null, {
            update: {method: "PUT"},
            get:    {method:'GET'}
        });
        $scope.equipment = Equipment.get({id: $routeParams.id});
        
        $scope.do_submit = function(){
            Equipment.update({id: $scope.equipment.id},$scope.equipment)
                .$promise.then(function(equipment) {
                $location.path("/equipment");
            });

        }
    });