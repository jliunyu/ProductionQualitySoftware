package edu.nyu.cs.pqs.ps1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * AddressBook Class is for creating address book object. The AddressBook object
 * can add or remove an address book entry, search for an entry by any of the
 * contact properties or the entire contact information, and also read from a
 * txt file or save data to a txt file.
 * 
 * @author yixia
 * 
 */
public class AddressBook {

	/**
	 * The address book contains list of entries.
	 */
	private List<Entry> addressBook;

	/**
	 * Initializes a newly created AddressBook object so that it represents an
	 * empty address book.
	 */
	public AddressBook() {
		this.addressBook = new LinkedList<Entry>();
	}

	/**
	 * Appends the specified entry to the end of this address book entry list
	 * 
	 * @param entry
	 *            entry to be appended to this address book entry list
	 * @return true if added successful; false otherwise
	 */
	public boolean addEntry(Entry entry) {
		return addressBook.add(entry);
	}

	/**
	 * Search entry by entire entry information
	 * 
	 * @param searchEntry
	 *            The entry to be searched
	 * @return list of search results
	 */
	public List<Entry> searchEntry(Entry searchEntry) {

		// list to store matching searching results
		List<Entry> searchResults = new LinkedList<Entry>();
		for (Entry entry : addressBook) {
			if (entry.equals(searchEntry)) {
				searchResults.add(entry);
			}
		}
		return searchResults;
	}

	/**
	 * Search entry by contact name
	 * 
	 * @param searchEntry
	 *            The name to be searched
	 * @return list of search results
	 */
	public List<Entry> searchEntry(Name name) {

		// list to store matching searching results
		List<Entry> searchResults = new LinkedList<Entry>();
		for (Entry entry : addressBook) {
			if (entry.getName().equals(name)) {
				searchResults.add(entry);
			}
		}
		return searchResults;
	}

	/**
	 * Search entry by phone number
	 * 
	 * @param searchEntry
	 *            The phone number to be searched
	 * @return list of search results
	 */
	public List<Entry> searchEntry(PhoneNumber phoneNumber) {

		// list to store matching searching results
		List<Entry> searchResults = new LinkedList<Entry>();
		for (Entry entry : addressBook) {
			if (entry.getPhoneNumber().equals(phoneNumber)) {
				searchResults.add(entry);
			}
		}
		return searchResults;
	}

	/**
	 * Search entry by email address
	 * 
	 * @param searchEntry
	 *            The email address to be searched
	 * @return list of search results
	 */
	public List<Entry> searchEntry(EmailAddress emailAddress) {

		// list to store matching searching results
		List<Entry> searchResults = new LinkedList<Entry>();
		for (Entry entry : addressBook) {
			if (entry.getEmailAddress().equals(emailAddress)) {
				searchResults.add(entry);
			}
		}
		return searchResults;
	}

	/**
	 * Search entry by postal address
	 * 
	 * @param searchEntry
	 *            The postal address to be searched
	 * @return list of search results
	 */
	public List<Entry> searchEntry(PostalAddress postalAddress) {

		// list to store matching searching results
		List<Entry> searchResults = new LinkedList<Entry>();
		for (Entry entry : addressBook) {
			if (entry.getPostalAddress().equals(postalAddress)) {
				searchResults.add(entry);
			}
		}
		return searchResults;
	}

	/**
	 * Search entry by note
	 * 
	 * @param searchEntry
	 *            The note to be searched
	 * @return list of search results
	 */
	public List<Entry> searchEntry(Note note) {

		// list to store matching searching results
		List<Entry> searchResults = new LinkedList<Entry>();
		for (Entry entry : addressBook) {
			if (entry.getNote().equals(note)) {
				searchResults.add(entry);
			}
		}
		return searchResults;
	}

	/**
	 * Removes the first occurrence of the specified entry from this address
	 * book, if it is present.
	 * 
	 * @param entry
	 *            the entry to be removed
	 * @return true if the entry has been removed successfully; false otherwise.
	 */
	public boolean removeEntry(Entry entry) {
		return addressBook.remove(entry);
	}

