var serviceModule = angular.module('serviceModule',[]);

serviceModule.factory('tipService', function(){
	var tipService = {};
	
	tipService.alert = function(tip){
		alert(tip);
	};

	tipService.confirm = function(tip){
		return confirm(tip)
	};

	return tipService;
});