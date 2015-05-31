angular.module('userManagement')
    .controller('EquipmentsNewController', function ($scope, $resource, $location) {
        var Equipment = $resource("/web/api/v1/equipments/");
        $scope.equipment = {};
        $scope.do_submit = function(){
            var localEquipment = new Equipment($scope.equipment);
            localEquipment.$save().then(function(result){
                $location.path("/equipment");
            });

        }
    });