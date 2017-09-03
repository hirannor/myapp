package myapp.core.authentication.dao.impl;

import org.springframework.stereotype.Repository;

import myapp.core.authentication.dao.AuthenticationDao;
import myapp.core.authentication.dao.mapper.AuthenticationMapper;
import myapp.core.authentication.userdetails.bean.UserInfo;

/**
 * AuthenticationDAO Implementation
 * 
 * @author Mate
 *
 */
@Repository
public class AuthenticationDaoImpl implements AuthenticationDao
{
	private AuthenticationMapper authenticationMapper;

	public AuthenticationDaoImpl(AuthenticationMapper authenticationMapper)
	{
		this.authenticationMapper = authenticationMapper;
	}

	@Override
	public UserInfo getUserInfo(String usernameOrPassword)
	{
		return authenticationMapper.getUserInfo(usernameOrPassword);
	}
}
