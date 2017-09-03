package myapp.personalsettings.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import myapp.personalsettings.facade.bean.PersonalInformationsReply;

@RestController
@RequestMapping(value = "/personalsettings/")
public interface PersonalSettingsController
{
	@ResponseBody
	@RequestMapping(value = "personalinformations")
	PersonalInformationsReply getPersonalInformations();
}
