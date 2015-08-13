package edu.nyu.pqs.ps1;

/**
 * Class for each entry in the AddressBook. Each entry contains
 * a name, address, phoneNo, email & note.
 * phoneNo is initialized to 0 while the rest are initialized to null
 * @author Abhishek Sanghvi
 *
 */


public class Entry {

	private final String name;
	private final String address;
	private final long phoneNo;
	private final String email;
	private final String note;
	private volatile int hashCode;

	/**
	 * Getter method for name
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Getter method for address
	 * @return address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Getter method for phoneNo
	 * @return phoneNo
	 */
	public long getPhoneNo() {
		return phoneNo;
	}

	/**
	 *  Getter method for email
	 * @return email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * Getter method for note
	 * @return note
	 */
	public String getNote() {
		return note;
	}

	/*
	 * 
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Name: "+getName()+"\nAddress: "+getAddress()+"\nPhone No: "
				+getPhoneNo()+"\nEmail: "+getEmail()+"\nNote: "+getNote();

	}

	/*
	 * 
	 * 
	 * @see java.lang.Object#equals()
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entry other = (Entry) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (note == null) {
			if (other.note != null)
				return false;
		} else if (!note.equals(other.note))
			return false;
		if (phoneNo != other.phoneNo)
			return false;
		return true;
	}

	/*
	 * 
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override 
	public int hashCode() {
		int result = hashCode;
		if (result == 0) {
			result = 17;
			result = 31 * result + name.hashCode();
			result = 31 * result + address.hashCode();
			result = 31 * result + (int) (phoneNo ^ (phoneNo >>> 32));
			result = 31 * result + email.hashCode();
			result = 31 * result + note.hashCode();
			hashCode = result;
		}
		return result;
	}
	/**
	 * Builder pattern based class for building a new instance of Entry class
	 * @author Abhishek Sanghvi
	 *
	 */
	public static class EntryBuilder {

		// Optional parameters - initialized to default values
		private String name="";
		private String address="";
		private long phoneNo=0;
		private String email="";
		private String note="";


		/**
		 * Constructor for class EntryBuilder
		 */
		public EntryBuilder(){	}

		/**
		 * Setter for name
		 * @param name
		 * @return this name
		 */
		public EntryBuilder name(String name) {
			this.name = name; return this; }

		/**
		 * Setter for address
		 * @param address
		 * @return this address
		 */
		public EntryBuilder address(String address) { 
			this.address = address; return this; }

		/**
		 * Setter for phoneNo
		 * @param phoneNo
		 * @return this phoneNo
		 */
		public EntryBuilder phoneNo(long phoneNo) { 
			this.phoneNo = phoneNo; return this; }

		/**
		 * Setter for email
		 * @param email
		 * @return this email
		 */
		public EntryBuilder email(String email) { 
			this.email = email; return this; }

		/**
		 * Setter for note
		 * @param note
		 * @return this note
		 */
		public EntryBuilder note(String note) { 
			this.note = note; return this; }
		public Entry build() {
			return new Entry(this);
		}
	}

	private Entry(EntryBuilder builder) {
		name = builder.name;
		address = builder.address;
		phoneNo = builder.phoneNo;
		email = builder.email;
		note = builder.note;
	}

}