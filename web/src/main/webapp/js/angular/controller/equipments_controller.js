'use strict';

/**
 * @ngdoc function
 * @name partyBidApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the partyBidApp
 */
angular.module('userManagement')
    .controller('EquipmentsController', function ($scope, $location, $resource,$http) {

        var Equipment = $resource("/web/api/v1/equipments/:equipmentId");
        $scope.equipments = Equipment.query();

        $scope.deleteEquipment = function(equipmentId){
            Equipment.delete({equipmentId:equipmentId}, function(){
                clear_equipment_in_scope(equipmentId);
            });
        };

        $scope.delete_all_selected_equipments = function(){
            var selected_equipments = _.chain($scope.equipments).where({selected:true}).pluck('id').value();
            $http.delete("/web/api/v1/equipments/:batch", {
                data:selected_equipments,
                headers:{'Content-Type':'application/json'}
            }).success(function(){
                _(selected_equipments).each(function(equipmentId){
                    clear_equipment_in_scope(equipmentId);
                });
            });
        };

        function clear_equipment_in_scope(equipmentId){
            $scope.equipments =_($scope.equipments).reject(function(equipment){
                return equipment.id == equipmentId;
            });
        };

        $scope.selectedAll = false;

        $scope.select_all_or_select_none = function(){
            if ($scope.selectedAll) {
                $scope.selectedAll = true;
            } else {
                $scope.selectedAll = false;
            }
            _($scope.equipments).each(function (equipment) {
                equipment.selected = $scope.selectedAll;
            });
        }

        $scope.go_to_create_equipment = function(){
            $location.path("/equipment/new");
        }

    });