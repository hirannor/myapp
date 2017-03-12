package myapp.notification.controller.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import myapp.email.service.EmailService;
import myapp.notification.controller.NotificationController;

@Configuration
public class NotificationControllerConfiguration
{

	@Bean
	public NotificationController getNotificationController(EmailService emailService)
	{
		return new NotificationController(emailService);
	}

}
