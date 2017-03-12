'use strict';
function CustomerController(CustomerService, LoginService, $state, $stateParams) {
	
	var vm = this;
	
	vm.messages = {}
	
	getAuthenticatedUser();
	
	function getAuthenticatedUser() {
		CustomerService.getAuthenticatedUser().then(function(data) {
			vm.authedUser = data.data.customer;
			}, function(errResponse) {
				vm.messages = errResponse.data.message;
				console.error('Error while getting principal from context: ', errResponse.data.message);
				$state.go('forbidden');
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
	
};

CustomerController.$inject = ['CustomerService', 'LoginService', '$state', '$stateParams'];
