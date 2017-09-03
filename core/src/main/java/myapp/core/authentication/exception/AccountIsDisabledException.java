package myapp.core.authentication.exception;

import org.springframework.security.core.AuthenticationException;

public class AccountIsDisabledException extends AuthenticationException
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2123726145540100816L;

	public AccountIsDisabledException(String message)
	{
		super(message);
	}
}
