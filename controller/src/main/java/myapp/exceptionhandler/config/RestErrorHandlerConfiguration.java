package myapp.exceptionhandler.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import myapp.exceptionhandler.RestErrorHandler;

/**
 * Configuration class of RestErrorHandler
 * 
 * @author Mate
 *
 */
@Configuration
public class RestErrorHandlerConfiguration
{
	@Bean
	public RestErrorHandler getRestErrorHandler()
	{
		return new RestErrorHandler();
	}
}
