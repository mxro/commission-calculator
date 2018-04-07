package de.mxro.commissioncalculator.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * <p>Entry point for bootstrapping application
 * @author Max
 *
 */
@Configuration
@ComponentScans(value = { @ComponentScan("de.mxro.commissioncalculator.service"),
		@ComponentScan("de.mxro.commissioncalculator.dao"), @ComponentScan("de.mxro.commissioncalculator.db") })
public class AppConfig {

	@Autowired
	private Environment env;

	
	
}