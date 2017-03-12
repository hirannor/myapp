package myapp.customer.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import myapp.core.bean.Role;
import myapp.customer.management.service.bean.GetCustomerServiceResponse;
import myapp.customer.service.CustomerService;

/**
 * Controller class of Customer role
 * 
 * @author Mate
 *
 */
@Controller
@Secured(Role.CUSTOMER)
@RequestMapping(value = "/customer/")
public class CustomerController
{
	private CustomerService customerService;

	public CustomerController(CustomerService customerService)
	{
		if (customerService == null)
		{
			throw new IllegalArgumentException(customerService + " Bean creation error!");
		}
		this.customerService = customerService;
	}

	@RequestMapping(value = "authenticatedUser", method = RequestMethod.POST, headers = "Accept=application/json; charset=utf-8")
	public @ResponseBody GetCustomerServiceResponse getAuthenticatedUser()
	{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return customerService.getCustomer(authentication.getName());
	}
}
