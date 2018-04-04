package de.mxro.commissioncalculator.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;


@Configuration
@ComponentScans(value = { 
	    @ComponentScan("de.mxro.commissioncalculator.service"), @ComponentScan("de.mxro.commissioncalculator.dao") })
public class AppConfig {

  @Autowired
  private Environment env;

  
}