package myapp.core.authentication.entrypoint;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Custom Authentication Entrypoint Implementation
 * 
 * @author Mate
 *
 */
@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint
{
	private ObjectMapper objectMapper;

	public CustomAuthenticationEntryPoint(ObjectMapper objectMapper)
	{
		this.objectMapper = objectMapper;
	}

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException
	{
		Map<String, String> map = new HashMap<String, String>();

		map.put("success", "false");
		map.put("message", "You dont have rights to view this page. :(");

		response.setStatus(HttpStatus.FORBIDDEN.value());
		response.setContentType(MediaType.APPLICATION_JSON_VALUE);
		objectMapper.writeValue(response.getWriter(), map);
	}
}
