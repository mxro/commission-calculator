package de.mxro.commissioncalculator.model.domain;

import java.math.BigDecimal;

/**
 * <p>The parameters required to perform a commission calculation.
 * 
 * @author Max
 *
 */
public class CalculationParameters {

	/**
	 * The target number of sales expected of an agent.
	 */
	private int target;
	
	/**
	 * The actual number of sales an agent performed.
	 */
	private int actual;
	
	/**
	 * The amount the sales person gets paid if the target is met (Monthly On-Target Commission).
	 */
	private BigDecimal motc;

	public int getTarget() {
		return target;
	}

	public void setTarget(int target) {
		this.target = target;
	}

	public int getActual() {
		return actual;
	}

	public void setActual(int actual) {
		this.actual = actual;
	}

	public BigDecimal getMotc() {
		return motc;
	}

	public void setMotc(BigDecimal motc) {
		this.motc = motc;
	}
		
	public static CalculationParameters create(int actual, int target, double motc) {
		CalculationParameters request = new CalculationParameters();
		request.actual = actual;
		request.target = target;
		request.motc = BigDecimal.valueOf(motc);
		return request;
	}

	@Override
	public String toString() {
		return "CalculationParameters [target=" + target + ", actual=" + actual + ", motc=" + motc + "]";
	}
	
	
	
}
