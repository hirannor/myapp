package myapp.customermanagement.controller.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import myapp.customer.management.service.CustomerManagementService;
import myapp.customermanagement.controller.CustomerManagementController;

/**
 * 
 * @author Mate
 *
 */
@Configuration
public class CustomerManagementControllerConfiguration
{
	@Bean
	public CustomerManagementController getCustomerManagementController(
			CustomerManagementService customerManagementService)
	{
		return new CustomerManagementController(customerManagementService);
	}
}
