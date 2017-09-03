'use strict';

function UserManagementService($http) {

	var service = {
		fetchAllUsers : fetchAllUsers,
		createUser : createUser,
		deleteUser : deleteUser,
		editUser : editUser,
		changeAccountStatus : changeAccountStatus
	}
	return service;
	
	function fetchAllUsers() {
		return $http.post('usermanagement/getUsers');
	}
	
	function changeAccountStatus(status, username) {
		var changeStatusRequest = {
			status: status,
			username: username
		};
		return $http.post('usermanagement/changeAccountStatus', changeStatusRequest);
	}
	
	function createUser(data) {
		var request = {
			customer: data
		};
		return $http.post('usermanagement/addUser', request);
	}
	
	function deleteUser(customerId) {
		var request = {
			id : customerId
		};
		return $http.post('usermanagement/deleteUser', request);
	}
	
	function editUser(user) {
		var request = {
			user: user
		};
		return $http.post('usermanagement/editUser', request);
	}

};