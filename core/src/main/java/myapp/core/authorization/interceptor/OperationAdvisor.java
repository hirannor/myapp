package myapp.core.authorization.interceptor;

import java.lang.reflect.Method;

import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.support.AbstractPointcutAdvisor;
import org.springframework.aop.support.StaticMethodMatcherPointcut;

import myapp.core.authorization.annotation.Operation;
import myapp.core.authorization.annotation.Function;

public class OperationAdvisor extends AbstractPointcutAdvisor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9139686198060131439L;
	
	private MethodInterceptor operationMethodInterceptor;

	public OperationAdvisor(MethodInterceptor operationMethodInterceptor) 
	{
		this.operationMethodInterceptor = operationMethodInterceptor;
	}

	private final StaticMethodMatcherPointcut pointcut = new StaticMethodMatcherPointcut() {
		@Override
		public boolean matches(Method method, Class<?> targetClass) {
			
			if(targetClass.isAnnotationPresent(Function.class) && !method.isAnnotationPresent(Operation.class))
			{
				return true;
			}
			return targetClass.isAnnotationPresent(Function.class) && method.isAnnotationPresent(Operation.class);
		}
	};

	@Override
	public Pointcut getPointcut() {
		return this.pointcut;
	}

	@Override
	public Advice getAdvice() {
		return this.operationMethodInterceptor;
	}

}
