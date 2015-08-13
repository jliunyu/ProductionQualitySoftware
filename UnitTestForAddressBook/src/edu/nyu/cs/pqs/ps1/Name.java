package edu.nyu.cs.pqs.ps1;

/**
 * Name Class is for creating name object in address book entry. Name object
 * accepts three fields to create an name: first name, middle name, and last
 * name. First name field is required, cannot be empty, others are optional.
 * Builder Pattern is used in designing this class.
 * 
 * Two names are equal if and only if their non-empty fields are equivalent. The
 * equals method implements an equivalence relation.
 * 
 * The toString format of the object name is "firstName middleName lastName".
 * 
 * @author yixia
 * 
 */
public class Name {

	private String firstName;
	private String middleName;
	private String lastName;

	/**
	 * The Class Builder used as builder of Name class. Use Builder Pattern
	 * here.
	 * 
	 */
	public static class Builder {

		// Required parameter
		private String firstName;

		// optional parameters - initialized to default values
		private String middleName = "";
		private String lastName = "";

		/**
		 * Fix the problem if input parameter is empty.
		 * 
		 * @param field
		 *            The input field
		 * @return field if not empty; otherwise return ""
		 */
		private static String fixEmpty(String field) {
			if (field == null || field.length() == 0) {
				return "";
			} else {
				return field;
			}
		}

		/**
		 * Constructs a new builder object with required parameter firstName
		 * 
		 * @param firstName
		 *            required field firstName
		 * @throws FormatException
		 *             if first name is empty
		 */
		public Builder(String firstName) throws FormatException {
			if (firstName.length() == 0 || firstName == null) {
				throw new FormatException("First Name cannot be empty!");
			}
			this.firstName = firstName;
		}

		/**
		 * The builder's setter method for optional parameter middleName
		 * 
		 * @param middleName
		 *            optional field meddleName
		 * @return the builder itself
		 */
		public Builder middleName(String middleName) {
			this.middleName = fixEmpty(middleName);
			return this;
		}

		/**
		 * The builder's setter method for optional parameter lastName
		 * 
		 * @param lastName
		 *            optional field meddleName
		 * @return the builder itself
		 */
		public Builder lastName(String lastName) {
			this.lastName = fixEmpty(lastName);
			return this;
		}

		/**
		 * builds an instance of Name
		 * 
		 * @return an instance of Name
		 */
		public Name build() {
			return new Name(this);
		}
	}

	/**
	 * Instantiates a new contact name.
	 * 
	 * @param builder
	 *            The builder pattern
	 */
	private Name(Builder builder) {
		this.firstName = builder.firstName;
		this.middleName = builder.middleName;
		this.lastName = builder.lastName;
	}

	/**
	 * Compares this name to the specified object. The result is true if and
	 * only if the argument is a Name object and its non-empty fields that
	 * represent the same sequence of characters as this object.
	 * 
	 * @param object
	 *            The object to compare this Name against
	 * 
	 * @return true if the given object represents a Name equivalent to this
	 *         Name, false otherwise
	 */
	@Override
	public boolean equals(Object object) {

		// check if object is a reference to Name
		if (object == this) {
			return true;
		}
		// check if object is an instance of Name
		if (!(object instanceof Name)) {
			return false;
		}
		// case object to Name
		Name name = (Name) object;
		// compare non-empty field
		if (name.middleName.length() != 0
				&& (!name.middleName.equals(middleName))) {
			return false;
		} else if (name.lastName.length() != 0
				&& (!name.lastName.equals(lastName))) {
			return false;
		} else {
			// firstName is required, cannot be empty
			return name.firstName.equals(firstName);
		}
	}

	/**
	 * Returns a hash code for this name.
	 * 
	 * @return a hash code value for this object.
	 */
	@Override
	public int hashCode() {
		int result = 17;
		result = 31 * result + firstName.hashCode();
		result = 31 * result + middleName.hashCode();
		result = 31 * result + lastName.hashCode();
		return result;
	}

	/**
	 * Defines this object toString format.
	 * 
	 * @return a string in the format of "firstName middleName lastName"
	 */
	@Override
	public String toString() {
		return firstName + " " + middleName + " " + lastName;
	}

	/**
	 * Sets the first name.
	 * 
	 * @param firstName
	 *            the new first name
	 * @throws FormatException
	 *             if first name is empty
	 */
	public void setFirstName(String firstName) throws FormatException {
		if (firstName.length() == 0 || firstName == null) {
			throw new FormatException("First Name cannot be empty!");
		} else {
			this.firstName = firstName;
		}
	}

	/**
	 * Sets the middle name.
	 * 
	 * @param middleName
	 *            the new middle name
	 */
	public void setMiddleName(String middleName) {
		this.middleName = Builder.fixEmpty(middleName);
	}

	/**
	 * Sets the last name.
	 * 
	 * @param lastName
	 *            the new last name
	 */
	public void setLastName(String lastName) {
		this.lastName = Builder.fixEmpty(lastName);
	}

	/**
	 * Gets the first name of contact.
	 * 
	 * @return the first name String
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Gets the middle name of contact.
	 * 
	 * @return the middle name String
	 */
	public String getMiddleName() {
		return middleName;
	}

	/**
	 * Gets the last name of contact.
	 * 
	 * @return the last name String
	 */
	public String getLastName() {
		return lastName;
	}
}
