package de.mxro.commissioncalculator.service;

import de.mxro.commissioncalculator.model.domain.Commission;
import de.mxro.commissioncalculator.model.domain.CalculationParameters;

/**
 * <p>
 * This service calculates the commission that needs to be paid to an agent
 * based on provided {@link CalculationParameters}
 * 
 * @author Max
 *
 */
public interface CommissionCalculationService {

	/**
	 * <p>
	 * Performs the calculation of the commission.
	 * 
	 * @param parameters The parameters required for the calculation.
	 * @return The calculated commission.
	 */
	Commission calculateCommission(CalculationParameters parameters);

}
