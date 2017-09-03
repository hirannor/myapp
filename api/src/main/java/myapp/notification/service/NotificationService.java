package myapp.notification.service;

import myapp.notification.service.bean.NotificationSendRequest;
import myapp.user.bean.User;

/**
 * Custom NotificationService API
 * 
 * @author Mate
 * 
 */
public interface NotificationService
{
	/**
	 * This method send an email to a customer, if an admin edit the selected
	 * customer's details
	 * 
	 * @param customer {@link User}
	 */
	void sendEditNotification(User customer);

	/**
	 * This method send an email to the registered customer with hes details
	 * 
	 * @param customer {@link User}
	 */
	void registrationNotification(User customer);

	/**
	 * Method for sending email
	 * 
	 * @param request {@link NotificationSendRequest}
	 */
	void sendEmail(NotificationSendRequest request);

	/**
	 * Method for sending reset password notification with newly generated
	 * password
	 * 
	 * @param toEmail {@link String}
	 * @param newPassword {@link String}
	 */
	void resetPasswordNotification(String toEmail, String newPassword);

}
