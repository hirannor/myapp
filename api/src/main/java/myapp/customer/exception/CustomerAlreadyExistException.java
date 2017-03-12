package myapp.customer.exception;

import myapp.message.exception.DefaultMessageException;

/**
 * CustomerAlreadyExistException exception
 * 
 * @author Mate
 *
 */
public class CustomerAlreadyExistException extends DefaultMessageException
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomerAlreadyExistException(String message)
	{
		super(message);
	}

}
