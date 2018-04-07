package de.mxro.commissioncalculator.model.view;

import java.math.BigDecimal;

/**
 * <p>The results of the commission calculation as used by the view.
 * @author Max
 *
 */
public class CommissionView {
	
	/**
	 * The commission that should be paid out to the agent.
	 */
	private BigDecimal value;

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}
	
}
