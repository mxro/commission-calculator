package de.mxro.commissioncalculator.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.mxro.commissioncalculator.config.AppConfig;
import de.mxro.commissioncalculator.dao.HSQLRangeDaoImpl;
import de.mxro.commissioncalculator.dao.RangeDao;
import de.mxro.commissioncalculator.model.domain.Range;

/**
 * Tests for {@link HSQLRangeDaoImpl}
 * @author Max
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
public class HSQLRangeDoaImplTest {

	@Autowired
	@Qualifier("hsql")
	RangeDao rangeDao;

	@Test
	public void test() {

		rangeDao.findRangeByAchievement(0.0).equals(Range.create(0.0, 0.8, 0.0, 0.0));

		rangeDao.findRangeByAchievement(0.8).equals(Range.create(0.8, 1.0, 0.8, 1.0));

		rangeDao.findRangeByAchievement(1.1).equals(Range.create(1.0, 2.0, 1.0, 1.5));

	}

}
