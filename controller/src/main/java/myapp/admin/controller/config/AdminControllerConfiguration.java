package myapp.admin.controller.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import myapp.admin.controller.AdminController;

/**
 * 
 * @author Mate
 *
 */
@Configuration
public class AdminControllerConfiguration
{
	@Bean
	public AdminController getAdminController()
	{
		return new AdminController();
	}
}
