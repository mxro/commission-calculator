package de.mxro.commissioncalculator.model.view;

import java.math.BigDecimal;

public class RequestView {

	private int target;
	private int actual;
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
		
	public static RequestView create(int actual, int target, double motc) {
		RequestView request = new RequestView();
		request.actual = actual;
		request.target = target;
		request.motc = BigDecimal.valueOf(motc);
		return request;
	}
	
}
