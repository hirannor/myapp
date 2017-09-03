package myapp.user.management.service;

import myapp.user.management.service.bean.ChangeStatusRequest;
import myapp.user.management.service.bean.GetUserListServiceReply;
import myapp.user.management.service.bean.UserDeleteServiceRequest;
import myapp.user.management.service.bean.UserEditServiceRequest;

/**
 * CustomerManagementService API
 * 
 * @author Mate
 *
 */
public interface UserManagementService
{
	/**
	 * Method for retrieving users
	 * 
	 * @return {@link GetUserListServiceReply}
	 */
	GetUserListServiceReply getUserList();

	/**
	 * Method for deleting user by Id
	 * 
	 * @param request {@link UserDeleteServiceRequest}
	 */
	void deleteUserById(UserDeleteServiceRequest request);

	/**
	 * Method for editing user
	 * 
	 * @param request {@link UserEditServiceRequest}
	 */
	void editUser(UserEditServiceRequest request);

	/**
	 * Method for changing account status of user
	 * 
	 * @param request {@link ChangeStatusRequest}
	 */
	void changeAccountStatus(ChangeStatusRequest request);
}
