package myapp.user.management.facade;

import myapp.user.management.service.bean.ChangeStatusRequest;
import myapp.user.management.service.bean.GetUserListServiceReply;
import myapp.user.management.service.bean.UserDeleteServiceRequest;
import myapp.user.management.service.bean.UserEditServiceRequest;

/**
 * UserManagementFacade API
 * 
 * @author Mate
 *
 */
public interface UserManagementFacade
{
	/**
	 * Method for retrieving Users
	 * 
	 * @return {@link GetUserListServiceReply}
	 */
	GetUserListServiceReply getUserList();

	/**
	 * Method for deleting User by Id
	 * 
	 * @param request {@link UserDeleteServiceRequest}
	 */
	void deleteUserById(UserDeleteServiceRequest request);

	/**
	 * Method for editing User
	 * 
	 * @param request {@link UserEditServiceRequest}
	 */
	void editUser(UserEditServiceRequest request);

	/**
	 * Method for changing account status of User
	 * 
	 * @param request {@link ChangeStatusRequest}
	 */
	void changeAccountStatus(ChangeStatusRequest request);
}
