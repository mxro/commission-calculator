package de.mxro.commissioncalculator.tests;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.mxro.commissioncalculator.config.AppConfig;
import de.mxro.commissioncalculator.dao.RangeDao;
import de.mxro.commissioncalculator.model.domain.Commission;
import de.mxro.commissioncalculator.model.domain.Range;
import de.mxro.commissioncalculator.model.domain.CalculationParameters;
import de.mxro.commissioncalculator.service.CommissionCalculationService;
import de.mxro.commissioncalculator.service.CommissionCalculationServiceImpl;

/**
 * Tests for the class {@link CommissionCalculationServiceImpl}
 * @author Max
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
public class CommissionCalculationServiceImplTest {

	/**
	 * Provided example 1
	 */
	@Test
	public void test_example_1() {
		RangeDao rangeDao = mock(RangeDao.class);
		when(rangeDao.findRangeByAchievement(0.79)).thenReturn(Range.create(0.0, 0.8, 0.0, 0.0));

		CommissionCalculationService service = new CommissionCalculationServiceImpl(rangeDao);

		Commission commission = service.calculateCommission(CalculationParameters.create(79, 100, 5000.0));
		Assert.assertEquals(money(0.0), commission.getValue());

	}

	/**
	 * Provided example 2
	 */
	@Test
	public void test_example_2() {
		RangeDao rangeDao = mock(RangeDao.class);
		when(rangeDao.findRangeByAchievement(1.0)).thenReturn(Range.create(1.0, 2.0, 1.0, 1.5));

		CommissionCalculationService service = new CommissionCalculationServiceImpl(rangeDao);

		Commission commission = service.calculateCommission(CalculationParameters.create(100, 100, 5000.0));
		Assert.assertEquals(money(5000.0), commission.getValue());

	}

	/**
	 * Provided example 3
	 */
	@Test
	public void test_example_3() {
		RangeDao rangeDao = mock(RangeDao.class);
		when(rangeDao.findRangeByAchievement(2.1)).thenReturn(Range.create(2.0, 3.0, 2.5, 0.5));

		CommissionCalculationService service = new CommissionCalculationServiceImpl(rangeDao);

		Commission commission = service.calculateCommission(CalculationParameters.create(210, 100, 5000.0));
		Assert.assertEquals(money(12750.0), commission.getValue());

	}
	
	/**
	 * Edge case 1
	 */
	@Test
	public void test_example_4() {
		RangeDao rangeDao = mock(RangeDao.class);
		when(rangeDao.findRangeByAchievement(99.98)).thenReturn(Range.create(3.0, 99.99, 3.0, 0.0));

		CommissionCalculationService service = new CommissionCalculationServiceImpl(rangeDao);

		Commission commission = service.calculateCommission(CalculationParameters.create(9998, 100, 5000.0));
		Assert.assertEquals(money(15000.0), commission.getValue());
	}
	
	private final BigDecimal money(double value) {
		return BigDecimal.valueOf(value).setScale(2);
	}

}
