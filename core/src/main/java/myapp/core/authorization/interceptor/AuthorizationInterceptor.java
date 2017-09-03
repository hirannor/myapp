package myapp.core.authorization.interceptor;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StopWatch;

import myapp.core.authorization.annotation.Function;
import myapp.core.authorization.annotation.Operation;
import myapp.core.authorization.exception.AuthorizationException;

public class AuthorizationInterceptor implements MethodInterceptor
{
	private static final Logger LOGGER = LogManager.getLogger(AuthorizationInterceptor.class);

	private PermissionEvaluator permissionEvaluator;

	public AuthorizationInterceptor(PermissionEvaluator permissionEvaluator) {
		this.permissionEvaluator = permissionEvaluator;
	}

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable
	{
		final StopWatch stopWatch = new StopWatch(invocation.getMethod().toGenericString());
		stopWatch.start("invocation.proceed()");

		try
		{
			Method method = invocation.getMethod();
			Function functionAnnotation = invocation.getThis().getClass().getAnnotation(Function.class);

			if (functionAnnotation.checkAuthorization() == false)
			{
				return invocation.proceed();
			}

			String functionName = functionAnnotation.name();
			String operationName = method.getAnnotation(Operation.class).name();
			String functionOperation = functionName + "/" + operationName;

			LOGGER.info("Checking authorization for: {}", functionOperation.toString());

			boolean hasPermission = permissionEvaluator
					.hasPermission(SecurityContextHolder.getContext().getAuthentication(), null, functionOperation);

			LOGGER.info("isAuthorized: {} for {} ", hasPermission, functionOperation.toString());

			if (!hasPermission)
			{
				throw new AuthorizationException("Access denied for operation: " + operationName);
			}
			return invocation.proceed();
		} 
		finally
		{
			stopWatch.stop();
		}
	}
}
