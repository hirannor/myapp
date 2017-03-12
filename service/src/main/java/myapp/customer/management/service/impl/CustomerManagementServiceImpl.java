package myapp.customer.management.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import myapp.customer.management.dao.CustomerManagementDao;
import myapp.customer.management.service.CustomerManagementService;
import myapp.customer.management.service.bean.ChangeStatusRequest;
import myapp.customer.management.service.bean.CustomerDeleteServiceRequest;
import myapp.customer.management.service.bean.CustomerEditServiceRequest;
import myapp.customer.management.service.bean.GetCustomerListServiceReply;

/**
 * CustomerManagementService Implementation
 * 
 * @author Mate
 *
 */
@Service
public class CustomerManagementServiceImpl implements CustomerManagementService
{
	private static final Logger LOGGER = LogManager.getLogger("hu.uni.miskolc.iit.customer.management.service.impl");

	private CustomerManagementDao customerManagementDao;

	public CustomerManagementServiceImpl(CustomerManagementDao customerManagementDao)
	{
		if (customerManagementDao == null)
		{
			throw new IllegalArgumentException(customerManagementDao + " Bean creation error!");
		}

		this.customerManagementDao = customerManagementDao;
	}

	@Override
	public void deleteCustomerById(CustomerDeleteServiceRequest request)
	{
		customerManagementDao.deleteUsrRoleById(request.getId());
		customerManagementDao.deleteUsrAuthById(request.getId());
		customerManagementDao.deleteCustomerById(request.getId());
	}

	@Override
	public void editCustomer(CustomerEditServiceRequest request)
	{
		customerManagementDao.editCustomer(request.getCustomer());
	}

	@Override
	public GetCustomerListServiceReply getCustomerList()
	{
		GetCustomerListServiceReply reply = new GetCustomerListServiceReply();
		reply.setCustomerList(customerManagementDao.getCustomerList());

		return reply;
	}

	@Override
	public void changeAccountStatus(ChangeStatusRequest request)
	{
		customerManagementDao.changeAccountStatus(request);
	}
}
