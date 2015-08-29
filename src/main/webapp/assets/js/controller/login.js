app.controller('loginCtrl', function($translate, $translatePartialLoader) {
	$translatePartialLoader.addPart('login');
	$translate.refresh();
});