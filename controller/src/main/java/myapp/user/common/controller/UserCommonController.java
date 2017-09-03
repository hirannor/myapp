package myapp.user.common.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import myapp.core.bean.JsonReply;
import myapp.message.exception.DefaultMessageException;
import myapp.user.common.service.bean.RegistrateRequest;
import myapp.user.common.service.bean.ResetPasswordRequest;

@RestController
public interface UserCommonController
{
	@RequestMapping(value = "/", method = RequestMethod.GET)
	String welcomePage();

	@RequestMapping(value = "registrate", method = RequestMethod.POST)
	@ResponseBody
	JsonReply registrate(@RequestBody RegistrateRequest request) throws DefaultMessageException;

	@RequestMapping(value = "resetPassword", method = RequestMethod.POST)
	@ResponseBody
	JsonReply resetPassword(@RequestBody ResetPasswordRequest request) throws DefaultMessageException;
}
