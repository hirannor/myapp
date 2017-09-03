package myapp.core.authorization.dao.impl;

import org.springframework.stereotype.Repository;

import myapp.core.authorization.dao.AuthorizationDao;
import myapp.core.authorization.dao.mapper.AuthorizationMapper;
import myapp.core.authorization.service.bean.IsAuthorizedReply;
import myapp.core.authorization.service.bean.IsAuthorizedRequest;

@Repository
public class AuthorizationDaoImpl implements AuthorizationDao
{
	private AuthorizationMapper authorizationMapper;

	public AuthorizationDaoImpl(AuthorizationMapper authorizationMapper) 
	{
		this.authorizationMapper = authorizationMapper;
	}

	@Override
	public IsAuthorizedReply isAuthorized(IsAuthorizedRequest isAuthorizedRequest)
	{
		return authorizationMapper.isAuthorized(isAuthorizedRequest);
	}
}
