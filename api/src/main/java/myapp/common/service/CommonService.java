package myapp.common.service;

import myapp.common.service.bean.RegistrateRequest;
import myapp.common.service.bean.ResetPasswordRequest;
import myapp.customer.exception.CustomerAlreadyExistException;
import myapp.customer.exception.EmailNotFoundException;

/**
 * CommonService API
 * 
 * @author Mate
 *
 */
public interface CommonService
{
	/**
	 * Method for customer registration
	 * 
	 * @param registrateRequest{@link RegistrateRequest}
	 * @throws {@link CustomerAlreadyExistException}
	 */
	void registrate(RegistrateRequest registrateRequest) throws CustomerAlreadyExistException;

	/**
	 * Method for reset password
	 * 
	 * @param resetPassword {@link ResetPasswordRequest}
	 * @throws {@link EmailNotFoundException}
	 */
	void resetPassword(ResetPasswordRequest resetPasswordRequest) throws EmailNotFoundException;

}
