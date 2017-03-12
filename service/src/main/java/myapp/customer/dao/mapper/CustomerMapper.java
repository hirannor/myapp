package myapp.customer.dao.mapper;

import org.apache.ibatis.annotations.Param;

import myapp.customer.bean.Customer;

/**
 * CustomerMapper Interface
 * 
 * @author Mate
 *
 */
public interface CustomerMapper
{
	String USERNAME = "username";

	Customer getCustomer(@Param(USERNAME) String username);
}
