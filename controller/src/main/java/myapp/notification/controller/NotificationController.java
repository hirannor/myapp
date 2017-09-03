package myapp.notification.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import myapp.core.bean.JsonReply;
import myapp.notification.service.bean.NotificationSendRequest;

@RestController
@RequestMapping(value = "/notification/")
public interface NotificationController
{
	@RequestMapping(value = "sendNotification", method = RequestMethod.POST)
	@ResponseBody
	JsonReply sendNotification(@RequestBody NotificationSendRequest request);
}
