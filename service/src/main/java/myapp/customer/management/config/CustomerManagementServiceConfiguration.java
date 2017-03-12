package myapp.customer.management.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import myapp.customer.management.dao.CustomerManagementDao;
import myapp.customer.management.dao.impl.CustomerManagementDaoImpl;
import myapp.customer.management.dao.mapper.CustomerManagementMapper;
import myapp.customer.management.service.CustomerManagementService;
import myapp.customer.management.service.impl.CustomerManagementServiceImpl;
import myapp.email.service.EmailService;
import myapp.email.service.impl.EmailServiceImpl;

/**
 * Configuration for CustomerManagementService
 * 
 * @author Mate
 *
 */
@Configuration
public class CustomerManagementServiceConfiguration
{
	@Bean
	public CustomerManagementDao getCustomerManagementDao(CustomerManagementMapper customerManagementMapper)
	{
		return new CustomerManagementDaoImpl(customerManagementMapper);
	}

	@Bean
	public CustomerManagementMapper getCustomerManagementMapper(SqlSessionFactory sqlSessionFactory) throws Exception
	{
		SqlSessionTemplate sessionTemplate = new SqlSessionTemplate(sqlSessionFactory);
		return sessionTemplate.getMapper(CustomerManagementMapper.class);
	}

	@Bean
	public CustomerManagementService getCustomerManagementService(CustomerManagementDao customerManagementDao)
	{
		return new CustomerManagementServiceImpl(customerManagementDao);
	}

	@Bean
	public EmailService getEmailService(JavaMailSender javaMailSender, SimpleMailMessage simpleMailMessage)
	{
		return new EmailServiceImpl(javaMailSender, simpleMailMessage);
	}
}
