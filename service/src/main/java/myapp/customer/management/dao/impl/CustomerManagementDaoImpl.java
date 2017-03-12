package myapp.customer.management.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import myapp.customer.bean.Customer;
import myapp.customer.management.dao.CustomerManagementDao;
import myapp.customer.management.dao.mapper.CustomerManagementMapper;
import myapp.customer.management.service.bean.ChangeStatusRequest;

/**
 * CustomerManagementDao Implementation
 * 
 * @author Mate
 *
 */
@Repository
public class CustomerManagementDaoImpl implements CustomerManagementDao
{
	private CustomerManagementMapper customerManagementMapper;

	public CustomerManagementDaoImpl(CustomerManagementMapper customerManagementMapper)
	{
		if (customerManagementMapper == null)
		{
			throw new IllegalArgumentException(customerManagementMapper + " Bean creation error!");
		}

		this.customerManagementMapper = customerManagementMapper;
	}

	@Override
	public void deleteCustomerById(int id)
	{
		customerManagementMapper.deleteCustomerById(id);
	}

	@Override
	public Integer editCustomer(Customer customer)
	{
		return customerManagementMapper.editCustomer(customer);
	}

	@Override
	public List<Customer> getCustomerList()
	{
		return customerManagementMapper.getCustomerList();
	}

	@Override
	public void deleteUsrAuthById(int id)
	{
		customerManagementMapper.deleteUsrAuthById(id);
	}

	@Override
	public void deleteUsrRoleById(int id)
	{
		customerManagementMapper.deleteUsrRoleById(id);
	}

	@Override
	public void changeAccountStatus(ChangeStatusRequest request)
	{
		customerManagementMapper.changeAccountStatus(request);
	}
}
