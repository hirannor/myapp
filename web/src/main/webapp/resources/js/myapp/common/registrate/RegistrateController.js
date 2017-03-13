'use strict';
function RegistrateController(RegistrateService, $state) {
	var vm = this;
	
	vm.registrateAction = function registrate() {

		RegistrateService.registrate(vm.registrate).then(function(data) {
			if (data.data.success == false) {
				vm.messages = {
					success : data.data.success,
					message : data.data.message
				};
			} else {
				var obj = {
					success : data.data.success,
					message : 'Registration was successfull!'
				};
				$state.go('home', {
					param : obj
				});
			}
		}, function(errorResponse) {
			vm.messages = errorResponse.data;
		});
	};

};

RegistrateController.$inject = [ 'RegistrateService', '$state' ];
