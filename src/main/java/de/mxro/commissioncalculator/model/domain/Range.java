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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((base == null) ? 0 : base.hashCode());
		result = prime * result + ((end == null) ? 0 : end.hashCode());
		result = prime * result + ((rate == null) ? 0 : rate.hashCode());
		result = prime * result + ((start == null) ? 0 : start.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Range other = (Range) obj;
		if (base == null) {
			if (other.base != null)
				return false;
		} else if (!base.equals(other.base))
			return false;
		if (end == null) {
			if (other.end != null)
				return false;
		} else if (!end.equals(other.end))
			return false;
		if (rate == null) {
			if (other.rate != null)
				return false;
		} else if (!rate.equals(other.rate))
			return false;
		if (start == null) {
			if (other.start != null)
				return false;
		} else if (!start.equals(other.start))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Range [start=" + start + ", end=" + end + ", base=" + base + ", rate=" + rate + "]";
	}

	

}
