package myapp.user.management.dao;

import java.util.List;

import myapp.user.bean.User;
import myapp.user.management.service.bean.ChangeStatusRequest;

/**
 * UserManagement DAO
 * 
 * @author Mate
 *
 */
public interface UserManagementDao
{
	/**
	 * Method for retrieving Users from database
	 * 
	 * @return a list of {@link User}-s
	 */
	List<User> getUserList();

	/**
	 * Method for deleting user auth from database by Id
	 * 
	 * @param id
	 */
	void deleteUsrAuthById(int id);

	/**
	 * Method for deleting Users from database by Id
	 * 
	 * @param id
	 */
	void deleteUserById(int id);

	/**
	 * Method for editing Users in database
	 * 
	 * @param customer {@link User}
	 * @return {@Integer} affected record
	 */
	Integer editUser(User user);

	/**
	 * Method for changing account status of User
	 * 
	 * @param request {@link ChangeStatusRequest}
	 */
	void changeAccountStatus(ChangeStatusRequest request);

}
