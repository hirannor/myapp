package myapp.core.exception.handler.resolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * This HandlerExceptionResolver implementation handles @{link
 * IllegalArgumentException} exception
 * 
 * @author Mate
 *
 */
@Component
public class IllegalArgumentExceptionHandlerExceptionResolver implements HandlerExceptionResolver
{
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object obj,
			Exception exception)
	{
		if (exception instanceof IllegalArgumentException)
		{
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.setContentType(MediaType.APPLICATION_JSON_VALUE);
		}
		return null;
	}
}
