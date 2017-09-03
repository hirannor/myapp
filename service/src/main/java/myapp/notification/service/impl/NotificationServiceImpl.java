package myapp.notification.service.impl;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import myapp.notification.service.NotificationService;
import myapp.notification.service.bean.NotificationSendRequest;
import myapp.user.bean.User;

/**
 * NotificationService Implementation
 * 
 * @author Mate
 *
 */
@Service
public class NotificationServiceImpl implements NotificationService
{
	private MailSender mailSender;
	private SimpleMailMessage templateMessage;

	public NotificationServiceImpl(MailSender mailSender, SimpleMailMessage templateMessage) {
		this.mailSender = mailSender;
		this.templateMessage = templateMessage;
	}

	@Override
	public void sendEditNotification(User customer)
	{
		SimpleMailMessage msg = new SimpleMailMessage(templateMessage);
		msg.setFrom(templateMessage.getFrom());
		msg.setTo(customer.getEmail());
		msg.setSubject(templateMessage.getSubject());
		msg.setText(buildSampleModifyNotification(customer));

		mailSender.send(msg);
	}

	@Override
	public void sendEmail(NotificationSendRequest request)
	{
		SimpleMailMessage msg = new SimpleMailMessage(templateMessage);

		msg.setFrom(templateMessage.getFrom());
		msg.setTo(request.getToEmail());
		msg.setSubject(request.getSubject());
		msg.setText(request.getMessage());

		mailSender.send(msg);
	}

	@Override
	public void registrationNotification(User user)
	{
		SimpleMailMessage msg = new SimpleMailMessage(templateMessage);
		msg.setFrom(templateMessage.getFrom());
		msg.setTo(user.getEmail());
		msg.setSubject(templateMessage.getSubject());
		msg.setText(buildSampleModifyRegistrationNotification(user));

		mailSender.send(msg);
	}

	@Override
	public void resetPasswordNotification(String toEmail, String newPassword)
	{
		SimpleMailMessage msg = new SimpleMailMessage(templateMessage);

		msg.setFrom(templateMessage.getFrom());
		msg.setTo(toEmail);
		msg.setSubject("Password has been changed!");
		msg.setText(buildSampleForgotPassswordNotification(toEmail, newPassword));

		mailSender.send(msg);
	}

	private String buildSampleModifyNotification(User customer)
	{
		StringBuilder sb = new StringBuilder();

		sb.append("Dear " + customer.getName() + " your details has been changed! \n");
		sb.append("Your new details: \n");
		sb.append("Name: " + customer.getName() + "\n");
		sb.append("Age: " + customer.getAge() + "\n");
		sb.append("Email: " + customer.getEmail() + "\n\n");
		sb.append("This is an automaticly generated email.");

		return sb.toString();
	}

	private String buildSampleModifyRegistrationNotification(User customer)
	{
		StringBuilder sb = new StringBuilder();

		sb.append("Dear " + customer.getName() + " your registration was successfull! \n\n");
		sb.append("Your details: \n\n");
		sb.append("Username: " + customer.getUsername() + "\n");
		sb.append("Password: " + customer.getPassword() + "\n");
		sb.append("Name: " + customer.getName() + "\n");
		sb.append("Age: " + customer.getAge() + "\n");
		sb.append("Email: " + customer.getEmail() + "\n\n");
		sb.append("This is an automaticly generated email.");

		return sb.toString();
	}

	private String buildSampleForgotPassswordNotification(String toEmail, String newPassword)
	{
		StringBuilder sb = new StringBuilder();

		sb.append("Dear User! your password has been changed successfully! \n\n");
		sb.append("Your new password is: " + newPassword + "\n\n");
		sb.append("This is an automaticly generated email.");

		return sb.toString();
	}
}
