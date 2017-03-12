package myapp.customer.dao.impl;

import org.springframework.stereotype.Repository;

import myapp.customer.bean.Customer;
import myapp.customer.dao.CustomerDao;
import myapp.customer.dao.mapper.CustomerMapper;

/**
 * CustomerDao Implementation
 * 
 * @author Mate
 *
 */
@Repository
public class CustomerDaoImpl implements CustomerDao
{
	private CustomerMapper customerMapper;

	public CustomerDaoImpl(CustomerMapper customerMapper)
	{
		if (customerMapper == null)
		{
			throw new IllegalArgumentException(customerMapper + " Bean creation error!");
		}

		this.customerMapper = customerMapper;
	}

	@Override
	public Customer getCustomer(String username)
	{
		return customerMapper.getCustomer(username);
	}

}
