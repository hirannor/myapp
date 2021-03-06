'use strict';
function LoginController(LoginService, $state, $stateParams, $modal) {
	var vm = this;
	vm.messages = {};
	
	if(angular.isDefined($stateParams.param) && $stateParams.param.success != null)
	{
		var isSuccess = $stateParams.param.success;
		if(isSuccess)
		{
			vm.messages = $stateParams.param;
		}
	}
	
	vm.resetPassword = function resetPassword() {
		var modelInstance = $modal
				.open({
					animation : true,
					templateUrl : 'htmlcontent/common/login/modal/resetPasswordModal.html',
					controller : 'ResetPasswordModalinstanceController',
					controllerAs : 'ResetPasswordModalinstanceController'
				});
		
		modelInstance.result.then(function(result) {
			LoginService.resetPassword(result).then(
					function(data) {
					var isSuccess = data.data.success;
					if (isSuccess)
					{
						vm.messages = { 
							success: isSuccess,
							message: 'Your new password has been sent to your email address!'
						};
					}
					}, function(errResponse) {
						vm.messages = errResponse.data.message;
						console.error('Error while invoking resetPassword service ', errResponse.data.message);
					});
		});
	};
	
	vm.loginAction = function loginAction() {
		
		LoginService.login(angular.toJson(vm.login)).then(function(data) {
			var obj = {
				success: data.data.success,
				message: data.data.message,
				authority: data.data.authority
			}
			if(obj.authority == 'ADMIN' || obj.authority == 'READONLY')
			{
				$state.go('admin', { param: obj});
			}
			else
			{
				$state.go('customer', { param: obj});
			}
			
		}, function(errorResponse) {
			vm.messages = errorResponse.data;
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
LoginController.$inject = ['LoginService','$state', '$stateParams', '$modal'];
