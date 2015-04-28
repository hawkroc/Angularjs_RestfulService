'use strict';

/* App Module */

var demoApp = angular.module('phonecatApp', [
  'ngRoute',
  'demoAnimations',
  'demoDirectives',
  'demoControllers',
  'demoFilters',
  'demoServices'
]);

demoApp.config(['$routeProvider',
  function($routeProvider) {
    $routeProvider.
      when('/plan', {
        templateUrl: 'partials/Main.html',
        controller: 'ModalDemoCtrl'
      }).
      otherwise({
        redirectTo: '/plan'
      });
  }]);
