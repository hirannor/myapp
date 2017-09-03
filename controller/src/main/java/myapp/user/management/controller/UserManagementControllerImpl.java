package myapp.user.management.controller;

import myapp.core.bean.JsonReply;
import myapp.user.management.facade.UserManagementFacade;
import myapp.user.management.service.bean.ChangeStatusRequest;
import myapp.user.management.service.bean.GetUserListServiceReply;
import myapp.user.management.service.bean.UserDeleteServiceRequest;
import myapp.user.management.service.bean.UserEditServiceRequest;

/**
 * 
 * @author Mate
 *
 */
public class UserManagementControllerImpl implements UserManagementController
{
	private UserManagementFacade userManagementFacade;

	public UserManagementControllerImpl(UserManagementFacade customerManagementService)
	{
		this.userManagementFacade = customerManagementService;
	}

	public JsonReply changeAccountStatus(ChangeStatusRequest request)
	{
		userManagementFacade.changeAccountStatus(request);
		return new JsonReply();
	}

	public JsonReply deleteCustomerById(UserDeleteServiceRequest request)
	{
		userManagementFacade.deleteUserById(request);
		return new JsonReply();
	}

	public JsonReply editCustomer(UserEditServiceRequest request)
	{
		userManagementFacade.editUser(request);
		return new JsonReply();
	}

	public GetUserListServiceReply getCustomerList()
	{
		return userManagementFacade.getUserList();
	}

}
