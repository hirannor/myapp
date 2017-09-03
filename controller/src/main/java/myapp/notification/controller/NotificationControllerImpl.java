package myapp.notification.controller;

import myapp.core.bean.JsonReply;
import myapp.notification.facade.NotificationFacade;
import myapp.notification.service.bean.NotificationSendRequest;

/**
 * 
 * @author Mate
 *
 */
public class NotificationControllerImpl implements NotificationController
{
	private NotificationFacade notificationFacade;

	public NotificationControllerImpl(NotificationFacade notificationFacade)
	{
		this.notificationFacade = notificationFacade;
	}

	public JsonReply sendNotification(NotificationSendRequest request)
	{
		notificationFacade.sendEmail(request);
		return new JsonReply();
	}

}
