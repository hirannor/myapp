'use strict';

function NotificationService($http) {

	var service = {
		sendNotification : sendNotification
	}
	return service;
	
	function sendNotification(data) {
		return $http.post('admin/notification/sendNotification', data);
	}
	
};