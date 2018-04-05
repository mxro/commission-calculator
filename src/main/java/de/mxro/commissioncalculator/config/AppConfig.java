package de.mxro.commissioncalculator.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@Configuration
@ComponentScans(value = { @ComponentScan("de.mxro.commissioncalculator.service"),
		@ComponentScan("de.mxro.commissioncalculator.dao"), @ComponentScan("de.mxro.commissioncalculator.db") })
public class AppConfig {

	@Autowired
	private Environment env;

	
	
}