package myapp.user.management.dao.mapper;

import java.util.List;

import myapp.user.bean.User;
import myapp.user.management.service.bean.ChangeStatusRequest;

/**
 * UserManagementMapper Interface
 * 
 * @author Mate
 *
 */
public interface UserManagementMapper
{
	/**
	 * @return
	 */
	List<User> getUserList();

	/**
	 * @param id
	 */
	void deleteUserById(int id);

	/**
	 * @param id
	 */
	void deleteUsrAuthById(int id);

	/**
	 * @param user
	 */
	Integer editUser(User user);

	/**
	 * @param request
	 */
	void changeAccountStatus(ChangeStatusRequest request);
}
