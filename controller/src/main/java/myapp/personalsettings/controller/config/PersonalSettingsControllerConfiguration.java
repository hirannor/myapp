package myapp.personalsettings.controller.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import myapp.personalsettings.controller.PersonalSettingsController;
import myapp.personalsettings.controller.PersonalSettingsControllerImpl;
import myapp.personalsettings.facade.PersonalSettingsFacade;

@Configuration
public class PersonalSettingsControllerConfiguration
{
	@Bean
	public PersonalSettingsController getPersonalSettingsController(PersonalSettingsFacade pesonalSettingsFacade)
	{
		return new PersonalSettingsControllerImpl(pesonalSettingsFacade);
	}

}
