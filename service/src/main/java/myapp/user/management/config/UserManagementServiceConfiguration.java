package myapp.user.management.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import myapp.user.management.dao.UserManagementDao;
import myapp.user.management.dao.impl.UserManagementDaoImpl;
import myapp.user.management.dao.mapper.UserManagementMapper;
import myapp.user.management.facade.UserManagementFacade;
import myapp.user.management.facade.impl.UserManagementFacadeImpl;
import myapp.user.management.service.UserManagementService;
import myapp.user.management.service.impl.UserManagementServiceImpl;

/**
 * 
 * @author Mate
 *
 */
@Configuration
public class UserManagementServiceConfiguration
{
	@Bean
	public UserManagementDao getUserManagementDao(UserManagementMapper userManagementMapper)
	{
		return new UserManagementDaoImpl(userManagementMapper);
	}

	@Bean
	public UserManagementMapper getUserManagementMapper(SqlSessionFactory sqlSessionFactory) throws Exception
	{
		SqlSessionTemplate sessionTemplate = new SqlSessionTemplate(sqlSessionFactory);
		return sessionTemplate.getMapper(UserManagementMapper.class);
	}

	@Bean
	public UserManagementService getUserManagementService()
	{
		return new UserManagementServiceImpl(getUserManagementDao(null));
	}

	@Bean
	public UserManagementFacade getUserManagementFacade()
	{
		return new UserManagementFacadeImpl(getUserManagementService());
	}
}
