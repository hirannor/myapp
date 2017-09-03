package myapp.core.authorization.config;

import org.aopalliance.intercept.MethodInterceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.aop.support.AbstractPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;

import myapp.core.authorization.dao.AuthorizationDao;
import myapp.core.authorization.dao.impl.AuthorizationDaoImpl;
import myapp.core.authorization.dao.mapper.AuthorizationMapper;
import myapp.core.authorization.evaluator.CustomAuthorizationEvaluator;
import myapp.core.authorization.interceptor.AuthorizationInterceptor;
import myapp.core.authorization.interceptor.OperationAdvisor;
import myapp.core.authorization.service.AuthorizationService;
import myapp.core.authorization.service.impl.AuthorizationServiceImpl;

@Configuration
public class AuthorizationConfiguration
{
	@Bean
	public PermissionEvaluator getCustomAuthorizationEvaluator()
	{
		return new CustomAuthorizationEvaluator(getAuthorizationService());
	}

	@Bean
	public AuthorizationMapper getAuthorizationMapper(SqlSessionFactory sqlSessionFactory)
	{
		SqlSessionTemplate sessionTemplate = new SqlSessionTemplate(sqlSessionFactory);
		return sessionTemplate.getMapper(AuthorizationMapper.class);
	}

	@Bean
	public AuthorizationService getAuthorizationService()
	{
		return new AuthorizationServiceImpl(getAuthorizationDao(null));
	}

	@Bean
	public AuthorizationDao getAuthorizationDao(AuthorizationMapper authorizationMapper)
	{
		return new AuthorizationDaoImpl(authorizationMapper);
	}

	@Bean
	public AbstractPointcutAdvisor getOperationAdvisor(MethodInterceptor operationMethodInterceptor)
	{
		return new OperationAdvisor(operationMethodInterceptor);
	}

	@Bean
	public MethodInterceptor getOperationMethodInterceptor()
	{
		return new AuthorizationInterceptor(getCustomAuthorizationEvaluator());
	}

	@Bean
	public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator()
	{
		DefaultAdvisorAutoProxyCreator creator = new DefaultAdvisorAutoProxyCreator();
		creator.setProxyTargetClass(true);
		return creator;
	}

	@Bean
	public MethodSecurityExpressionHandler createExpressionHandler()
	{
		DefaultMethodSecurityExpressionHandler expressionHandler = new DefaultMethodSecurityExpressionHandler();
		expressionHandler.setPermissionEvaluator(getCustomAuthorizationEvaluator());
		return expressionHandler;
	}
}
