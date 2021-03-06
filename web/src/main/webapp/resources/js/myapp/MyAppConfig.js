'use strict';
function MyAppConfig($stateProvider, $urlRouterProvider, $locationProvider,
		$httpProvider) {
	
	$httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';
	$urlRouterProvider.otherwise('/');
	$locationProvider.html5Mode(true);

	$stateProvider
			.state(
					'home',
					{
						url : '/',
						templateUrl : 'htmlcontent/common/login/login.html',
						controller : 'LoginController',
						controllerAs : 'vm',
						params: { 
							param: undefined
						},
					})
			.state(
					'signUp',
					{
						templateUrl : 'htmlcontent/common/registrate/signUp.html',
						controller : 'RegistrateController',
						controllerAs : 'vm',
						params: { 
							param: undefined
						},
					})
			.state(
					'forbidden',
					{
						url : '/accesDenied',
						templateUrl : 'htmlcontent/common/login/forbiddenPage.html',
						controller : 'AccesDeniedController',
						controllerAs : 'vm'
					})
			.state(
					'admin',
					{
						url : '/admin/',
						params: { 
							param: undefined
						},
						views : {
							'' : {
								templateUrl : 'htmlcontent/role/admin/mainPage.html'
							},
							"sideBar@admin" : {
								templateUrl : 'htmlcontent/role/admin/sideBar.html',
								controller : 'LoginController',
								controllerAs : 'vm'
							},
							"header@admin" : {
								templateUrl : 'htmlcontent/role/admin/header.html',
								controller : 'LoginController',
								controllerAs : 'vm'
							},
							"content@admin" : {
								templateUrl : 'htmlcontent/role/admin/startPage.html',
							}
						}
					})
			.state(
					'admin.userManagement',
					{
						url : 'userManagement',
						views : {
							"content@admin" : {
								templateUrl : 'htmlcontent/role/admin/userManagement.html',
								controller : 'UserManagementController',
								controllerAs : 'vm',
							}
						}
					})
			.state(
					'admin.notification',
					{
						url : 'notification',
						views : {
							"content@admin" : {
								templateUrl : 'htmlcontent/role/admin/emailService.html',
								controller : 'NotificationController',
								controllerAs : 'vm',
							}
						}
					})
			.state(
					'customer',
					{
						url : '/customer/',
						params: { 
							param: undefined
						},
						views : {
							'' : {
								templateUrl : 'htmlcontent/role/customer/mainPage.html'
							},
							"header@customer" : {
								templateUrl : 'htmlcontent/role/customer/header.html',
								controllerAs : 'vm',
								controller : 'LoginController',
							},
							"content@customer" : {
								templateUrl : 'htmlcontent/role/customer/startPage.html',
							},
							"footer@customer" : {
								templateUrl : 'htmlcontent/role/customer/footer.html',
							}
						}
					})
			.state(
					'customer.contact',
					{
						url: 'contactUs',
						views : {
							"content@customer" : {
								templateUrl : 'htmlcontent/role/customer/contact.html',
								controller : 'NotificationController',
								controllerAs : 'vm'
							}
						}
					})
			.state(
					'customer.myProfile',
					{
						url: 'myProfile',
						views : {
							"content@customer" : {
								templateUrl : 'htmlcontent/role/customer/profile.html',
								controller : 'PersonalSettingsController',
								controllerAs : 'vm'
							}
						}
					})
			.state(
					'customer.service',
					{
						url: 'services',
						views : {
							"content@customer" : {
								templateUrl : 'htmlcontent/role/customer/services.html',
								controllerAs : 'vm'
							}
						}
					})
			.state(
					'customer.aboutUs',
					{
						url: 'aboutUs',
						views : {
							"content@customer" : {
								templateUrl : 'htmlcontent/role/customer/aboutUs.html',
								controllerAs : 'vm'
							}
						}
					})
}
