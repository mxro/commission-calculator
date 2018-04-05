package de.mxro.commissioncalculator.dao;

import java.math.BigDecimal;

import de.mxro.commissioncalculator.model.domain.Range;

public interface RangeDao {
	
	Range findRangeByAchievement(double achievement);
	
}
