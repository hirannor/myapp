package myapp.customermanagement.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import myapp.core.bean.JsonReply;
import myapp.core.bean.Role;
import myapp.customer.management.service.CustomerManagementService;
import myapp.customer.management.service.bean.ChangeStatusRequest;
import myapp.customer.management.service.bean.CustomerDeleteServiceRequest;
import myapp.customer.management.service.bean.CustomerEditServiceRequest;
import myapp.customer.management.service.bean.GetCustomerListServiceReply;

/**
 * 
 * @author Mate
 *
 */
@Controller
@Secured(Role.ADMIN)
@RequestMapping(value = "/admin/customermanagement/")
public class CustomerManagementController
{
	private CustomerManagementService customerManagementService;

	public CustomerManagementController(CustomerManagementService customerManagementService)
	{
		if (customerManagementService == null)
		{
			throw new IllegalArgumentException(customerManagementService + " Bean creation error!");
		}
		this.customerManagementService = customerManagementService;
	}

	@RequestMapping(value = "changeAccountStatus", method = RequestMethod.POST, headers = "Accept=application/json; charset=utf-8")
	public @ResponseBody JsonReply changeAccountStatus(@RequestBody ChangeStatusRequest request)
	{
		customerManagementService.changeAccountStatus(request);
		return new JsonReply();
	}

	@RequestMapping(value = "deleteCustomer", method = RequestMethod.POST, headers = "Accept=application/json; charset=utf-8")
	public @ResponseBody JsonReply deleteCustomerById(@RequestBody CustomerDeleteServiceRequest request)
	{
		customerManagementService.deleteCustomerById(request);
		return new JsonReply();
	}

	@RequestMapping(value = "editCustomer", method = RequestMethod.POST, headers = "Accept=application/json; charset=utf-8")
	public @ResponseBody JsonReply editCustomer(@RequestBody CustomerEditServiceRequest request)
	{
		customerManagementService.editCustomer(request);
		return new JsonReply();
	}

	@RequestMapping(value = "getCustomers", method = RequestMethod.POST, headers = "Accept=application/json; charset=utf-8")
	public @ResponseBody GetCustomerListServiceReply getCustomerList()
	{
		return customerManagementService.getCustomerList();
	}

}
