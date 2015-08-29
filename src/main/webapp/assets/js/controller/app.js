'use strict';

var app = angular.module('salehunter', [ 'ui.router', 'ngCookies',
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

app.controller('appCtrl', function($scope, $translate) {
	$scope.changeLanguage = function(langKey) {
		$translate.use(langKey);
	};
});

app.config(function($stateProvider, $urlRouterProvider) {
	$urlRouterProvider.when('', '/');
	$urlRouterProvider.otherwise('404');

	$stateProvider.state('/', {
		url : '/',
		templateUrl : 'views/home.html'
	}).state('accounts-register', {
		url : '/accounts/register',
		templateUrl : 'views/account-register.html',
		controller : 'accountCtrl'
	}).state('accounts-login', {
		url : '/accounts/login',
		templateUrl : 'views/login.html',
		controller : 'loginCtrl'
	}).state('accounts-home', {
		url : '/accounts/home',
		templateUrl : 'views/account-home.html',
	}).state('404', {
		url : '/404',
		templateUrl : 'views/errors/404.html'
	});
});