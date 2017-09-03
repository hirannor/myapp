package myapp.user.service.impl;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import myapp.user.bean.User;
import myapp.user.common.service.bean.RegistrateRequest;
import myapp.user.common.service.bean.ResetPasswordReply;
import myapp.user.common.service.bean.ResetPasswordRequest;
import myapp.user.dao.UserDao;
import myapp.user.exception.EmailNotFoundException;
import myapp.user.exception.UserAlreadyExistException;
import myapp.user.management.service.bean.GetUserServiceResponse;
import myapp.user.service.UserService;

/**
 * UserService Implementation
 * 
 * @author Mate
 *
 */
@Service
public class UserServiceImpl implements UserService
{
	private UserDao userDao;
	private BCryptPasswordEncoder passwordEncoder;

	public UserServiceImpl(UserDao userDao, BCryptPasswordEncoder passwordEncoder) 
	{
		this.userDao = userDao;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public GetUserServiceResponse getUser(String username)
	{
		GetUserServiceResponse response = new GetUserServiceResponse();
		response.setUser(userDao.getUser(username));

		return response;
	}

	@Override
	public void registrate(RegistrateRequest registrateRequest) throws UserAlreadyExistException
	{
		if (isUserExist(registrateRequest.getUsername()))
		{
			throw new UserAlreadyExistException("Username already exist, please choose another one!");
		}

		User user = new User();
		user.setUsername(registrateRequest.getUsername());
		user.setPassword(registrateRequest.getPassword());
		user.setName(registrateRequest.getName());
		user.setEmail(registrateRequest.getEmail());
		user.setAge(registrateRequest.getAge());

		String hashedPassword = passwordEncoder.encode(registrateRequest.getPassword());

		userDao.insertUser(registrateRequest);
		userDao.insertUsrAuth(registrateRequest.getUsername(), hashedPassword);
		userDao.insertUsrRole(registrateRequest.getUsername(), UserService.DEFAULT_ROLE);
	}

	@Override
	public ResetPasswordReply resetPassword(ResetPasswordRequest resetPasswordRequest) throws EmailNotFoundException
	{
		ResetPasswordReply reply = new ResetPasswordReply();
		String generatedPassword = RandomStringUtils.randomAlphanumeric(8);
		String hashedPassword = passwordEncoder.encode(generatedPassword);

		if (userDao.resetPassword(resetPasswordRequest.getEmail(), hashedPassword) < 0)
		{
			throw new EmailNotFoundException("Email is not found in our system!");
		}

		reply.setNewPassword(generatedPassword);

		return reply;

	}

	private boolean isUserExist(String username)
	{
		if (userDao.getUser(username) != null)
		{
			return true;
		}
		return false;
	}

}
