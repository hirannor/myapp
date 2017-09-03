package myapp.personalsettings.controller;

import myapp.personalsettings.facade.PersonalSettingsFacade;
import myapp.personalsettings.facade.bean.PersonalInformationsReply;

public class PersonalSettingsControllerImpl implements PersonalSettingsController
{
	private PersonalSettingsFacade pesonalSettingsFacade;
	
	public PersonalSettingsControllerImpl(PersonalSettingsFacade pesonalSettingsFacade)
	{
		this.pesonalSettingsFacade = pesonalSettingsFacade;
	}

	public PersonalInformationsReply getPersonalInformations()
	{
		return pesonalSettingsFacade.getPersonalInformations();
	}
}
