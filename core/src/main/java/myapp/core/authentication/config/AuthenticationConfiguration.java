package myapp.core.authentication.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import com.fasterxml.jackson.databind.ObjectMapper;

import myapp.core.authentication.dao.AuthenticationDao;
import myapp.core.authentication.dao.impl.AuthenticationDaoImpl;
import myapp.core.authentication.dao.mapper.AuthenticationMapper;
import myapp.core.authentication.entrypoint.CustomAuthenticationEntryPoint;
import myapp.core.authentication.handler.CustomAuthenticationFailureHandler;
import myapp.core.authentication.handler.CustomAuthenticationSuccessHandler;
import myapp.core.authentication.handler.CustomLogoutSuccesHandler;
import myapp.core.authentication.provider.AuthenticationProviderImpl;

/**
 * Configuration class for Authentication
 * 
 * @author Mate
 *
 */
@Configuration
public class AuthenticationConfiguration
{
	@Bean
	public AuthenticationDao getAuthenticationDao(AuthenticationMapper authenticationMapper)
	{
		return new AuthenticationDaoImpl(authenticationMapper);
	}

	@Bean
	public AuthenticationMapper getAuthenticationMapper(SqlSessionFactory sqlSessionFactory) throws Exception
	{
		SqlSessionTemplate sessionTemplate = new SqlSessionTemplate(sqlSessionFactory);
		return sessionTemplate.getMapper(AuthenticationMapper.class);
	}

	@Bean
	public AuthenticationProvider authenticationProvider(AuthenticationDao authenticationDao)
	{
		return new AuthenticationProviderImpl(authenticationDao, passwordEncoder());
	}

	@Bean
	public AuthenticationFailureHandler authenticationFailureHandler()
	{
		return new CustomAuthenticationFailureHandler(getObjectMapper());
	}

	@Bean
	public AuthenticationSuccessHandler authenticationSuccessHandler()
	{
		return new CustomAuthenticationSuccessHandler(getObjectMapper());
	}

	@Bean
	public LogoutSuccessHandler logoutSuccessHandler()
	{
		return new CustomLogoutSuccesHandler(getObjectMapper());
	}

	@Bean
	public AuthenticationEntryPoint authenticationEntryPoint()
	{
		return new CustomAuthenticationEntryPoint(getObjectMapper());
	}

	@Bean
	public ObjectMapper getObjectMapper()
	{
		return new ObjectMapper();
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder(10);
	}
}
