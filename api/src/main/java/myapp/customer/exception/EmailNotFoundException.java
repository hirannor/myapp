package myapp.customer.exception;

import myapp.message.exception.DefaultMessageException;

/**
 * EmailNotFoundException exception
 * 
 * @author Mate
 *
 */
public class EmailNotFoundException extends DefaultMessageException
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public EmailNotFoundException(String message)
    {
	super(message);
    }

}
