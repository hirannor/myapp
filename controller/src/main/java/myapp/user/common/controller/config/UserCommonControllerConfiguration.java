package myapp.user.common.controller.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import myapp.user.common.controller.UserCommonController;
import myapp.user.common.controller.UserCommonControllerImpl;
import myapp.user.common.facade.UserCommonFacade;

/**
 * Configuration for UserCommonController
 * 
 * @author Mate
 *
 */
@Configuration
public class UserCommonControllerConfiguration
{
	@Bean
	public UserCommonController getUserCommonController(UserCommonFacade customerCommonFacade)
	{
		return new UserCommonControllerImpl(customerCommonFacade);
	}
}
