package myapp.core.authentication.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import myapp.core.bean.JsonReply;

/**
 * Custom Logout Success Handler Implementation
 * 
 * @author Mate
 *
 */
@Component
public class CustomLogoutSuccesHandler implements LogoutSuccessHandler
{
	private ObjectMapper objectMapper;

	public CustomLogoutSuccesHandler(ObjectMapper objectMapper)
	{
		this.objectMapper = objectMapper;
	}

	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException
	{

		JsonReply reply = new JsonReply();
		reply.setMessage("Loging out was successfull!");

		response.setStatus(HttpStatus.OK.value());
		response.setContentType(MediaType.APPLICATION_JSON_VALUE);
		objectMapper.writeValue(response.getWriter(), reply);
	}
}
