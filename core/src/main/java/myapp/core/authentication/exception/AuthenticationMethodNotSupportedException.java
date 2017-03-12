package myapp.core.authentication.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * AuthenticationMethodNotSupportedException exception
 * 
 * @author Mate
 *
 */
public class AuthenticationMethodNotSupportedException extends AuthenticationException
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3777959180507533071L;

	public AuthenticationMethodNotSupportedException(String message)
	{
		super(message);
	}
}
