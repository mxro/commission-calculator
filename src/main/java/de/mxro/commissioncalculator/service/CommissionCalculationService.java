package de.mxro.commissioncalculator.service;

import de.mxro.commissioncalculator.model.Commission;
import de.mxro.commissioncalculator.model.Request;

public interface CommissionCalculationService {
	
	Commission calculateCommission(Request request);
	
}
