package myapp.notification.controller.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import myapp.notification.controller.NotificationController;
import myapp.notification.controller.NotificationControllerImpl;
import myapp.notification.facade.NotificationFacade;

@Configuration
public class NotificationControllerConfiguration
{
	@Bean
	public NotificationController getNotificationController(NotificationFacade notificationFacade)
	{
		return new NotificationControllerImpl(notificationFacade);
	}
}
