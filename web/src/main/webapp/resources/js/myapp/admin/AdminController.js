'use strict';
function AdminController(AdminService, LoginService, $state, $stateParams, $modal) {
	var vm = this;
	
	vm.messages = {}
	
	var param = $stateParams.param;

	if(angular.isDefined(param) && param.success != null)
	{
		if (param.success == true)
		{
			vm.messages = param;
		}
	}
	
	var promise = AdminService.getAuthenticatedUser();
		promise.then(function(data) {
			vm.authedUser = {	
				username : data.data.principal,
				authorities : data.data.authorities,
			};
		}, function(errResponse) {
			vm.messages = errResponse.data.message;
			console.error('Error while getting principal from context: ', errResponse.data.message);
	});
	
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

AdminController.$inject = ['AdminService', 'LoginService', '$state', '$stateParams', '$modal'];
