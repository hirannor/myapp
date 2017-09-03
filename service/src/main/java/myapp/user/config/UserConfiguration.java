package myapp.user.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import myapp.notification.service.NotificationService;
import myapp.user.common.facade.UserCommonFacade;
import myapp.user.common.facade.impl.CustomerCommonFacadeImpl;
import myapp.user.dao.UserDao;
import myapp.user.dao.impl.UserDaoImpl;
import myapp.user.dao.mapper.UserMapper;
import myapp.user.service.UserService;
import myapp.user.service.impl.UserServiceImpl;

/**
 * 
 * @author Mate
 *
 */
@Configuration
public class UserConfiguration
{
	@Bean
	public UserDao getUserDao(UserMapper userMapper)
	{
		return new UserDaoImpl(userMapper);
	}

	@Bean
	public UserMapper getCustomerMapper(SqlSessionFactory sqlSessionFactory) throws Exception
	{
		SqlSessionTemplate sessionTemplate = new SqlSessionTemplate(sqlSessionFactory);
		return sessionTemplate.getMapper(UserMapper.class);
	}

	@Bean
	public UserService getUserService(BCryptPasswordEncoder passwordEncoder)
	{
		return new UserServiceImpl(getUserDao(null), passwordEncoder);
	}

	@Bean
	public UserCommonFacade getUserCommonFacade(NotificationService emailService)
	{
		return new CustomerCommonFacadeImpl(getUserService(null), emailService);
	}
}
