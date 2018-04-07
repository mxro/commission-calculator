package de.mxro.commissioncalculator.model.domain;

import java.math.BigDecimal;

/**
 * <p>
 * A calculated commission value.
 * 
 * @author Max
 *
 */
public class Commission {
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
