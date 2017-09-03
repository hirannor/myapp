package myapp.user.dao;

import myapp.user.bean.User;
import myapp.user.common.service.bean.RegistrateRequest;

/**
 * User DAO
 * 
 * @author Mate
 *
 */
public interface UserDao
{
	/**
	 * Method for retrieving User details from database
	 * 
	 * @param username {@link String}
	 * @return @{link Customer}
	 */
	User getUser(String username);
	
	/**
	 * Method for retrieving inserting User details
	 * 
	 * @param username {@link String}
	 * @return @{link Integer} affected record
	 */
	Integer insertUser(RegistrateRequest registrateRequest);

	/**
	 * Method for inserting User credentials
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
