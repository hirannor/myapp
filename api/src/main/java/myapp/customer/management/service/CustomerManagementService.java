package myapp.customer.management.service;

import myapp.customer.management.service.bean.ChangeStatusRequest;
import myapp.customer.management.service.bean.CustomerDeleteServiceRequest;
import myapp.customer.management.service.bean.CustomerEditServiceRequest;
import myapp.customer.management.service.bean.GetCustomerListServiceReply;

/**
 * CustomerManagementService API
 * 
 * @author Mate
 *
 */
public interface CustomerManagementService
{
	/**
	 * Method for retrieving customers
	 * 
	 * @return {@link GetCustomerListServiceReply}
	 */
	GetCustomerListServiceReply getCustomerList();

	/**
	 * Method for deleting customer by Id
	 * 
	 * @param request {@link CustomerDeleteServiceRequest}
	 */
	void deleteCustomerById(CustomerDeleteServiceRequest request);

	/**
	 * Method for editing customer
	 * 
	 * @param request {@link CustomerEditServiceRequest}
	 */
	void editCustomer(CustomerEditServiceRequest request);

	/**
	 * Method for changing account status of customer
	 * 
	 * @param request {@link ChangeStatusRequest}
	 */
	void changeAccountStatus(ChangeStatusRequest request);
}
