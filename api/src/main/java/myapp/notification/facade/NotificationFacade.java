package myapp.notification.facade;

import myapp.notification.service.bean.NotificationSendRequest;

/**
 * Custom NotificationFacade API
 * 
 * @author Mate
 * 
 */
public interface NotificationFacade
{
	/**
	 * Method for sending email
	 * 
	 * @param request {@link NotificationSendRequest}
	 */
	void sendEmail(NotificationSendRequest request);


}
