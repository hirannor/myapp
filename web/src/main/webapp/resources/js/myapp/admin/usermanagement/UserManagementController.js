'use strict';
function UserManagementController(UserManagementService, LoginService, $state, $stateParams, $modal) {
	var vm = this;
	
	vm.users = {};
	vm.messages = {}
	
	if(angular.isDefined($stateParams.param) && $stateParams.param.success != null)
	{
		var isSuccess = $stateParams.param.success;
		if(isSuccess)
		{
			vm.messages = $stateParams.param;
		}
	}
	
	fetchAllUsers();
	
	vm.showModalUserDetails = function showModalUserDetails(id) {
		var modelInstance = $modal
				.open({
					animation : true,
					templateUrl : 'htmlcontent/role/admin/modal/userManageModal.html',
					controller : 'AdminModalinstanceController',
					controllerAs : 'AdminModalinstanceController',
					resolve : {
						item : function() {
							return getUser(id);
						}

					}
				});
	};
	
	vm.showModalEditUser = function showModalUserDetails(id) {
			var modelInstance = $modal.open({
				animation : true,
				templateUrl : 'htmlcontent/role/admin/modal/userEditModal.html',
				controller : 'AdminModalinstanceController',
				controllerAs : 'AdminModalinstanceController',
				size : 300,
				resolve : {
					item : function() {
							return getUser(id);
						}
				}
			});

			modelInstance.result.then(function(result) {
				UserManagementService.editUser(result).then(
						function(data) {
							fetchAllUsers();
						}, function(errResponse) {
							vm.messages = errResponse.data.message;
							console.error('Error while editing user details: ', errResponse.data.message);
						});
			});
	};
		
	vm.changeAccountStatus = function changeAccountStatus(status, username) {
			UserManagementService.changeAccountStatus(status, username).then(function(data) {
				fetchAllUsers();
			}, function(errResponse) {
				vm.messages = errResponse.data.message;
				console.error('Error while changing account status of user', errResponse.data.message);
			});	
	};
	
	function fetchAllUsers() {
		UserManagementService.fetchAllUsers().then(function(data) {
			vm.users = data.data.userList;
		}, function(errResponse) {
			vm.messages = errResponse.data.message;
			console.error('Error while fetching users from database: ', errResponse.data.message);
		});
	};
	
	function createUser(user) {
		UserManagementService.createUser(user).then(
				function(data) {
					vm.messages = data.message;
					fetchAllUsers();
				}, function(errResponse) {
					vm.messages = errResponse.data.message;
					console.error('Error while adding user: ', errResponse.data.message);
				});
	};
	
	function editUser(user) {
		UserManagementService.editUser(user).then(
				function(data) {
					fetchAllUsers();
				}, function(errResponse) {
					vm.messages = errResponse.data.message;
					console.error('Error while editing user details: ', errResponse.data.message);
				});
	};
	
	vm.deleteUser = function(userId) {
		UserManagementService.deleteUser(userId).then(function(data) {
					vm.messages = data.message;
					fetchAllUsers();
				}, function(errResponse) {
					vm.messages = errResponse.data.message;
					console.error('Error while deleting user from database: ', errResponse.data.message);
				});
	};
	
	function getUser(userId) {
		var user = {};
		var users = angular.copy(vm.users);
		angular.forEach(users, function(value,key) {
			if (value.id == userId) {
				user = value;
			}
		});
		return user;
	};
	
};

UserManagementController.$inject = ['UserManagementService', 'LoginService', '$state', '$stateParams', '$modal'];
