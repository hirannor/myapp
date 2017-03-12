package myapp.email.service;

import myapp.customer.bean.Customer;
import myapp.email.service.bean.EmailSendRequest;

/**
 * Custom EmailService API
 * 
 * @author Mate
 * 
 */
public interface EmailService
{
	/**
	 * This method send an email to a customer, if an admin edit the selected
	 * customer's details
	 * 
	 * @param customer {@link Customer}
	 */
	void sendEditNotification(Customer customer);

	/**
	 * This method send an email to the registered customer with hes details
	 * 
	 * @param customer {@link Customer}
	 */
	void registrationNotification(Customer customer);

	/**
	 * Method for sending email
	 * 
	 * @param request {@link EmailSendRequest}
	 */
	void sendEmail(EmailSendRequest request);

	/**
	 * Method for sending reset password notification with newly generated
	 * password
	 * 
	 * @param toEmail {@link String}
	 * @param newPassword {@link String}
	 */
	void resetPasswordNotification(String toEmail, String newPassword);

}
