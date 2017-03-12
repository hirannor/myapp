package myapp.customer.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import myapp.customer.dao.CustomerDao;
import myapp.customer.dao.impl.CustomerDaoImpl;
import myapp.customer.dao.mapper.CustomerMapper;
import myapp.customer.service.CustomerService;
import myapp.customer.service.impl.CustomerServiceImpl;

/**
 * Configuration for CustomerService
 * 
 * @author Mate
 *
 */
@Configuration
public class CustomerServiceConfiguration
{
	@Bean
	public CustomerDao getCustomerDao(CustomerMapper customerMapper)
	{
		return new CustomerDaoImpl(customerMapper);
	}

	@Bean
	public CustomerMapper getCustomerMapper(SqlSessionFactory sqlSessionFactory) throws Exception
	{
		SqlSessionTemplate sessionTemplate = new SqlSessionTemplate(sqlSessionFactory);
		return sessionTemplate.getMapper(CustomerMapper.class);
	}

	@Bean
	public CustomerService getCustomerService(CustomerDao customerDao)
	{
		return new CustomerServiceImpl(customerDao);
	}
}
