'use strict';

app.controller('loginCtrl', function($translate, $translatePartialLoader,
		$scope, $http, $state, $authService, $cookies, $rootScope) {
	$translatePartialLoader.addPart('login');
	$translate.refresh();

	$scope.submit = function(user) {
		$http({
			method : 'POST',
			url : 'v1/accounts/login',
			data : user,
		}).success(function(account) {
			if (account) {
				$authService.loginConfirmed();
				$cookies.put('currentUser', account.firstName);
				$state.go('accounts-home');
			} else {
				// login failed
				console.log("TODO: login failed need to be handled.")
			}
		}).error(function(data, status, headers, config) {
			console.log("Calling failed to RESTful API.");
		});
	}

	$scope.logout = function() {
		$cookies.remove('currentUser');
		$rootScope.currentUser = "";
		$state.go("/");
	}
});