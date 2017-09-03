package myapp.user.dao.impl;

import org.springframework.stereotype.Repository;

import myapp.user.bean.User;
import myapp.user.common.service.bean.RegistrateRequest;
import myapp.user.dao.UserDao;
import myapp.user.dao.mapper.UserMapper;

/**
 * CustomerDao Implementation
 * 
 * @author Mate
 *
 */
@Repository
public class UserDaoImpl implements UserDao
{
	private UserMapper userMapper;

	public UserDaoImpl(UserMapper customerMapper)
	{
		this.userMapper = customerMapper;
	}

	@Override
	public User getUser(String username)
	{
		return userMapper.getUser(username);
	}

	@Override
	public Integer insertUser(RegistrateRequest registrateRequest)
	{
		return userMapper.insertUser(registrateRequest);
	}

	@Override
	public Integer insertUsrAuth(String username, String password)
	{
		return userMapper.insertUsrAuth(username, password);
	}

	@Override
	public Integer insertUsrRole(String username, String role)
	{
		return userMapper.insertUsrRole(username, role);
	}

	@Override
	public Integer resetPassword(String usernameOrEmail, String newPassword)
	{
		return userMapper.resetPassword(usernameOrEmail, newPassword);
	}
}
