package de.mxro.commissioncalculator.model.view;

/**
 * <p>Used to by the view to display any errors encountered during calculating the commission.
 * @author Max
 *
 */
public class ErrorView {
	
	/**
	 * A human-readable error message.
	 */
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
