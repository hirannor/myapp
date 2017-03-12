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
	@Bean
	public DataSource dataSource()
	{
		final JndiDataSourceLookup dsLookup = new JndiDataSourceLookup();
		dsLookup.setResourceRef(true);

		DataSource dataSource = dsLookup.getDataSource("java:comp/env/jdbc/CustomerDB");
		return dataSource;
	}
}
