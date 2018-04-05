package de.mxro.commissioncalculator.model.domain;

import java.math.BigDecimal;

public class Commission {
	private BigDecimal value;

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}
}
