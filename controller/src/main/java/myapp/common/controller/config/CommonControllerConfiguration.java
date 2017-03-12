package myapp.common.controller.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import myapp.common.controller.CommonController;
import myapp.common.service.CommonService;

/**
 * Configuration for CommonController
 * 
 * @author Mate
 *
 */
@Configuration
public class CommonControllerConfiguration
{
	@Bean
	public CommonController getCommonController(CommonService commonService)
	{
		return new CommonController(commonService);
	}
}
