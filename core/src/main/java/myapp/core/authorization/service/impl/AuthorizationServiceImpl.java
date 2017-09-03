package myapp.core.authorization.service.impl;

import org.springframework.stereotype.Service;

import myapp.core.authorization.dao.AuthorizationDao;
import myapp.core.authorization.service.AuthorizationService;
import myapp.core.authorization.service.bean.IsAuthorizedReply;
import myapp.core.authorization.service.bean.IsAuthorizedRequest;

@Service
public class AuthorizationServiceImpl implements AuthorizationService
{
	private AuthorizationDao authorizationDao;

	public AuthorizationServiceImpl(AuthorizationDao authorizationDao)
	{
		this.authorizationDao = authorizationDao;
	}

	@Override
	public boolean isAuthorized(IsAuthorizedRequest isAuthorizedRequest)
	{
		IsAuthorizedReply isAuthorizedReply = authorizationDao.isAuthorized(isAuthorizedRequest);
		
		if (isAuthorizedReply != null)
		{
			return true;
		}
		return false;
	}
}
