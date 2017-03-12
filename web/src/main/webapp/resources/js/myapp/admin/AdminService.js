'use strict';

function AdminService($http) {

	var service = {
		getAuthenticatedUser : getAuthenticatedUser,
	}
	return service;
	
	function getAuthenticatedUser() {
		return $http.post('admin/authenticatedUser');
	}
};