package myapp.core.authentication.handler;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import myapp.core.bean.AuthenticaionSuccessReply;

/**
 * Custom Authentication Success Handler Implementation
 * 
 * @author Mate
 *
 */
@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler
{
	private ObjectMapper objectMapper;

	public CustomAuthenticationSuccessHandler(ObjectMapper objectMapper)
	{
		this.objectMapper = objectMapper;
	}

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException
	{
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

		AuthenticaionSuccessReply reply = new AuthenticaionSuccessReply();
		reply.setMessage("Logging in was successfull!");
		reply.setAuthority(authorities.toArray()[0].toString());

		response.setStatus(HttpStatus.OK.value());
		response.setContentType(MediaType.APPLICATION_JSON_VALUE);
		objectMapper.writeValue(response.getWriter(), reply);

		request.getSession().setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY,
				SecurityContextHolder.getContext());
	}
}
