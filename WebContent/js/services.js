'use strict';

/* Services */
//user the resource
var demoServices = angular.module('demoServices', ['ngResource']);

demoServices.factory('iniData', ['$resource',function($resource){
    return $resource('json/:test.json', {"test":"ini"}, {
      query: {method:'GET', params:{}, isArray:true}
    });
  }]);



demoServices.factory('taskSourceService', ['$resource',function ($resource) {
	var urlBase="/Angularjs_RestfulService/service";

	
 var listTask=function get(taskName){

   return $resource(urlBase+"/:test", {"test":taskName}, {
      query: {method:'GET', params:{}, isArray:true}
    });

 };


 var createTask=function create(time,type,activity,address){
     var taskName=urlBase+'/tasks/create/';
     console.log(""+taskName+"/"+time+"/"+type+"/"+activity+"/"+address);
 	  return $resource(taskName+"/"+time+"/"+type+"/"+activity+"/"+address,
 	   {}, {
      save: {method:'post',params:{}, isArray:true}
    });


 };


	return {
    get:listTask,
    post:createTask
	};
  	
}])





//user the $http 

demoServices.factory('iniData2', ["$http","$q",function ($http,$q) {
	

	return {

		query:function(){

			var defer=$q.defer();
			$http.get("json/ini.json",{
                cache:true
			}).success(function(data){
				defer.resolve(data);
			}).error(function(errmsg){
				defer.reject(errmsg)
			});

			return defer.promise;


			
		}

	};
}]);

