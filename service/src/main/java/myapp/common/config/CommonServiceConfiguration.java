package myapp.common.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import myapp.common.dao.CommonDao;
import myapp.common.dao.impl.CommonDaoImpl;
import myapp.common.dao.mapper.CommonMapper;
import myapp.common.service.CommonService;
import myapp.common.service.impl.CommonServiceImpl;
import myapp.customer.dao.CustomerDao;
import myapp.email.service.EmailService;

/**
 * Configuration for CommonService
 * 
 * @author Mate
 *
 */
@Configuration
public class CommonServiceConfiguration
{
	@Bean
	public CommonDao getCommonDao(CommonMapper commonMapper)
	{
		return new CommonDaoImpl(commonMapper);
	}

	@Bean
	public CommonMapper getCommonMapper(SqlSessionFactory sqlSessionFactory) throws Exception
	{
		SqlSessionTemplate sessionTemplate = new SqlSessionTemplate(sqlSessionFactory);
		return sessionTemplate.getMapper(CommonMapper.class);
	}

	@Bean
	public CommonService getCommonService(CustomerDao customerDao, CommonDao commonDao, EmailService emailService,
			BCryptPasswordEncoder passwordEncoder)
	{
		return new CommonServiceImpl(customerDao, commonDao, emailService, passwordEncoder);
	}

}
