package myapp.user.management.facade.impl;

import myapp.core.authorization.annotation.Operation;
import myapp.core.authorization.annotation.Function;
import myapp.user.management.facade.UserManagementFacade;
import myapp.user.management.service.UserManagementService;
import myapp.user.management.service.bean.ChangeStatusRequest;
import myapp.user.management.service.bean.GetUserListServiceReply;
import myapp.user.management.service.bean.UserDeleteServiceRequest;
import myapp.user.management.service.bean.UserEditServiceRequest;

/**
 * UserManagementFacade Implementation
 * 
 * @author Mate
 *
 */
@Function(name = UserManagementFacadeImpl.FUNCTION)
public class UserManagementFacadeImpl implements UserManagementFacade
{
	protected final static String FUNCTION = "customermanagement";
	
	private static final String OPERATION_VIEW = "view";
	private static final String OPERATION_MODIFY = "modify";

	private UserManagementService userManagementService;

	public UserManagementFacadeImpl(UserManagementService userManagementService) {
		this.userManagementService = userManagementService;
	}

	@Override
	@Operation(name = OPERATION_VIEW)
	public GetUserListServiceReply getUserList()
	{
		return userManagementService.getUserList();
	}

	@Override
	@Operation(name = OPERATION_MODIFY)
	public void deleteUserById(UserDeleteServiceRequest request)
	{
		userManagementService.deleteUserById(request);
	}

	@Override
	@Operation(name = OPERATION_MODIFY)
	public void editUser(UserEditServiceRequest request)
	{
		userManagementService.editUser(request);

	}

	@Override
	@Operation(name = OPERATION_MODIFY)
	public void changeAccountStatus(ChangeStatusRequest request)
	{
		userManagementService.changeAccountStatus(request);
	}

}
