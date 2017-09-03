package myapp.user.dao.mapper;

import org.apache.ibatis.annotations.Param;

import myapp.user.bean.User;
import myapp.user.common.service.bean.RegistrateRequest;

/**
 * UserMapper Interface
 * 
 * @author Mate
 *
 */
public interface UserMapper
{
	String USERNAME = "username";
	String PASSWORD = "password";
	String ROLE = "role";
	
	User getUser(@Param(USERNAME) String username);

	Integer insertUser(RegistrateRequest registrateRequest);

	Integer insertUsrAuth(@Param(USERNAME) String username, @Param(PASSWORD) String password);

	Integer insertUsrRole(@Param(USERNAME) String username, @Param(ROLE) String role);

	Integer resetPassword(@Param("email") String email, @Param("newPassword") String newPassword);
}
