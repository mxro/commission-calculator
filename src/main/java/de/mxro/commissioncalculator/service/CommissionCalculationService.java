package de.mxro.commissioncalculator.service;

import de.mxro.commissioncalculator.model.domain.Commission;
import de.mxro.commissioncalculator.model.domain.Request;

public interface CommissionCalculationService {
	
	Commission calculateCommission(Request request);
	
}
