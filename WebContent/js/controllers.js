'use strict';

/* Controllers */

var demoControllers = angular.module('demoControllers', ['ui.bootstrap']);

demoControllers.controller('ModalDemoCtrl', function($scope, $modal, $log, iniData, taskSourceService) {
  $scope.url = "tasks";
  $scope.items = ['work', 'social contact', 'study', 'recreation'];
  //$scope.contents=iniData.query();
  $scope.contents = taskSourceService.get($scope.url).query();


  $scope.del = function(content) {
    var index = $scope.contents.indexOf(content);
    $scope.contents.splice(index, 1);
  };
  $scope.openMap = function(size) {
    var modalInstance = $modal.open({
      templateUrl: 'partials/StaticMap.html',
      size: size

    });
  }
  $scope.open = function(size) {

    var modalInstance = $modal.open({
      templateUrl: 'partials/ModalContent.html',
      controller: 'ModalInstanceCtrl',
      size: size,
      resolve: {
        items: function() {
          return $scope.items;
        }
      }
    });


    modalInstance.result.then(function(content) {
      // $scope.selected = selectedItem;
      $scope.contents.push(content);
       
       var time=content.time;
       console.log("wwww"+ time);
      taskSourceService.post(  time,
        content.type,
        content.activity,
        content.address).save();

    }, function() {
 

    });
  };
});



demoControllers.controller('ModalInstanceCtrl', function($scope, $modalInstance, items, taskSourceService) {

  $scope.items = items;
  $scope.content = {
    "time": "",
    "type": "",
    "activity": "",
    "address": ""
  };

  $scope.ok = function() {
    $modalInstance.close($scope.content);
  };

  $scope.cancel = function() {
    $modalInstance.dismiss('cancel');
  };
});