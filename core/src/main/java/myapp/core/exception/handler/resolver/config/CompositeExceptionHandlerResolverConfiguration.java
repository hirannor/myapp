package myapp.core.exception.handler.resolver.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.handler.HandlerExceptionResolverComposite;

import myapp.core.exception.handler.resolver.IllegalArgumentExceptionHandlerExceptionResolver;
import myapp.core.exception.handler.resolver.NullPointerExceptionHandlerExceptionResolver;

/**
 * Configuration class of CompositeExceptionHandlerResolver
 * 
 * @author Mate
 *
 */
@Configuration
public class CompositeExceptionHandlerResolverConfiguration
{
	@Bean
	HandlerExceptionResolverComposite getHandlerExceptionResolverComposite()
	{
		HandlerExceptionResolverComposite result = new HandlerExceptionResolverComposite();

		List<HandlerExceptionResolver> l = new ArrayList<HandlerExceptionResolver>();

		l.add(new NullPointerExceptionHandlerExceptionResolver());
		l.add(new IllegalArgumentExceptionHandlerExceptionResolver());

		result.setExceptionResolvers(l);

		return result;
	}
}
