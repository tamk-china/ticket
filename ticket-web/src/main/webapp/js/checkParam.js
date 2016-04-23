var checkParam = angular.module('checkParam', []);

checkParam.directive('checkInt', function(){
	return {
		restrict: 'A',
		require: 'ngModel',
		link: function(scope, element, attrs, controller){
			var reg = /^\d*$/;
			scope.$watch(attrs.ngModel, function(val){
				if(!val || isNaN(val) || !val.match(reg)){
					element[0].style.borderColor = 'red';
				}else{
					element[0].style.borderColor = '';
				}
			});
		},
	};
}).directive('checkStrMax', function(){
	return {
		restrict: 'A',
		require: 'ngModel',
		link: function(scope, element, attrs, controller){
			scope.$watch(attrs.ngModel, function(val){
				if(!!val && val.length > attrs.checkStrMax){
					element[0].style.borderColor = 'red';
				}
			});
		},
	};
});