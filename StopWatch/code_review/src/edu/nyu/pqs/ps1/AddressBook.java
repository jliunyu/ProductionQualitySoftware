/**
 * This class consists of methods typically used by an Address Book application
 * viz. creating a new Address Book, adding an entry to the Address Book, 
 * removing an entry to an Address Book, Searching an entry in the Address Book
 * based on a keyword, writing the contacts to a XML file & reading from
 * the XML file into the Address Book
 * 
 * @author Abhishek Sanghvi
 */
package edu.nyu.pqs.ps1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.xml.sax.SAXException;

public class AddressBook {

	private static final AddressBook INSTANCE = new AddressBook();
	private ArrayList<Entry> addressBook;

	private AddressBook() {
	}

	/**
	 * Returns the instance of AddressBook
	 * @return AddressBook singleton instance
	 */
	public static AddressBook getInstance() {
		return  INSTANCE;
	}

	/**
	 * This method is used to create a new Address Book
	 * 
	 * 
	 */
	public void createAddressBook() {
		addressBook= new ArrayList<Entry> ();
	}

	/**
	 * This method is used to add an entry into the address book. It takes as 
	 * input an object of the Entry class
	 * @param entry
	 * @throws NullPointerException if entry is null
	 */
	public boolean addEntry(Entry entry) throws NullPointerException{
		if (entry == null) {
			throw new NullPointerException ("Entry is null");
		}
		return addressBook.add(entry);
	}

	/**
	 * This method is used to remove an entry from an address book. it takes
	 * as input an object of the Entry class
	 * @param entry
	 * @throws NullPointerException if entry is null
	 */
	public boolean removeEntry(Entry entry)throws NullPointerException {
		if (entry == null) {
			throw new NullPointerException("Entry is null");
		}
		return addressBook.remove(entry); 
	}

	/**
	 * This method is used to search an entry into an address book
	 * based on any of the properties of the Entry object 
	 * @param String which is the keyword that needs to be searched
	 * @return List of all the matching entries corresponding to the keyword
	 * 
	 */
	public ArrayList<Entry> searchEntry(String keyword) {
		ArrayList<Entry> searchResult = new ArrayList<Entry> ();
		for (Entry entry: addressBook)    {

			/*
			 * It picks up each entry of the address book and then compares 
			 * each of its properties with the keyword starting from name,
			 *  address, phone no, email and lastly note
			 */
			if (entry.getName().toLowerCase().startsWith
					(keyword.toLowerCase()))
			{ searchResult.add(entry); }
			else if   (entry.getAddress().toLowerCase().startsWith
					(keyword.toLowerCase()))
			{ searchResult.add(entry); }
			else if   ((""+entry.getPhoneNo()).toLowerCase().startsWith
					(keyword.toLowerCase()))
			{ searchResult.add(entry); }
			else if   (entry.getEmail().toLowerCase().startsWith
					(keyword.toLowerCase()))
			{ searchResult.add(entry); }
			else if   (entry.getAddress().toLowerCase().startsWith
					(keyword.toLowerCase()))
			{ searchResult.add(entry); }
		}
		return searchResult;
	}

	/**
	 *  This method writes the Address Book to a XML file
	 * @throws IOException
	 * @throws TransformerException
	 * @throws ParserConfigurationException
	 */
	public void writeToFile() 
			throws IOException, TransformerException,
			ParserConfigurationException {
		XMLReaderWriter XMLrw= new XMLReaderWriter();
		XMLrw.XMLWrite(addressBook);
	}

	/**
	 * This Method reads the data from the XML file and places it in the 
	 * Address Book
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws SAXException
	 * @throws ParserConfigurationException
	 */
	public void readFromFile() 
			throws FileNotFoundException, IOException, 
			SAXException, ParserConfigurationException {
		
		XMLReaderWriter XMLrw= new XMLReaderWriter();
		addressBook=XMLrw.XMLRead();
	}

}
