'use strict';
function CustomerManagementController(CustomerManagementService, LoginService, $state, $stateParams, $modal) {
	var vm = this;
	
	vm.customers = {};
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
							return getCustomer(id);
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
							return getCustomer(id);
						}
				}
			});

			modelInstance.result.then(function(result) {
				CustomerManagementService.editUser(result).then(
						function(data) {
							fetchAllUsers();
						}, function(errResponse) {
							vm.messages = errResponse.data.message;
							console.error('Error while editing customer details: ', errResponse.data.message);
						});
			});
	};
		
	vm.changeAccountStatus = function changeAccountStatus(status, username) {
			CustomerManagementService.changeAccountStatus(status, username).then(function(data) {
				fetchAllUsers();
			}, function(errResponse) {
				vm.messages = errResponse.data.message;
				console.error('Error while changing account status of customer', errResponse.data.message);
			});	
	};
	
	vm.logout = function logoutAction() {
			LoginService.logout().then(function(data) {
				var obj = {
					success: data.data.success,
					message: data.data.message
				}
				$state.go('home', { param: obj  });
		}, function(errorResponse) {
			vm.messages = errorResponse.data.message;
		});
		
	};
	

	function fetchAllUsers() {
		CustomerManagementService.fetchAllUsers().then(function(data) {
			vm.customers = data.data.customerList;
		}, function(errResponse) {
			vm.messages = errResponse.data.message;
			console.error('Error while fetching users from database: ', errResponse.data.message);
		});
	};
	
	function createUser(customer) {
		CustomerManagementService.createUser(customer).then(
				function(data) {
					vm.messages = data.message;
					fetchAllUsers();
				}, function(errResponse) {
					vm.messages = errResponse.data.message;
					console.error('Error while adding customer: ', errResponse.data.message);
				});
	};
	
	function editUser(customer) {
		CustomerManagementService.editUser(customer).then(
				function(data) {
					fetchAllUsers();
				}, function(errResponse) {
					vm.messages = errResponse.data.message;
					console.error('Error while editing customer details: ', errResponse.data.message);
				});
	};
	
	vm.deleteUser = function(customerId) {
		CustomerManagementService.deleteUser(customerId).then(function(data) {
					vm.messages = data.message;
					fetchAllUsers();
				}, function(errResponse) {
					vm.messages = errResponse.data.message;
					console.error('Error while deleting user from database: ', errResponse.data.message);
				});
	};
	
	function getCustomer(customerId) {
		var customer = {};
		var customers = angular.copy(vm.customers);
		angular.forEach(customers, function(value,key) {
			if (value.id == customerId) {
				customer = value;
			}
		});
		return customer;
	};
	
};

CustomerManagementController.$inject = ['CustomerManagementService', 'LoginService', '$state', '$stateParams', '$modal'];
