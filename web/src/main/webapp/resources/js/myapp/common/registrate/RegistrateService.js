'use strict';

function RegistrateService($http) {

	var service = {
		registrate : registrate
	}
	return service;

	function registrate(data) {
		return $http.post('registrate', data);
	}

};