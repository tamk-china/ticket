var ticketApp = angular.module('ticketApp', ['serviceModule', 'checkParam']);

ticketApp.value('constants', {
	players: [{id:1, name:'messi', birthday:1461393730024}, {id:1, name:'messi', birthday:1461393756567}],
}).controller("ticketController", function($scope, $filter, constants, tipService, req){
	$scope.players = constants.players;

	req.get('ticket/queryTickets', {id:123456, title:'tamk'}, function(data){
		console.log(JSON.stringify(data));
	});
})