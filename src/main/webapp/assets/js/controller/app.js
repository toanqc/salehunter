'use strict';

var app = angular.module('salehunter', [ 'ngRoute', 'ngCookies',
		'pascalprecht.translate' ]);

app.config(function($translateProvider, $translatePartialLoaderProvider) {

	// Initialize angular-translate
	$translateProvider.useLoader('$translatePartialLoader', {
		urlTemplate : 'i18n/{part}_{lang}.json'
	});
	$translateProvider.preferredLanguage('en');
	$translateProvider.useSanitizeValueStrategy(null);
	$translateProvider.useLocalStorage();
	$translatePartialLoaderProvider.addPart('header-footer');

});

app.controller('appCtrl', [ '$scope', '$translate',
		function($scope, $translate) {
			$scope.changeLanguage = function(langKey) {
				$translate.use(langKey);
			};
		} ]);

app.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/', {
		templateUrl : 'views/home.html'
	}).when('/accounts/register', {
		templateUrl : 'views/accounts-register.html',
		controller : 'accountCtrl'
	}).when('/accounts/login', {
		templateUrl : 'views/login.html',
		controller : 'loginCtrl'
	}).otherwise({
		templateUrl : 'views/errors/404.html'
	});
} ]);