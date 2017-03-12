package myapp.common.service.impl;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import myapp.common.dao.CommonDao;
import myapp.common.service.CommonService;
import myapp.common.service.bean.RegistrateRequest;
import myapp.common.service.bean.ResetPasswordRequest;
import myapp.customer.bean.Customer;
import myapp.customer.dao.CustomerDao;
import myapp.customer.exception.CustomerAlreadyExistException;
import myapp.customer.exception.EmailNotFoundException;
import myapp.customer.service.CustomerService;
import myapp.email.service.EmailService;

/**
 * CommonService Implementation
 * 
 * @author Mate
 *
 */
@Service
public class CommonServiceImpl implements CommonService
{
	private CustomerDao customerDao;
	private CommonDao commonDao;
	private BCryptPasswordEncoder passwordEncoder;
	private EmailService emailService;

	public CommonServiceImpl(CustomerDao customerDao, CommonDao commonDao, EmailService emailService,
			BCryptPasswordEncoder passwordEncoder)
	{
		this.customerDao = customerDao;
		this.commonDao = commonDao;
		this.emailService = emailService;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public void registrate(RegistrateRequest registrateRequest) throws CustomerAlreadyExistException
	{
		if (isCustomerExist(registrateRequest.getUsername()))
		{
			throw new CustomerAlreadyExistException("Username already exist, please choose another one!");
		}

		Customer customer = new Customer();

		customer.setUsername(registrateRequest.getUsername());
		customer.setPassword(registrateRequest.getPassword());
		customer.setName(registrateRequest.getName());
		customer.setEmail(registrateRequest.getEmail());
		customer.setAge(registrateRequest.getAge());

		String hashedPassword = passwordEncoder.encode(registrateRequest.getPassword());

		commonDao.insertCustomer(registrateRequest);
		commonDao.insertUsrAuth(registrateRequest.getUsername(), hashedPassword);
		commonDao.insertUsrRole(registrateRequest.getUsername(), CustomerService.DEFAULT_ROLE);
		emailService.registrationNotification(customer);

	}

	@Override
	public void resetPassword(ResetPasswordRequest resetPasswordRequest) throws EmailNotFoundException
	{
		String generatedPassword = RandomStringUtils.randomAlphanumeric(8);
		String hashedPassword = passwordEncoder.encode(generatedPassword);

		Integer forgotPassword = commonDao.resetPassword(resetPasswordRequest.getEmail(), hashedPassword);
		if (forgotPassword < 0)
		{
			throw new EmailNotFoundException("Email is not found in our system!");
		}
		emailService.resetPasswordNotification(resetPasswordRequest.getEmail(), generatedPassword);
	}

	private boolean isCustomerExist(String username)
	{
		if (customerDao.getCustomer(username) != null)
		{
			return true;
		}
		return false;
	}

}
