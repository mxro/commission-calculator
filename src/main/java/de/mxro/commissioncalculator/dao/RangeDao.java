package de.mxro.commissioncalculator.dao;

import de.mxro.commissioncalculator.model.domain.Range;

/**
 * The dao for finding commission base and scaling rate.
 * 
 * @author Max
 *
 */
public interface RangeDao {

	/**
	 * Finds the {@link Range} for a specific achievement value.
	 * 
	 * @param achievement The achievement a sales agent achieved as fraction of actual and target sales.
	 * @return
	 */
	Range findRangeByAchievement(double achievement);

}
