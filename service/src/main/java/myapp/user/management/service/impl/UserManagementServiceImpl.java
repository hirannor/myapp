package myapp.user.management.service.impl;

import org.springframework.stereotype.Service;

import myapp.user.management.dao.UserManagementDao;
import myapp.user.management.service.UserManagementService;
import myapp.user.management.service.bean.ChangeStatusRequest;
import myapp.user.management.service.bean.GetUserListServiceReply;
import myapp.user.management.service.bean.UserDeleteServiceRequest;
import myapp.user.management.service.bean.UserEditServiceRequest;

/**
 * UserManagementService Implementation
 * 
 * @author Mate
 *
 */
@Service
public class UserManagementServiceImpl implements UserManagementService
{
	private UserManagementDao userManagementDao;

	public UserManagementServiceImpl(UserManagementDao userManagementDao) 
	{
		this.userManagementDao = userManagementDao;
	}

	@Override
	public void deleteUserById(UserDeleteServiceRequest request)
	{
		userManagementDao.deleteUsrAuthById(request.getId());
		userManagementDao.deleteUserById(request.getId());
	}

	@Override
	public void editUser(UserEditServiceRequest request)
	{
		userManagementDao.editUser(request.getUser());
	}

	@Override
	public GetUserListServiceReply getUserList()
	{
		GetUserListServiceReply reply = new GetUserListServiceReply();
		reply.setUserList(userManagementDao.getUserList());

		return reply;
	}

	@Override
	public void changeAccountStatus(ChangeStatusRequest request)
	{
		userManagementDao.changeAccountStatus(request);
	}
}
