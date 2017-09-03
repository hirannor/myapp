function AdminModalinstanceController($modalInstance, item, $scope) {
	var vm = this;

	$scope.user = item;

	$scope.cancel = function cancel() {
		$modalInstance.dismiss('cancel');
	};

	$scope.ok = function ok() {
		$modalInstance.close($scope.user);
	};

};
AdminModalinstanceController.$inject = [ '$modalInstance', 'item', '$scope' ];