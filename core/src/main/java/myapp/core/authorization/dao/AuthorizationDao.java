package myapp.core.authorization.dao;

import myapp.core.authorization.service.bean.IsAuthorizedReply;
import myapp.core.authorization.service.bean.IsAuthorizedRequest;

public interface AuthorizationDao
{
	IsAuthorizedReply isAuthorized(IsAuthorizedRequest isAuthorizedRequest);
}
