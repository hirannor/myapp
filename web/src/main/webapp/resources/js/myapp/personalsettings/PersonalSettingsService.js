'use strict';

function PersonalSettingsService($http) {

	var service = {
		getPersonalInformations: getPersonalInformations
	}
	return service;
	
	function getPersonalInformations() {
		return $http.post('personalsettings/personalinformations');
	}

};