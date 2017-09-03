package myapp.user.common.facade.impl;

import myapp.core.authorization.annotation.Function;
import myapp.notification.service.NotificationService;
import myapp.user.bean.User;
import myapp.user.common.facade.UserCommonFacade;
import myapp.user.common.service.bean.RegistrateRequest;
import myapp.user.common.service.bean.ResetPasswordReply;
import myapp.user.common.service.bean.ResetPasswordRequest;
import myapp.user.exception.EmailNotFoundException;
import myapp.user.exception.UserAlreadyExistException;
import myapp.user.service.UserService;

@Function(name = CustomerCommonFacadeImpl.FUNCTION, checkAuthorization = false)
public class CustomerCommonFacadeImpl implements UserCommonFacade
{
	protected static final String FUNCTION = "customercommon";
	
	private UserService customerService;
	private NotificationService emailService;

	public CustomerCommonFacadeImpl(UserService customerService, NotificationService emailService) {
		this.customerService = customerService;
		this.emailService = emailService;
	}

	@Override
	public void registrate(RegistrateRequest registrateRequest) throws UserAlreadyExistException
	{
		customerService.registrate(registrateRequest);
		emailService.registrationNotification(new User());
	}

	@Override
	public void resetPassword(ResetPasswordRequest resetPasswordRequest) throws EmailNotFoundException
	{
		ResetPasswordReply resetPasswordReply = customerService.resetPassword(resetPasswordRequest);
		emailService.resetPasswordNotification(resetPasswordRequest.getEmail(), resetPasswordReply.getNewPassword());
	}

}
