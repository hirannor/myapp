package myapp.customer.management.dao;

import java.util.List;

import myapp.customer.bean.Customer;
import myapp.customer.management.service.bean.ChangeStatusRequest;

/**
 * CustomerManagement DAO
 * 
 * @author Mate
 *
 */
public interface CustomerManagementDao
{
	/**
	 * Method for retrieving customers from database
	 * 
	 * @return a list of {@link Customer}-s
	 */
	List<Customer> getCustomerList();

	/**
	 * Method for deleting user auth from database by Id
	 * 
	 * @param id
	 */
	void deleteUsrAuthById(int id);

	/**
	 * Method for deleting user role from database by Id
	 * 
	 * @param id
	 */
	void deleteUsrRoleById(int id);

	/**
	 * Method for deleting customers from database by Id
	 * 
	 * @param id
	 */
	void deleteCustomerById(int id);

	/**
	 * Method for editing customers in database
	 * 
	 * @param customer {@link Customer}
	 * @return {@Integer} affected record
	 */
	Integer editCustomer(Customer customer);

	/**
	 * Method for changing account status of customer
	 * 
	 * @param request {@link ChangeStatusRequest}
	 */
	void changeAccountStatus(ChangeStatusRequest request);

}
