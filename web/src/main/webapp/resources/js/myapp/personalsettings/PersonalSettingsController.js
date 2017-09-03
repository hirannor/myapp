'use strict';
function PersonalSettingsController(PersonalSettingsService, LoginService, $state, $stateParams) {
	
	var vm = this;
	
	vm.messages = {}
	
	getPersonalInformations();
	
	function getPersonalInformations() {
		PersonalSettingsService.getPersonalInformations().then(function(data) {
			vm.authedUser = data.data.userDetails;
			}, function(errResponse) {
				vm.messages = errResponse.data.message;
				console.error('Error while getting principal from context: ', errResponse.data.message);
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

PersonalSettingsController.$inject = ['PersonalSettingsService', 'LoginService', '$state', '$stateParams'];
