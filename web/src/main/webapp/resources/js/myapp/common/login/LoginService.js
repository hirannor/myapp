'use strict';

function LoginService($http) {
	
	var service = {
		login: login,
		logout: logout,
		resetPassword: resetPassword
	}
	return service;
	
	function login(data) {
		return $http.post('login', data);
	}
	
	function logout(data) {
		return $http.post('logout', data);
	}
	
	function resetPassword(data) {
		return $http.post('resetPassword', data);
	}
		
};