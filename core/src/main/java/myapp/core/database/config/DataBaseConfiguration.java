package myapp.core.database.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;

/**
 * DatabaseConfiguration
 * 
 * @author Mate
 *
 */
@Configuration
public class DataBaseConfiguration
{
	private static final String DATASOURCE = "java:comp/env/jdbc/CustomerDB";
	
	@Bean
	public DataSource dataSource()
	{
		final JndiDataSourceLookup dsLookup = new JndiDataSourceLookup();
		dsLookup.setResourceRef(true);

		DataSource dataSource = dsLookup.getDataSource(DATASOURCE);
		return dataSource;
	}
}
