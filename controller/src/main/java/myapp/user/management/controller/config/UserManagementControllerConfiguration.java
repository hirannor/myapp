package myapp.user.management.controller.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import myapp.user.management.controller.UserManagementController;
import myapp.user.management.controller.UserManagementControllerImpl;
import myapp.user.management.facade.UserManagementFacade;

/**
 * 
 * @author Mate
 *
 */
@Configuration
public class UserManagementControllerConfiguration
{
	@Bean
	public UserManagementController getUserManagementController(UserManagementFacade userManagementFacade)
	{
		return new UserManagementControllerImpl(userManagementFacade);
	}
}
