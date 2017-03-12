package myapp.customer.controller.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import myapp.customer.controller.CustomerController;
import myapp.customer.service.CustomerService;

/**
 * Configuration for CustomerController
 * 
 * @author Mate
 *
 */
@Configuration
public class CustomerControllerConfiguration
{
	@Bean
	public CustomerController getCustomerController(CustomerService customerService)
	{
		return new CustomerController(customerService);
	}
}
