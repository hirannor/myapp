package myapp.notification.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import myapp.core.bean.JsonReply;
import myapp.core.bean.Role;
import myapp.email.service.EmailService;
import myapp.email.service.bean.EmailSendRequest;

/**
 * 
 * @author Mate
 *
 */
@Controller
@Secured(Role.ADMIN)
@RequestMapping(value = "/admin/notification/")
public class NotificationController
{
	private EmailService emailService;

	public NotificationController(EmailService emailService)
	{
		this.emailService = emailService;
	}

	@RequestMapping(value = "sendNotification", method = RequestMethod.POST, headers = "Accept=application/json; charset=utf-8")
	public @ResponseBody JsonReply sendNotification(@RequestBody EmailSendRequest request)
	{
		emailService.sendEmail(request);
		return new JsonReply();
	}

}
