<!doctype html>
<html class="no-js" ng-app="userManagement">
<head>
  <meta charset="utf-8">
  <title></title>
  <meta name="description" content="">
  <meta name="viewport" content="width=device-width">

  <link rel="stylesheet" href="lib/css/bootstrap.min.css" />

  <script src="lib/js/jquery-1.11.1.min.js"></script>
  <script src="lib/js/bootstrap.min.js"></script>
  <script src="lib/js/underscore.min.js"></script>
  <script src="lib/js/angular/angular.js"></script>
  <script src="lib/js/angular/angular-resource.min.js"></script>
  <script src="lib/js/angular/angular-route.min.js"></script>
  <script src="lib/js/angular/checklist-model.js"></script>

  <script src="js/angular/app.js"></script>
  <script src="js/angular/controller/users_controller.js"></script>
  <script src="js/angular/controller/users_new_controller.js"></script>
  <script src="js/angular/controller/employees_controller.js"></script>
  <script src="js/angular/controller/employees_edit_controller.js"></script>
  <script src="js/angular/controller/employees_new_controller.js"></script>
  <script src="js/angular/controller/accounts_controller.js"></script>
  <script src="js/angular/controller/accounts_new_controller.js"></script>
  <script src="js/angular/controller/equipments_controller.js"></script>
  <script src="js/angular/controller/equipments_new_controller.js"></script>
  <script src="js/angular/controller/customers_controller.js"></script>
  <script src="js/angular/controller/customers_new_controller.js"></script>

</head>
<body ng-controller="MainCtrl">

<div ng-view=""></div>


</body>
</html>
