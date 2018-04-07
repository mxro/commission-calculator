package de.mxro.commissioncalculator.model.view;

import java.math.BigDecimal;

import de.mxro.commissioncalculator.model.domain.CalculationParameters;

/**
 * <p>
 * The parameters required to perform a commission calculation. As used by the
 * view.
 * <p>
 * This class is defined separately to {@link CalculationParameters} to assure
 * independence of the view layer.
 * 
 * @author Max
 *
 */
public class CalculationParametersView {

	/**
	 * The target number of sales expected of an agent.
	 */
	private int target;

	/**
	 * The actual number of sales an agent performed.
	 */
	private int actual;

	/**
	 * The amount the sales person gets paid if the target is met (Monthly On-Target
	 * Commission).
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

	@Override
	public String toString() {
		return "CalculationParametersView [target=" + target + ", actual=" + actual + ", motc=" + motc + "]";
	}
	
	public static CalculationParametersView create(int actual, int target, double motc) {
		CalculationParametersView request = new CalculationParametersView();
		request.actual = actual;
		request.target = target;
		request.motc = BigDecimal.valueOf(motc);
		return request;
	}


}
