package myapp.common.dao.mapper;

import org.apache.ibatis.annotations.Param;

import myapp.common.service.bean.RegistrateRequest;

/**
 * CommonMapper Interface
 * 
 * @author Mate
 *
 */
public interface CommonMapper
{
	String USERNAME = "username";
	String PASSWORD = "password";
	String ROLE = "role";

	Integer insertCustomer(RegistrateRequest registrateRequest);

	Integer insertUsrAuth(@Param(USERNAME) String username, @Param(PASSWORD) String password);

	Integer insertUsrRole(@Param(USERNAME) String username, @Param(ROLE) String role);

	Integer resetPassword(@Param("email") String email, @Param("newPassword") String newPassword);
}
