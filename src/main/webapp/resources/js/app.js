'use strict';

var app = angular.module('salehunter',
		[ 'ngCookies', 'pascalprecht.translate' ]);

app.config(function($translateProvider, $translatePartialLoaderProvider) {

	// Initialize angular-translate
	$translateProvider.useLoader('$translatePartialLoader', {
		urlTemplate : 'i18n/{lang}/{part}.json'
	});
	$translateProvider.preferredLanguage('en');
	$translateProvider.useSanitizeValueStrategy(null);
	$translateProvider.useLocalStorage();
	$translatePartialLoaderProvider.addPart('header');

});

app.controller('appCtrl', [ '$scope', '$translate',
		function($scope, $translate) {
			$scope.changeLanguage = function(langKey) {
				$translate.uses(langKey);
			};
		} ]);