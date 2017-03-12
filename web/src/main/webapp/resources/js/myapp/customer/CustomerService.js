'use strict';

function CustomerService($http) {

	var service = {
		getAuthenticatedUser: getAuthenticatedUser
	}
	return service;
	
	function getAuthenticatedUser() {
		return $http.post('customer/authenticatedUser');
	}

};