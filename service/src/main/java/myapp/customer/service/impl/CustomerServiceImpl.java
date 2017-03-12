package myapp.customer.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import myapp.customer.dao.CustomerDao;
import myapp.customer.management.service.bean.GetCustomerServiceResponse;
import myapp.customer.service.CustomerService;

/**
 * CustomerService Implementation
 * 
 * @author Mate
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService
{
	private static final Logger LOGGER = LogManager.getLogger("hu.uni.miskolc.iit.customer.management.service.impl");

	private CustomerDao customerDao;

	public CustomerServiceImpl(CustomerDao customerDao)
	{
		this.customerDao = customerDao;
	}

	@Override
	public GetCustomerServiceResponse getCustomer(String username)
	{
		GetCustomerServiceResponse response = new GetCustomerServiceResponse();
		response.setCustomer(customerDao.getCustomer(username));

		return response;
	}

}
