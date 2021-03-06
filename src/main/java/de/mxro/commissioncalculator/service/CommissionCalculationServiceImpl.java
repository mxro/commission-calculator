package de.mxro.commissioncalculator.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import de.mxro.commissioncalculator.dao.RangeDao;
import de.mxro.commissioncalculator.model.domain.CalculationParameters;
import de.mxro.commissioncalculator.model.domain.Commission;
import de.mxro.commissioncalculator.model.domain.Range;

/**
 * <p>Implementation for {@link CommissionCalculationService}.
 * @author Max
 *
 */
@Service("commissionCalculationService")
public class CommissionCalculationServiceImpl implements CommissionCalculationService {

	RangeDao range;

	@Override
	public Commission calculateCommission(CalculationParameters request) {
			
		// assure here that int is cast to double for the calculation.
		double achievement = (double) request.getActual() / (double) request.getTarget();
		
		Range matchingRange = range.findRangeByAchievement(achievement);
		
		double base = matchingRange.getBase().doubleValue();
		double start = matchingRange.getStart().doubleValue();
		double rate = matchingRange.getRate().doubleValue();
		
		Double commissionRate = base
				+ ((achievement - start)
						* rate);
		
		Commission commission = new Commission();

		// two digits after decimal point for result
		int scale = 2;
		commission.setValue(BigDecimal.valueOf(request.getMotc().doubleValue() * commissionRate.doubleValue())
				.setScale(scale, BigDecimal.ROUND_HALF_UP));

		return commission;
	}
	
	@Autowired
	public CommissionCalculationServiceImpl(@Qualifier("hsql") RangeDao range) {
		super();
		this.range = range;
	}
	
	
	
	
}
