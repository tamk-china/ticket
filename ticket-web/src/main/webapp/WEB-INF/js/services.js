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
}).factory('req', function(){
	var reqService = {};

	reqService.get = function(url, param, callback){
		$http({
			method: 'GET',
			url: url,
			params: param,
			responseType: 'application/json'
		}).success(cb);
	};

	reqService.post = function(url, param, callback){
		$http({
			method: 'POST',
			url: url,
			params: param,
			responseType: 'application/json'
		}).success(cb);
	};

	return reqService;
});