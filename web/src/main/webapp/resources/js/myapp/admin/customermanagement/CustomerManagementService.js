'use strict';

function CustomerManagementService($http) {

	var service = {
		fetchAllUsers : fetchAllUsers,
		sendNotification : sendNotification,
		createUser : createUser,
		deleteUser : deleteUser,
		editUser : editUser,
		changeAccountStatus : changeAccountStatus
	}
	return service;
	
	function fetchAllUsers() {
		return $http.post('admin/customermanagement/getCustomers');
	}
	
	function changeAccountStatus(status, username) {
		var changeStatusRequest = {
			status: status,
			username: username
		};
		return $http.post('admin/customermanagement/changeAccountStatus', changeStatusRequest);
	}
	
	function sendNotification(data) {
		return $http.post('admin/customermanagement/sendNotification', data);
	}
	
	function createUser(data) {
		var request = {
			customer: data
		};
		return $http.post('admin/customermanagement/addCustomer', request);
	}
	
	function deleteUser(customerId) {
		var request = {
			id : customerId
		};
		return $http.post('admin/customermanagement/deleteCustomer', request);
	}
	
	function editUser(customer) {
		var request = {
			customer: customer
		};
		return $http.post('admin/customermanagement/editCustomer', request);
	}

};