package myapp.user.management.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import myapp.core.bean.JsonReply;
import myapp.user.management.service.bean.ChangeStatusRequest;
import myapp.user.management.service.bean.GetUserListServiceReply;
import myapp.user.management.service.bean.UserDeleteServiceRequest;
import myapp.user.management.service.bean.UserEditServiceRequest;

@RestController
@RequestMapping(value = "/usermanagement/")
public interface UserManagementController
{
	@RequestMapping(value = "changeAccountStatus", method = RequestMethod.POST)
	@ResponseBody
	JsonReply changeAccountStatus(@RequestBody ChangeStatusRequest request);

	@RequestMapping(value = "deleteUser", method = RequestMethod.POST)
	@ResponseBody
	JsonReply deleteCustomerById(@RequestBody UserDeleteServiceRequest request);

	@RequestMapping(value = "editUser", method = RequestMethod.POST)
	@ResponseBody
	JsonReply editCustomer(@RequestBody UserEditServiceRequest request);

	@RequestMapping(value = "getUsers", method = RequestMethod.POST)
	@ResponseBody
	GetUserListServiceReply getCustomerList();
}
