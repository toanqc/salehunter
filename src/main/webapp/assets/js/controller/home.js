'use strict';

app.controller('homeCtrl', function($translate, $translatePartialLoader) {
	$translatePartialLoader.addPart('home');
	$translate.refresh();
});