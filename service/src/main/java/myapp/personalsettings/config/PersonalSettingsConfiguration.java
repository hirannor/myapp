package myapp.personalsettings.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import myapp.personalsettings.facade.PersonalSettingsFacade;
import myapp.personalsettings.facade.impl.PersonalSettingsFacadeImpl;
import myapp.user.service.UserService;

@Configuration
public class PersonalSettingsConfiguration
{
	@Bean
	public PersonalSettingsFacade getPersonalSettingsFacade(UserService customerService)
	{
		return new PersonalSettingsFacadeImpl(customerService);
	}
}
