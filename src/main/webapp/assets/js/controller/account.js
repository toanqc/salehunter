'use strict';

app.controller('accountCtrl', function($scope, $http, $state, $translate,
		$translatePartialLoader) {
	$translatePartialLoader.addPart('validation');
	$translatePartialLoader.addPart('account');
	$translate.refresh();

	$scope.registerAccount = function(account) {
		$http({
			method : 'POST',
			url : 'v1/accounts',
			data : account,
		}).success(function(data) {
			$state.go("accounts-success");
		}).error(function(data, status, headers, config) {
			console.log("Calling failed to RESTful API.");
		});
	}
});