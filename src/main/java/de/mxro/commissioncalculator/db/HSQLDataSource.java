package de.mxro.commissioncalculator.db;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

/**
 * <p>A simple Hyper SQL embedded data source used for this project
 * <p>Data is initialized during application startup by applying the SQL specified
 * in src/main/resources/sql/create-db.sql and src/main/resources/sql/insert-data.sql
 * 
 * @author Max
 *
 */
@Configuration
public class HSQLDataSource {

	@Bean
	public DataSource dataSource() {
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		EmbeddedDatabase db = builder.setType(EmbeddedDatabaseType.HSQL).addScript("sql/create-db.sql")
				.addScript("sql/insert-data.sql").build();
		return db;
	}

}
