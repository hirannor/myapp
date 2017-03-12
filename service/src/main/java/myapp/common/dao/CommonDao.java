package myapp.common.dao;

import myapp.common.service.bean.RegistrateRequest;

/**
 * Common DAO
 * 
 * @author Mate
 *
 */
public interface CommonDao
{
	/**
	 * Method for retrieving inserting Customer details
	 * 
	 * @param username {@link String}
	 * @return @{link Integer} affected record
	 */
	Integer insertCustomer(RegistrateRequest registrateRequest);

	/**
	 * Method for inserting Customer credentials
	 * 
	 * @param username {@link String}
	 * @return @{link Integer} affected record
	 */
	Integer insertUsrAuth(String username, String password);

	/**
	 * Method for inserting Role of the registered user
	 * 
	 * @param username {@link String}
	 * @param role {@link String}
	 * @return {@link Integer} affected record
	 */
	Integer insertUsrRole(String username, String role);

	/**
	 * Method for updating password field with newly generated password
	 * 
	 * @param email {@link String}
	 * @param newPassword {@link String}
	 * @return {@link Integer}
	 */
	Integer resetPassword(String email, String newPassword);
}
