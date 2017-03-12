package myapp.core.email.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

/**
 * Configuration of Email
 * 
 * @author Mate
 *
 */
@Configuration
public class EmailConfiguration
{
	private static final String SMTP_HOST = "${mail.host}";
	private static final String SMTP_PORT = "${mail.port}";
	private static final String SMTP_PROTOCOL = "${mail.protocol}";
	private static final String SMTP_USERNAME = "${mail.username}";
	private static final String SMTP_PASSWORD = "${mail.password}";
	private static final String SMTP_AUTH = "${mail.auth}";
	private static final String SUBJECT = "NOREPLY";

	@Bean
	public JavaMailSender getJavaMailSender(@Value(SMTP_HOST) String host, @Value(SMTP_PORT) int port,
			@Value(SMTP_PROTOCOL) String protocol, @Value(SMTP_USERNAME) String username,
			@Value(SMTP_PASSWORD) String password, @Value(SMTP_AUTH) String auth)
	{
		JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();

		javaMailSender.setHost(host);
		javaMailSender.setPort(port);
		javaMailSender.setProtocol(protocol);
		javaMailSender.setUsername(username);
		javaMailSender.setPassword(password);

		Properties prop = new Properties();
		prop.setProperty(auth, "true");

		javaMailSender.setJavaMailProperties(prop);

		return javaMailSender;
	}

	@Bean
	public SimpleMailMessage getSimpleMailMessage(@Value(SMTP_USERNAME) String username)
	{
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

		simpleMailMessage.setFrom(username);
		simpleMailMessage.setSubject(SUBJECT);
		return simpleMailMessage;
	}

	@Bean
	public PropertyPlaceholderConfigurer propertyPlaceholderConfigurer()
	{
		PropertyPlaceholderConfigurer configurer = new PropertyPlaceholderConfigurer();
		configurer.setLocation(new ClassPathResource("properties/mail/mail.properties"));
		return configurer;
	}

}
