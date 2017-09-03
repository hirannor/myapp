package myapp.core.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;

import myapp.core.authentication.filter.CsrfHeaderFilter;
import myapp.core.authentication.filter.CustomLoginProcessingFilter;
import myapp.core.bean.Role;

/**
 * Custom Configuration of Spring Security
 * 
 * @author Mate
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter
{
	private static final String FORM_BASED_LOGIN_ENTRY_POINT = "/login";
	private static final String ADMIN_ENTRY_POINT = "/admin/**";
	private static final String CUSTOMER_ENTRY_POINT = "/customer/**";
	private static final String LOGOUT_URL = "/logout";
	private static final String CSRF_TOKEN_HEADER = "X-XSRF-TOKEN";
	private static final String JSESSIONID = "JSESSIONID";
	
	@Autowired
	private AuthenticationProvider authenticationProvider;

	@Autowired
	private AuthenticationSuccessHandler authenticationSuccessHandler;

	@Autowired
	private AuthenticationFailureHandler authenticationFailureHandler;

	@Autowired
	private LogoutSuccessHandler logoutSuccessHandler;

	@Autowired
	private AuthenticationEntryPoint authenticationEntryPoint;

	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	protected CustomLoginProcessingFilter buildAjaxLoginProcessingFilter() throws Exception
	{
		CustomLoginProcessingFilter filter = new CustomLoginProcessingFilter(FORM_BASED_LOGIN_ENTRY_POINT,
				authenticationSuccessHandler, authenticationFailureHandler, objectMapper);
		filter.setAuthenticationManager(authenticationManager);
		return filter;
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception
	{
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.authenticationProvider(authenticationProvider);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		http.csrf().csrfTokenRepository(csrfTokenRepository()).ignoringAntMatchers(FORM_BASED_LOGIN_ENTRY_POINT).and()
				.exceptionHandling().authenticationEntryPoint(authenticationEntryPoint).and().sessionManagement()
				.enableSessionUrlRewriting(true).sessionCreationPolicy(SessionCreationPolicy.ALWAYS).and()
				.authorizeRequests().antMatchers(FORM_BASED_LOGIN_ENTRY_POINT).permitAll()
				.antMatchers(ADMIN_ENTRY_POINT).hasAnyAuthority(Role.ADMIN, Role.READ_ONLY).antMatchers(ADMIN_ENTRY_POINT).authenticated()
				.antMatchers(CUSTOMER_ENTRY_POINT).hasAuthority(Role.CUSTOMER).antMatchers(CUSTOMER_ENTRY_POINT)
				.authenticated().and().logout().logoutSuccessHandler(logoutSuccessHandler).invalidateHttpSession(true)
				.deleteCookies(JSESSIONID).logoutRequestMatcher(new AntPathRequestMatcher(LOGOUT_URL)).and()
				.addFilterBefore(buildAjaxLoginProcessingFilter(), UsernamePasswordAuthenticationFilter.class)
				.addFilterAfter(new CsrfHeaderFilter(), CsrfFilter.class);
	}

	private CsrfTokenRepository csrfTokenRepository()
	{
		HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
		repository.setHeaderName(CSRF_TOKEN_HEADER);
		return repository;
	}
	
}
