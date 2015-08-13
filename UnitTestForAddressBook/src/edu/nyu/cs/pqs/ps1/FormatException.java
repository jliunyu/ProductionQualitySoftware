package edu.nyu.cs.pqs.ps1;

/**
 * FormatException Class is used for checking exception and has option to output
 * format error message.
 * 
 * @author yixia
 * 
 */
public class FormatException extends Exception {
	/**
	 * The generated serial version ID
	 */
	private static final long serialVersionUID = 361799078846381750L;

	/**
	 * Instantiates a new format exception.
	 */
	public FormatException() {
		super();
	}

	/**
	 * Instantiates a new format exception with error message.
	 * 
	 * @param message
	 *            the error message
	 */
	public FormatException(String message) {
		super(message);
	}
}
