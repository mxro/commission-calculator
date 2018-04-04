package de.mxro.commissioncalculator.tests;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.mxro.commissioncalculator.config.AppConfig;
import de.mxro.commissioncalculator.model.Commission;
import de.mxro.commissioncalculator.model.Request;
import de.mxro.commissioncalculator.service.CommissionCalculationService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
public class CalculateCommissionsTests {

	@Autowired
	CommissionCalculationService service;
	
	/**
	 * Provided test cases.
	 */
	@Test
	public void test_examples() {
		{
			Commission commission = service.calculateCommission(Request.create(79, 100, 5000.0));
			Assert.assertEquals(money(0.0), commission.getValue());
		}
		
		{
			Commission commission = service.calculateCommission(Request.create(100, 100, 5000.0));
			Assert.assertEquals(money(5000.0), commission.getValue());
		}
		
		{
			Commission commission = service.calculateCommission(Request.create(210, 100, 5000.0));
			Assert.assertEquals(money(12750.0), commission.getValue());
		}
		
	}
	
	private final BigDecimal money(double value) {
		return BigDecimal.valueOf(value).setScale(2);
	}

}
