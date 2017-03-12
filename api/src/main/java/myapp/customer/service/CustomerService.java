package myapp.customer.service;

import myapp.customer.management.service.bean.GetCustomerServiceResponse;

/**
 * CustomerService API
 * 
 * @author Mate
 *
 */
public interface CustomerService
{
	String DEFAULT_ROLE = "CUSTOMER";

	/**
	 * Method for getting customer details
	 * 
	 * @param username {@link String}
	 * @return @{link GetCustomerServiceResponse}
	 * @throws CustomerNotFoundException
	 */
	GetCustomerServiceResponse getCustomer(String username);

}
