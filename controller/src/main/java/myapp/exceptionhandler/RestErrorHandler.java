package myapp.exceptionhandler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import myapp.core.bean.JsonReply;
import myapp.message.exception.DefaultMessageException;

/**
 * RestErrorHandler class
 * 
 * @author Mate
 *
 */
@ControllerAdvice
public class RestErrorHandler
{
	@ExceptionHandler(DefaultMessageException.class)
	public @ResponseBody JsonReply errorHandling(DefaultMessageException ex)
	{
		JsonReply reply = new JsonReply();
		reply.setMessage(ex.getMessage());
		reply.setSuccess(false);

		return reply;
	}
}
