package myapp.notification.facade.impl;

import myapp.core.authorization.annotation.Operation;
import myapp.core.authorization.annotation.Function;
import myapp.notification.facade.NotificationFacade;
import myapp.notification.service.NotificationService;
import myapp.notification.service.bean.NotificationSendRequest;

@Function(name = NotificationFacadeImpl.FUNCTION)
public class NotificationFacadeImpl implements NotificationFacade
{
	protected static final String FUNCTION = "notification";
	private static final String OPERATION_PROCESS = "process";
	
	private NotificationService notificationService;
	public NotificationFacadeImpl(NotificationService notificationService)
	{
		this.notificationService = notificationService;
	}

	@Override
	@Operation(name = OPERATION_PROCESS)
	public void sendEmail(NotificationSendRequest request)
	{
		notificationService.sendEmail(request);
	}
}
