package myapp.user.common.facade;

import myapp.user.common.service.bean.RegistrateRequest;
import myapp.user.common.service.bean.ResetPasswordRequest;
import myapp.user.exception.EmailNotFoundException;
import myapp.user.exception.UserAlreadyExistException;

/**
 * CommonFacade API
 * 
 * @author Mate
 *
 */
public interface UserCommonFacade
{
	/**
	 * Method for customer registration
	 * 
	 * @param registrateRequest{@link RegistrateRequest}
	 * @throws {@link UserAlreadyExistException}
	 */
	void registrate(RegistrateRequest registrateRequest) throws UserAlreadyExistException;

	/**
	 * Method for reset password
	 * 
	 * @param resetPassword {@link ResetPasswordRequest}
	 * @throws {@link EmailNotFoundException}
	 */
	void resetPassword(ResetPasswordRequest resetPasswordRequest) throws EmailNotFoundException;

}
