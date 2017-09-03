package myapp.user.service;

import myapp.user.common.service.bean.RegistrateRequest;
import myapp.user.common.service.bean.ResetPasswordReply;
import myapp.user.common.service.bean.ResetPasswordRequest;
import myapp.user.exception.EmailNotFoundException;
import myapp.user.exception.UserAlreadyExistException;
import myapp.user.management.service.bean.GetUserServiceResponse;

/**
 * UserService API
 * 
 * @author Mate
 *
 */
public interface UserService
{
	String DEFAULT_ROLE = "CUSTOMER";

	/**
	 * Method for getting user details
	 * 
	 * @param username {@link String}
	 * @return @{link GetUserServiceResponse}
	 * @throws UserNotFoundException
	 */
	GetUserServiceResponse getUser(String username);
	
	/**
	 * Method for user registration
	 * 
	 * @param registrateRequest {@link RegistrateRequest}
	 * @throws {@link UserAlreadyExistException}
	 */
	void registrate(RegistrateRequest registrateRequest) throws UserAlreadyExistException;

	/**
	 * Method for reset password
	 * 
	 * @param resetPassword {@link ResetPasswordRequest}
	 * @throws {@link EmailNotFoundException}
	 */
	ResetPasswordReply resetPassword(ResetPasswordRequest resetPasswordRequest) throws EmailNotFoundException;

}