	/**
	 * Defines this object toString format.
	 * 
	 * @return a string in the format of "entry1 \n entry2 \n entry3 ......"
	 */
	@Override
	public String toString() {
		String resultString = "";
		for (Entry entry : addressBook) {
			resultString += entry.toString();
		}
		return resultString;
	}

	/**
	 * Save address book information to text file.
	 * 
	 * @param file
	 *            The file contains its path and file name
	 * @throws IOException
	 *             when IOException occurs
	 */
	public void saveAddressBookToFile(File file) throws IOException {
		FileWriter fileWriter;
		BufferedWriter bufferedWriter = null;
		try {
			// open file and set fileStream
			fileWriter = new FileWriter(file);
			bufferedWriter = new BufferedWriter(fileWriter);
			// iterate AddressBookEntry
			for (Entry entry : addressBook) {
				// write to file
				bufferedWriter.write(entry.toString());
			}
			bufferedWriter.flush();
		} catch (IOException e) {
			bufferedWriter.close();
		}
		bufferedWriter.close();
	}

	/**
	 * Read address book information from a text file.
	 * 
	 * @param file
	 *            the file that indicates the file name that contains entry list
	 * @throws Exception
	 *             thrown name is empty, or other fields of entry doesn't meet
	 *             format requirement
	 */
	public void readAddressBookFromFile(File file) throws Exception {
		// create text file scanner
		Scanner txtScanner = null;
		try {
			txtScanner = new Scanner(file);
		} catch (FileNotFoundException e) {
		}
		// create oneEntry to store an entry of contact
		String[] oneEntry = { "", "", "", "", "" };
		// create nameArray to store name fields: first, middle, last
		String[] nameArray = { "", "", "" };
		// create phoneNumberArray to store phone number fields: area code,
		// prefix, line code
		String[] phoneNumberArray = { "", "", "" };
		// create postalAddressArray to store postal address fields
		String[] postalAddressArray = { "", "", "", "", "" };
		// if not reached the end of file
		while (txtScanner.hasNext()) {
			// read a line from file to entry and then split it by ";", -1 means
			// preserve empty value
			oneEntry = txtScanner.next().split(";", -1);
			// oneEntry[0] contains name, a required field of contact
			if (oneEntry[0] == null) {
				throw new NullPointerException("Name cannot be empty!");
			}
			// split the name field according to " "
			nameArray = oneEntry[0].split(" ", -1);
			// create Name instance
			Name name = new Name.Builder(nameArray[0]).build();
			// set optional name fields
			name.setMiddleName(nameArray[1]);
			name.setLastName(nameArray[2]);
			// create entry instance
			Entry entry = new Entry.Builder(name).build();
			// if phone number exists for this entry
			if (oneEntry[1].length() != 0) {
				phoneNumberArray = oneEntry[1].split("-", -1);
				PhoneNumber phoneNumber = new PhoneNumber(
						Integer.valueOf(phoneNumberArray[0]),
						Integer.valueOf(phoneNumberArray[1]),
						Integer.valueOf(phoneNumberArray[2]));
				entry.setPhoneNumber(phoneNumber);
			}
			// if email address exists for this entry
			if (oneEntry[2].length() != 0) {
				EmailAddress emailAddress = new EmailAddress(oneEntry[2]);
				entry.setEmailAddress(emailAddress);
			}
			// if postal address exits for this entry
			if (oneEntry[3].length() != 0) {
				postalAddressArray = oneEntry[3].split(",", -1);
				// create PostalAddress instance use builder patter
				PostalAddress postalAddress = new PostalAddress.Builder()
						.street(URLDecoder.decode(postalAddressArray[0],
								"UTF-8")).city(postalAddressArray[1])
						.state(postalAddressArray[2])
						.zip(postalAddressArray[3])
						.country(postalAddressArray[4]).build();
				entry.setPostalAddress(postalAddress);
			}
			// if note field exits for this entry
			if (oneEntry[4].length() != 0) {
				// decode note
				Note note = new Note(URLDecoder.decode(oneEntry[4], "UTF-8"));
				entry.setNote(note);
			}
			// add entry
			addEntry(entry);
		}
		// close file
		txtScanner.close();
	}

}
