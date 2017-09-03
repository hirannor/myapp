package myapp.core.authentication.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import myapp.core.bean.JsonReply;

/**
 * Custom Authentication Failure Handler Implementation
 * 
 * @author Mate
 *
 */
@Component
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler
{
	private ObjectMapper objectMapper;

	public CustomAuthenticationFailureHandler(ObjectMapper objectMapper)
	{
		this.objectMapper = objectMapper;
	}

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException
	{
		if (exception instanceof AuthenticationException)
		{

			JsonReply reply = new JsonReply();
			reply.setMessage(exception.getMessage());
			reply.setSuccess(false);

			response.setStatus(HttpStatus.UNAUTHORIZED.value());
			response.setContentType(MediaType.APPLICATION_JSON_VALUE);
			objectMapper.writeValue(response.getWriter(), reply);
		}
	}
}
