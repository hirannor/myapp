package myapp.personalsettings.facade.impl;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import myapp.core.authorization.annotation.Function;
import myapp.core.authorization.annotation.Operation;
import myapp.personalsettings.facade.PersonalSettingsFacade;
import myapp.personalsettings.facade.bean.PersonalInformationsReply;
import myapp.user.management.service.bean.GetUserServiceResponse;
import myapp.user.service.UserService;

@Function(name = PersonalSettingsFacadeImpl.FUNCTION)
public class PersonalSettingsFacadeImpl implements PersonalSettingsFacade
{
	protected final static String FUNCTION = "personalsettings";
	protected final static String OPERATION_VIEW = "view";

	private UserService customerService;

	public PersonalSettingsFacadeImpl(UserService customerService)
	{
		this.customerService = customerService;
	}

	@Override
	@Operation(name = OPERATION_VIEW)
	public PersonalInformationsReply getPersonalInformations()
	{
		PersonalInformationsReply reply = new PersonalInformationsReply();
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		GetUserServiceResponse getUserServiceResponse = customerService.getUser(authentication.getName());
		
		reply.setUserDetails(getUserServiceResponse.getUser());
		
		return reply;
	}
}
