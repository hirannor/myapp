package myapp.notification.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import myapp.notification.facade.NotificationFacade;
import myapp.notification.facade.impl.NotificationFacadeImpl;
import myapp.notification.service.NotificationService;
import myapp.notification.service.impl.NotificationServiceImpl;

@Configuration
public class NotificationConfiguration
{
	@Bean
	public NotificationService getNotificationService(JavaMailSender javaMailSender, SimpleMailMessage simpleMailMessage)
	{
		return new NotificationServiceImpl(javaMailSender, simpleMailMessage);
	}
	
	@Bean
	public NotificationFacade getNotificationFacade()
	{
		return new NotificationFacadeImpl(getNotificationService(null, null));
	}
}
