package edu.nyu.cs.pqs.ps1;

/**
 * Entry Class is for creating entry object in address book. Entry object
 * accepts five fields to create an entry: name, phone number, email address,
 * postal address and note. Name field is required, cannot be empty, others are optional. Builder
 * Pattern is used in designing this class.
 * 
 * Two entries are equal if and only if their non-empty fields are equivalent.
 * The equals method implements an equivalence relation.
 * 
 * @author yixia
 * 
 */
public class Entry {
	private Name name;
	private PostalAddress postalAddress;
	private PhoneNumber phoneNumber;
	private EmailAddress emailAddress;
	private Note note;

	/**
	 * The Class Builder used as builder of Name class. Use Builder Pattern
	 * here.
	 * 
	 */
	public static class Builder {

		// Required parameter
		private Name name;

		// optional parameters - initialized to default values
		private PhoneNumber phoneNumber = null;
		private EmailAddress emailAddress = null;
		private PostalAddress postalAddress = null;
		private Note note = null;

		/**
		 * Constructs a new builder object with required parameter Name
		 * 
		 * @param name
		 *            required field name
		 * @throws FormatException
		 *             if name is empty
		 */
		public Builder(Name name) throws FormatException {
			if (name == null) {
				throw new FormatException("First Name cannot be empty!");
			}
			this.name = name;
		}

		/**
		 * The builder's setter method for optional parameter phoneNumber
		 * 
		 * @param phoneNumber
		 *            optional field phoneNumber
		 * @return the builder itself
		 */
		public Builder phoneNumber(PhoneNumber phoneNumber) {
			this.phoneNumber = phoneNumber;
			return this;
		}

		/**
		 * The builder's setter method for optional parameter emailAddress
		 * 
		 * @param emailAddress
		 *            optional field emailAddress
		 * @return the builder itself
		 */
		public Builder emailAddress(EmailAddress emailAddress) {
			this.emailAddress = emailAddress;
			return this;
		}

		/**
		 * The builder's setter method for optional parameter postalAddress
		 * 
		 * @param postalAddress
		 *            optional field postalAddress
		 * @return the builder itself
		 */
		public Builder postalAddress(PostalAddress postalAddress) {
			this.postalAddress = postalAddress;
			return this;
		}

		/**
		 * The builder's setter method for optional parameter note
		 * 
		 * @param note
		 *            optional field note
		 * @return the builder itself
		 */
		public Builder note(Note note) {
			this.note = note;
			return this;
		}

		/**
		 * builds an instance of Entry
		 * 
		 * @return an instance of Entry
		 */
		public Entry build() {
			return new Entry(this);
		}
	}

	/**
	 * Instantiates a new entry.
	 * 
	 * @param builder
	 *            The builder pattern
	 */
	private Entry(Builder builder) {
		this.name = builder.name;
		this.phoneNumber = builder.phoneNumber;
		this.emailAddress = builder.emailAddress;
		this.postalAddress = builder.postalAddress;
		this.note = builder.note;
	}

	/**
	 * Compares this entry to the specified object. The result is true if and
	 * only if the argument is an Entry object and its non-empty fields that
	 * represent the same sequence of characters as this object.
	 * 
	 * @param object
	 *            The object to compare this Entry against
	 * 
	 * @return true if the given object represents an Entry equivalent to this
	 *         Entry, false otherwise
	 */
	@Override
	public boolean equals(Object object) {

		// check if object is a reference to Entry
		if (object == this) {
			return true;
		}
		// check if object is an instance of Entry
		if (!(object instanceof Entry)) {
			return false;
		}
		// case object to Entry
		Entry entry = (Entry) object;
		// compare non-empty field
		if (entry.note != null && (!entry.note.equals(note))) {
			return false;
		} else if (entry.postalAddress != null
				&& (!entry.postalAddress.equals(postalAddress))) {
			return false;
		} else if (entry.emailAddress != null
				&& (!entry.emailAddress.equals(emailAddress))) {
			return false;
		} else if (entry.phoneNumber != null
				&& (!entry.phoneNumber.equals(phoneNumber))) {
			return false;
		} else {
			// name is required, cannot be empty
			return entry.name.equals(name);
		}
	}

	/**
	 * Returns a hash code for this entry.
	 * 
	 * @return a hash code value for this object.
	 */
	@Override
	public int hashCode() {
		int result = 17;
		result = 31 * result + name.hashCode();
		result = 31 * result + phoneNumber.hashCode();
		result = 31 * result + emailAddress.hashCode();
		result = 31 * result + postalAddress.hashCode();
		result = 31 * result + note.hashCode();
		return result;
	}

	/**
	 * Defines this object toString format.
	 * 
	 * @return a string in the format of
	 *         "name; phoneNumber; emailAddress; postalAddress; note"
	 */
	@Override
	public String toString() {
		String resultString = name.toString() + ";";
		if (phoneNumber != null)
			resultString += phoneNumber.toString();
		resultString += ";";
		if (emailAddress != null)
			resultString += emailAddress.toString();
		resultString += ";";
		if (postalAddress != null)
			resultString += postalAddress.toString();
		resultString += ";";
		if (note != null)
			resultString += note.toString();
		resultString += "\n";
		return resultString;
	}

	/**
	 * Sets the name.
	 * 
	 * @param name
	 *            the new contact name
	 * @throws FormatException
	 *             if contact name is null
	 */
	public void setName(Name name) throws FormatException {
		if (name == null)
			throw new FormatException("Name cannot be empty");
		this.name = name;
	}

	/**
	 * Sets the phone number.
	 * 
	 * @param phoneNumber
	 *            the new phone number
	 */
	public void setPhoneNumber(PhoneNumber phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * Sets the email address.
	 * 
	 * @param emailAddress
	 *            the new email address
	 */
	public void setEmailAddress(EmailAddress emailAddress) {
		this.emailAddress = emailAddress;
	}

	/**
	 * Sets the postal address.
	 * 
	 * @param postalAddress
	 *            the new postal address
	 */
	public void setPostalAddress(PostalAddress postalAddress) {
		this.postalAddress = postalAddress;
	}

	/**
	 * Sets the note.
	 * 
	 * @param note
	 *            the new note
	 */
	public void setNote(Note note) {
		this.note = note;
	}

	/**
	 * Gets the name.
	 * 
	 * @return the contact name
	 */
	public Name getName() {
		return name;
	}

	/**
	 * Gets the phone number.
	 * 
	 * @return the phone number
	 */
	public PhoneNumber getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Gets the email address.
	 * 
	 * @return the email address
	 */
	public EmailAddress getEmailAddress() {
		return emailAddress;
	}

	/**
	 * Gets the postal address.
	 * 
	 * @return the postal address
	 */
	public PostalAddress getPostalAddress() {
		return postalAddress;
	}

	/**
	 * Gets the note.
	 * 
	 * @return the note
	 */
	public Note getNote() {
		return note;
	}

}
