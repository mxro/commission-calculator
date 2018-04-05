package de.mxro.commissioncalculator.model.domain;

import java.math.BigDecimal;

public class Range {

	// for later, when this is mapped to db
	private String rangeId;
	private BigDecimal start;
	private BigDecimal end;
	private BigDecimal base;
	private BigDecimal rate;

	public String getRangeId() {
		return rangeId;
	}

	public void setRangeId(String rangeId) {
		this.rangeId = rangeId;
	}

	public BigDecimal getStart() {
		return start;
	}

	public void setStart(BigDecimal start) {
		this.start = start;
	}

	public BigDecimal getEnd() {
		return end;
	}

	public void setEnd(BigDecimal end) {
		this.end = end;
	}

	public BigDecimal getBase() {
		return base;
	}

	public void setBase(BigDecimal base) {
		this.base = base;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	/**
	 * Convenience method for quickly creating ranges.
	 */
	public static Range create(Double start, Double end, Double base, Double rate) {

		Range range = new Range();
		range.start = BigDecimal.valueOf(start).setScale(2);
		range.end = BigDecimal.valueOf(end).setScale(2);
		range.base = BigDecimal.valueOf(base).setScale(2);
		range.rate = BigDecimal.valueOf(rate).setScale(2);
		return range;
	}

}
