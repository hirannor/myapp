package myapp.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import myapp.common.service.CommonService;
import myapp.common.service.bean.RegistrateRequest;
import myapp.common.service.bean.ResetPasswordRequest;
import myapp.core.bean.JsonReply;
import myapp.message.exception.DefaultMessageException;

/**
 * CommonController
 * 
 * @author Mate
 *
 */
@Controller
public class CommonController
{
	private CommonService commonService;

	public CommonController(CommonService commonService)
	{
		this.commonService = commonService;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcomePage()
	{
		return "index";
	}

	@RequestMapping(value = "registrate", method = RequestMethod.POST, headers = "Accept=application/json; charset=utf-8")
	public @ResponseBody JsonReply registrate(@RequestBody RegistrateRequest request) throws DefaultMessageException
	{
		commonService.registrate(request);
		return new JsonReply();
	}

	@RequestMapping(value = "resetPassword", method = RequestMethod.POST, headers = "Accept=application/json; charset=utf-8")
	public @ResponseBody JsonReply resetPassword(@RequestBody ResetPasswordRequest request)
			throws DefaultMessageException
	{
		commonService.resetPassword(request);
		return new JsonReply();
	}
}
