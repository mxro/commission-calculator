package de.mxro.commissioncalculator.dao;

import java.math.BigDecimal;

import org.springframework.stereotype.Repository;

import de.mxro.commissioncalculator.model.domain.Range;

/**
 * <p>A hard coded DAO which provides the values required.
 * <p>Ideally this should be obtained from a database.
 * 
 * @author Max
 *
 */
@Repository
public class HardCodedRangeDaoImpl implements RangeDao {

	@Override
	public Range findRangeByAchievement(double achievement) {
		
		if (achievement < 0.8) {
			return Range.create(0.0, 0.8, 0.0, 0.0);
		}
		
		if (achievement < 1.0) {
			return Range.create(0.8, 1.0, 0.8, 1.0);
		}
		
		if (achievement < 2.0) {
			return Range.create(1.0, 2.0, 1.0, 1.5);
		}
		
		if (achievement < 3.0) {
			return Range.create(2.0, 3.0, 2.5, 0.5);
		}
		
		if (achievement < 99.99) {
			return Range.create(3.0, 99.99, 3.0, 0.0);
		}
		
		throw new IllegalArgumentException("Achievement "+achievement+" not in supported range.");
	}

}
