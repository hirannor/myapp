package myapp.core.authorization.evaluator;

import java.io.Serializable;

import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;

import myapp.core.authorization.service.AuthorizationService;
import myapp.core.authorization.service.bean.IsAuthorizedRequest;
import myapp.core.bean.Authority;

public class CustomAuthorizationEvaluator implements PermissionEvaluator
{
	private AuthorizationService authorizationService;

	public CustomAuthorizationEvaluator(AuthorizationService authorizationService)
	{
		this.authorizationService = authorizationService;
	}

	@Override
	public boolean hasPermission(Authentication auth, Object targetDomainObject, Object permission)
	{
		if ((auth == null) || !(permission instanceof String))
		{
			return false;
		}
		Authority authority = convertStringToAuthority(permission.toString());
		IsAuthorizedRequest isAuthorizedRequest = new IsAuthorizedRequest();
		isAuthorizedRequest.setUsername(auth.getName());
		isAuthorizedRequest.setAuthority(authority);

		return authorizationService.isAuthorized(isAuthorizedRequest);

	}

	@Override
	public boolean hasPermission(Authentication auth, Serializable targetId, String targetType, Object permission)
	{
		throw new UnsupportedOperationException("To be implemented!");
	}

	private Authority convertStringToAuthority(String functionOperation)
	{
		String function = functionOperation.substring(0, functionOperation.indexOf("/"));
		String operation = functionOperation.substring(functionOperation.indexOf("/") + 1, functionOperation.length());

		Authority authority = new Authority();
		authority.setFunction(function);
		authority.setOperation(operation);

		return authority;
	}
}
