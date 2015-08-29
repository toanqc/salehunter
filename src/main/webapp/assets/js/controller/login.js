'use strict';

app.controller('loginCtrl', function($translate,
		$translatePartialLoader, $scope, $http, $state, $authService, $rootScope) {
	$translatePartialLoader.addPart('login');
	$translate.refresh();

	$scope.submit = function(data) {
		$http.post('auth/login', data).success(function() {
			$authService.loginConfirmed();
			$state.go('accounts-home');
		});
	}
});