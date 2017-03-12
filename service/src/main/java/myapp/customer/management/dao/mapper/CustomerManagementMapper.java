package myapp.customer.management.dao.mapper;

import java.util.List;

import myapp.customer.bean.Customer;
import myapp.customer.management.service.bean.ChangeStatusRequest;

/**
 * CustomerManagementMapper Interface
 * 
 * @author Mate
 *
 */
public interface CustomerManagementMapper
{
	/**
	 * @return
	 */
	List<Customer> getCustomerList();

	/**
	 * @param id
	 */
	void deleteCustomerById(int id);

	/**
	 * @param id
	 */
	void deleteUsrAuthById(int id);

	/**
	 * @param id
	 */
	void deleteUsrRoleById(int id);

	/**
	 * @param customer
	 */
	Integer editCustomer(Customer customer);

	/**
	 * @param request
	 */
	void changeAccountStatus(ChangeStatusRequest request);
}
