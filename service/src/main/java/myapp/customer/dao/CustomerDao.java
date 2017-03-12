package myapp.customer.dao;

import myapp.customer.bean.Customer;

/**
 * Customer DAO
 * 
 * @author Mate
 *
 */
public interface CustomerDao
{
	/**
	 * Method for retrieving customer details from database
	 * 
	 * @param username {@link String}
	 * @return @{link Customer}
	 */
	Customer getCustomer(String username);
}
