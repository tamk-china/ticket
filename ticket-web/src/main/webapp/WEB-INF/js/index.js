var ticketApp = angular.module('ticketApp', ['serviceModule']);

ticketApp.value('constants', {
	players: [{id:1, name:'messi', birthday:1461393730024}, {id:1, name:'messi', birthday:1461393756567}],
}).controller("ticketController", function($scope, $filter, constants, tipService){
	tipService.alert('hello angular');
	$scope.players = constants.players;
})