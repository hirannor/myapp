package myapp.user.exception;

import myapp.message.exception.DefaultMessageException;

/**
 * UserAlreadyExistException exception
 * 
 * @author Mate
 *
 */
public class UserAlreadyExistException extends DefaultMessageException
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserAlreadyExistException(String message)
	{
		super(message);
	}

}
