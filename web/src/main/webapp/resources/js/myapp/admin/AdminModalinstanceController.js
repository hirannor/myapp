function AdminModalinstanceController($modalInstance, item, $scope) {
	var vm = this;

	$scope.customer = item;

	$scope.cancel = function cancel() {
		$modalInstance.dismiss('cancel');
	};

	$scope.ok = function ok() {
		$modalInstance.close($scope.customer);
	};

};
AdminModalinstanceController.$inject = [ '$modalInstance', 'item', '$scope' ];