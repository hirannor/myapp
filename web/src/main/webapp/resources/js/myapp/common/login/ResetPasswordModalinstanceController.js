function ResetPasswordModalinstanceController($modalInstance, $scope) {

	$scope.resetPassword = {
	};

	$scope.cancel = function cancel() {
		$modalInstance.dismiss('cancel');
	};

	$scope.ok = function ok() {
		$modalInstance.close($scope.resetPassword);
	};

};
ResetPasswordModalinstanceController.$inject = [ '$modalInstance', '$scope'];