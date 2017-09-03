package myapp.core.authentication.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.fasterxml.jackson.databind.ObjectMapper;

import myapp.core.authentication.exception.AuthenticationMethodNotSupportedException;
import myapp.core.authentication.userdetails.bean.LoginRequest;
import myapp.core.authentication.validator.AuthenticationValidator;

/**
 * Custom AuthenticationProcessingFilter implementation
 * 
 * @author Mate
 *
 */
public class CustomLoginProcessingFilter extends AbstractAuthenticationProcessingFilter
{
	private final ObjectMapper objectMapper;
	private AuthenticationSuccessHandler successHandler;
	private AuthenticationFailureHandler failureHandler;

	public CustomLoginProcessingFilter(String defaultProcessUrl, AuthenticationSuccessHandler successHandler,
			AuthenticationFailureHandler failureHandler, ObjectMapper objectMapper)
	{
		super(defaultProcessUrl);
		this.objectMapper = objectMapper;
		this.successHandler = successHandler;
		this.failureHandler = failureHandler;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException
	{
		validateRequest(request);

		LoginRequest loginRequest = deserializeCredentials(request);

		validateCredentials(loginRequest);

		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),
				loginRequest.getPassword());

		return this.getAuthenticationManager().authenticate(token);
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException
	{
		successHandler.onAuthenticationSuccess(request, response, authResult);
	}

	@Override
	protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException failed) throws IOException, ServletException
	{
		SecurityContextHolder.clearContext();
		failureHandler.onAuthenticationFailure(request, response, failed);
	}

	private LoginRequest deserializeCredentials(final HttpServletRequest request)
	{
		LoginRequest loginRequest = null;

		try
		{
			loginRequest = objectMapper.readValue(request.getReader(), LoginRequest.class);
		} catch (Exception deserializeException)
		{
			throw new BadCredentialsException("JSON with credentials was not informed.");
		}

		return loginRequest;
	}

	private void validateRequest(final HttpServletRequest request)
	{
		if (!AuthenticationValidator.isValidPreAuthenticationRequest(request))
		{
			throw new AuthenticationMethodNotSupportedException("Authentication Method not supported!");
		}
	}

	private void validateCredentials(LoginRequest loginRequest)
	{
		if (StringUtils.isBlank(loginRequest.getUsername()) || StringUtils.isBlank(loginRequest.getPassword()))
		{
			throw new AuthenticationServiceException("Username or Password not provided");
		}
	}

}