package myapp.core.authentication.provider;

import java.util.Arrays;

import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import myapp.core.authentication.dao.AuthenticationDao;
import myapp.core.authentication.exception.AccountIsDisabledException;
import myapp.core.authentication.userdetails.bean.UserInfo;

/**
 * Custom AuthenticationProvider Implementation
 * 
 * @author Mate
 *
 */
@Component
public class AuthenticationProviderImpl implements AuthenticationProvider
{
	private AuthenticationDao authenticationDao;
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public AuthenticationProviderImpl(AuthenticationDao authenticationDao, BCryptPasswordEncoder bCryptPasswordEncoder)
	{
		this.authenticationDao = authenticationDao;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException
	{
		String username = (String) authentication.getPrincipal();
		String rawPassword = (String) authentication.getCredentials();

		UserInfo userInfo = authenticationDao.getUserInfo(username);
		if (userInfo == null)
		{
			throw new AuthenticationCredentialsNotFoundException("No credentials found in context");
		}
		if (!isPasswordMatches(rawPassword, userInfo.getPassword()))
		{
			throw new BadCredentialsException("Authentication Failed. Username or Password not valid.");
		}
		if (userInfo.getRole() == null)
		{
			throw new InsufficientAuthenticationException("User has no roles assigned");
		}
		if(!userInfo.isEnabled())
		{
			throw new AccountIsDisabledException("Account is parmanently disabled!");
		}
		GrantedAuthority authority = new SimpleGrantedAuthority(userInfo.getRole());

		SecurityContextHolder.getContext().setAuthentication(authentication);
		return new UsernamePasswordAuthenticationToken(username, null, Arrays.asList(authority));
	}

	@Override
	public boolean supports(Class<?> authentication)
	{
		return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
	}

	private boolean isPasswordMatches(String rawPassword, String encodedPassword)
	{
		return bCryptPasswordEncoder.matches(rawPassword, encodedPassword);
	}

}
