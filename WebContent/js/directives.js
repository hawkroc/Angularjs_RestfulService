
'use strict';

/* Directives */

var demoDirectives = angular.module('demoDirectives', []);

demoDirectives.directive('calendarDir', [function () {
	return {
		
		require: '^ngModel',
		restrict: 'AE',
		scope: {},

		link: function (scope, iElement, iAttrs,ngModel) {
			  if(!ngModel) return;  
			$(iElement).datetimepicker({
				
                onSelectDate: function (date) {
                	var time = date.dateFormat('d-m-Y :h');
                    scope.$apply(function(){             
                    	ngModel.$setViewValue(time);

                    });
                }
            });
	

		}
	};
}])


demoDirectives.directive('mapDir', [function () {
	return {
	
		templateUrl: 'partials/Mapdirective.html',
		replace: true,
		require: '^ngModel',
		restrict: 'AE',
		scope: {},
		link: function (scope, iElement, iAttrs,ngModel) {

          if(!ngModel) return;  
        //  alert(scope.content);
  var myLatlng = new google.maps.LatLng(-36.855938, 174.762127);
  var mapOptions = {
    zoom: 12,
    center: myLatlng
  };

  var map = new google.maps.Map(document.getElementById(iAttrs.id), mapOptions);

  var marker = new google.maps.Marker({
      position: myLatlng,
      map: map,
      draggable: true,
      title: 'please add your address'
  });
  


 google.maps.event.addListener(marker,"dragend",function(){
   var custPoint = marker.getPosition(); 
        console.log(""+custPoint);
         scope.$apply(function(){             
                    	ngModel.$setViewValue(custPoint);

                    });
        
        }); 

		}
	};
}]);


demoDirectives.directive('staticMapDir', [function () {
	return {
		restrict: 'AE',
		link: function (scope, iElement, iAttrs) {
              console.log("address   "+scope.address);
             var myLatlng = new google.maps.LatLng(-36.855938, 174.762127);
			 var mapOptions = {
                 zoom: 20,
                 center: myLatlng,
                  mapTypeId: google.maps.MapTypeId.ROADMAP
                 };

              var map = new google.maps.Map(iElement,mapOptions);
			
              var marker = new google.maps.Marker({
                 position: myLatlng,
                 map: map,
                 draggable: false,
                 title: ' activity  address'
                });



		}
	};
}])
