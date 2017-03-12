'use strict';
function NotificationController(NotificationService) {
	var vm = this;
	
	vm.messages = {};

	vm.sendNotification = function sendNotification() {
		NotificationService.sendNotification(vm.email).then(function(data) {
			var isSuccess = data.data.success;
			if (isSuccess)
			{
				vm.messages = {
					success: data.data.success,
					message: 'Email send was successfull!'
				};
			}
		}, function(errResponse) {
			vm.messages = {
					success: errResponse.data.success,
					message: errResponse.data.message
			};
			console.error('Error while sending notification to customer: ', errResponse.data.message);
		});
	};
	
};

NotificationController.$inject = ['NotificationService'];
