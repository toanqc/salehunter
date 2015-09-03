'use strict';

var app = angular.module('salehunter', [ 'http-auth-interceptor', 'ui.router',
		'ngCookies', 'pascalprecht.translate', 'ngMessages' ]);

app.config(function($translateProvider, $translatePartialLoaderProvider) {

	// Initialize angular-translate
	$translateProvider.useLoader('$translatePartialLoader', {
		urlTemplate : 'i18n/{part}_{lang}.json'
	});
	$translateProvider.preferredLanguage('en');
	$translateProvider.useSanitizeValueStrategy(null);
	$translateProvider.useLocalStorage();
	$translatePartialLoaderProvider.addPart('global');
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
		access : {
			requiredLogin : true
		}
	}).state('404', {
		url : '/404',
		templateUrl : 'views/errors/404.html'
	});
});

app.run(function($window, $rootScope, $state) {

	$rootScope.$on('$stateChangeStart', function(event, toState, toParams) {
		var isAuthenticationRequired = toState.access
				&& toState.access.requiredLogin;

		var currentUser = $window.sessionStorage.currentUser;
		if (currentUser) {
			$rootScope.currentUser = currentUser;
		}

		if (isAuthenticationRequired && currentUser === undefined) {
			event.preventDefault();
			$state.go('accounts-login');
		}
	});
});