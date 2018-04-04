package de.mxro.commissioncalculator.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.mxro.commissioncalculator.dao.RangeDao;
import de.mxro.commissioncalculator.model.Commission;
import de.mxro.commissioncalculator.model.Range;
import de.mxro.commissioncalculator.model.Request;

@Service("commissionCalculationService")
public class CommissionCalculationServiceImpl implements CommissionCalculationService {

	@Autowired
	RangeDao range;

	@Override
	public Commission calculateCommission(Request request) {

		double achievement = (double) request.getActual() / (double) request.getTarget();

		Range matchingRange = range.findRangeByAchievement(achievement);
		
		
		double base = matchingRange.getBase().doubleValue();
		double start = matchingRange.getStart().doubleValue();
		double rate = matchingRange.getRate().doubleValue();
		
		Double commissionRate = base
				+ ((achievement - start)
						* rate);
		
		
		Commission commission = new Commission();

		// two digits after decimal point
		int scale = 2;

		commission.setValue(BigDecimal.valueOf(request.getMotc().doubleValue() * commissionRate.doubleValue())
				.setScale(scale, BigDecimal.ROUND_HALF_UP));

		return commission;
	}
}