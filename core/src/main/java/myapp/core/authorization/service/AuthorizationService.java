package myapp.core.authorization.service;

import myapp.core.authorization.service.bean.IsAuthorizedRequest;

public interface AuthorizationService
{
	boolean isAuthorized(IsAuthorizedRequest isAuthorizedRequest);
}
