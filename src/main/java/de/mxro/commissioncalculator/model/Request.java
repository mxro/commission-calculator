package de.mxro.commissioncalculator.model;

import java.math.BigDecimal;

public class Request {

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
		
	public static Request create(int actual, int target, double motc) {
		Request request = new Request();
		request.actual = actual;
		request.target = target;
		request.motc = BigDecimal.valueOf(motc);
		return request;
	}
	
}
