package edu.nyu.cs.pqs.ps1;

/**
 * PhoneNumber Class is for creating phoneNumber object in address book entry.
 * PhoneNumber object accepts three fields to create an name: area code, prefix,
 * and line code. The range of phone number is 000-000-0000 to 999-999-9999.
 * 
 * Two phone numbers are equal if and only if their area code, prefix, and line
 * code are equivalent. The equals method implements an equivalence relation.
 * 
 * The toString format of the object name is "areaCode-prefix-lineNumber".
 * 
 * @author yixia
 * 
 */
public class PhoneNumber {

	private short areaCode;
	private short prefix;
	private short lineNumber;

	/**
	 * Constructs a new PhoneNumber with its area code, prefix and line number.
	 * 
	 * @param areaCode
	 *            The areaCode to be decoded into PhoneNumber, the range of
	 *            areaCode is [0, 999]
	 * @param prefix
	 *            The prefix to be decoded into PhoneNumber, the range of prefix
	 *            is [0, 999]
	 * @param lineNumber
	 *            The lineNumber to be decoded into PhoneNumber, the range of
	 *            lineNumber is [0, 9999]
	 */
	public PhoneNumber(int areaCode, int prefix, int lineNumber) {
		rangeCheck(areaCode, 999, "area code");
		rangeCheck(prefix, 999, "prefix");
		rangeCheck(lineNumber, 9999, "line number");

		this.areaCode = (short) areaCode;
		this.prefix = (short) prefix;
		this.lineNumber = (short) lineNumber;
	}

	/**
	 * Checks if the value of argument out of the range [0, max]
	 * 
	 * @param arg
	 *            The argument to be checked
	 * @param max
	 *            Maximum value of the range
	 * @param name
	 *            The argument name for output error message
	 */
	private static void rangeCheck(int arg, int max, String name) {
		if (arg < 0 || arg > max) {
			throw new IllegalArgumentException(name + ": " + arg);
		}
	}

	/**
	 * Compares this phone number to the specified object. The result is true if
	 * and only if the argument is not null and is a PhoneNumber object that its
	 * value is same as this object.
	 * 
	 * @param The
	 *            object to compare this PhoneNumber against
	 * 
	 * @return true if the given object represents a PhoneNumber equivalent to
	 *         this PhoneNumber, false otherwise
	 */
	@Override
	public boolean equals(Object object) {

		// check if object is a reference to PhoneNumber
		if (object == this) {
			return true;
		}
		// check if object is an instance of PhoneNumber
		if (!(object instanceof PhoneNumber)) {
			return false;
		}
		// case object to PhoneNumber
		PhoneNumber phoneNumber = (PhoneNumber) object;
		return phoneNumber.lineNumber == lineNumber
				&& phoneNumber.prefix == prefix
				&& phoneNumber.areaCode == areaCode;
	}

	/**
	 * Returns a hash code for this phone number.
	 * 
	 * @return a hash code value for this object.
	 */
	@Override
	public int hashCode() {
		int result = 17;
		result = 31 * result + areaCode;
		result = 31 * result + prefix;
		result = 31 * result + lineNumber;
		return result;
	}

	/**
	 * Defines this object toString format.
	 * 
	 * @return a string represents phone number in the following format:
	 *         "areaCode-prefix-lineNumber"
	 */
	@Override
	public String toString() {
		return areaCode + "-" + prefix + "-" + lineNumber;
	}

	/**
	 * Sets a new area code.
	 * 
	 * @param areaCode
	 *            A number represents area code. Should in range [0,999],
	 *            otherwise throw IllegalArgumentException
	 */
	public void setAreaCode(int areaCode) {
		rangeCheck(areaCode, 999, "area code");
		this.areaCode = (short) areaCode;
	}

	/**
	 * Sets a new prefix.
	 * 
	 * @param prefix
	 *            A number represents prefix. Should in range [0,999], otherwise
	 *            throw IllegalArgumentException
	 */
	public void setPrefix(int prefix) {
		rangeCheck(prefix, 999, "prefix");
		this.prefix = (short) prefix;
	}

	/**
	 * Sets a new line number.
	 * 
	 * @param lineNumber
	 *            A number represents line number. Should in range [0,999],
	 *            otherwise throw IllegalArgumentException
	 */
	public void setLineNumber(int lineNumber) {
		rangeCheck(lineNumber, 9999, "line number");
		this.lineNumber = (short) lineNumber;
	}

	/**
	 * Gets the area code.
	 * 
	 * @return area code
	 */
	public short getAreaCode() {
		return areaCode;
	}

	/**
	 * Gets the prefix.
	 * 
	 * @return prefix
	 */
	public short getPrefix() {
		return prefix;
	}

	/**
	 * Gets the line number.
	 * 
	 * @return line number
	 */
	public short getLineNumber() {
		return lineNumber;
	}

	/**
	 * Gets the entire phone number
	 * 
	 * @return phone number
	 */
	public long getPhoneNumber() {
		return (long) (areaCode * Math.pow(10, 7) + prefix * Math.pow(10, 4) + lineNumber);
	}
}
