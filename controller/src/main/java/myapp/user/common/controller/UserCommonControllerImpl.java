package myapp.user.common.controller;

import org.springframework.web.bind.annotation.RequestBody;

import myapp.core.bean.JsonReply;
import myapp.message.exception.DefaultMessageException;
import myapp.user.common.facade.UserCommonFacade;
import myapp.user.common.service.bean.RegistrateRequest;
import myapp.user.common.service.bean.ResetPasswordRequest;

/**
 * UserCommonControllerImpl
 * 
 * @author Mate
 *
 */
public class UserCommonControllerImpl implements UserCommonController
{
	private UserCommonFacade userCommonFacade;

	public UserCommonControllerImpl(UserCommonFacade userCommonFacade) 
	{
		this.userCommonFacade = userCommonFacade;
	}

	public String welcomePage()
	{
		return "index";
	}

	public JsonReply registrate(@RequestBody RegistrateRequest request) throws DefaultMessageException
	{
		userCommonFacade.registrate(request);
		return new JsonReply();
	}

	public JsonReply resetPassword(ResetPasswordRequest request) throws DefaultMessageException
	{
		userCommonFacade.resetPassword(request);
		return new JsonReply();
	}
}
