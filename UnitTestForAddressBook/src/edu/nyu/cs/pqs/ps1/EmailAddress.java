package edu.nyu.cs.pqs.ps1;

/**
 * EmailAddress Class is for creating emailAddress object in address book entry.
 * 
 * Two email addresses are equal if and only if their string value are
 * equivalent. The equals method implements an equivalence relation.
 * 
 * @author yixia
 * 
 */
public class EmailAddress {

	private String emailAddress;

	/**
	 * Constructs a new EmailAddress with the parameter emailAddress
	 * 
	 * @param emailAddress
	 */
	public EmailAddress(String emailAddress) {
		this.emailAddress = fixEmpty(emailAddress);
	}

	/**
	 * Compares this email address to the specified object. The result is true
	 * if and only if the argument is a EmailAddress object and its fields that
	 * represent the same sequence of characters as this object.
	 * 
	 * @param object
	 *            The object to compare this EmailAddress against
	 * 
	 * @return true if the given object represents a EmailAddress equivalent to
	 *         this EmailAddress, false otherwise
	 */
	@Override
	public boolean equals(Object object) {

		// check if object is a reference to EmailAddress
		if (object == this) {
			return true;
		}
		// check if object is an instance of EmailAddress
		if (!(object instanceof EmailAddress)) {
			return false;
		}
		// case object to EmailAddress
		EmailAddress ea = (EmailAddress) object;
		return ea.emailAddress.equals(emailAddress);
	}

	/**
	 * Fix the problem if input parameter is empty.
	 * 
	 * @param field
	 *            The input field
	 * @return field if not empty; otherwise return ""
	 */
	private String fixEmpty(String field) {
		if (field == null || field.length() == 0) {
			return "";
		} else {
			return field;
		}
	}

	/**
	 * Returns a hash code for this email address.
	 * 
	 * @return a hash code value for this object.
	 */
	@Override
	public int hashCode() {
		int result = 17;
		result = 31 * result + emailAddress.hashCode();
		return result;
	}

	/**
	 * Defines this object toString format.
	 * 
	 * @return email address
	 */
	@Override
	public String toString() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = fixEmpty(emailAddress);
	}

	public String getEmailAddress() {
		return emailAddress;
	}
}
