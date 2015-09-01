'use strict';

app.controller('accountCtrl', function($scope, $translate, $translatePartialLoader) {
	$translatePartialLoader.addPart('account');
	$translate.refresh();
	$scope.message = 'This is Add new order screen';
});