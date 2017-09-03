package myapp.user.management.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import myapp.user.bean.User;
import myapp.user.management.dao.UserManagementDao;
import myapp.user.management.dao.mapper.UserManagementMapper;
import myapp.user.management.service.bean.ChangeStatusRequest;

/**
 * UserManagementDao Implementation
 * 
 * @author Mate
 *
 */
@Repository
public class UserManagementDaoImpl implements UserManagementDao
{
	private UserManagementMapper userManagementMapper;

	public UserManagementDaoImpl(UserManagementMapper userManagementMapper) 
	{
		this.userManagementMapper = userManagementMapper;
	}

	@Override
	public void deleteUserById(int id)
	{
		userManagementMapper.deleteUserById(id);
	}

	@Override
	public Integer editUser(User customer)
	{
		return userManagementMapper.editUser(customer);
	}

	@Override
	public List<User> getUserList()
	{
		return userManagementMapper.getUserList();
	}

	@Override
	public void deleteUsrAuthById(int id)
	{
		userManagementMapper.deleteUsrAuthById(id);
	}

	@Override
	public void changeAccountStatus(ChangeStatusRequest request)
	{
		userManagementMapper.changeAccountStatus(request);
	}
}
