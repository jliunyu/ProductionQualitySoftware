package edu.nyu.cs.pqs.ps1;
import static org.junit.Assert.*;

import java.io.IOException;
import java.io.File;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * TestAddressBook Class is for testing AddressBook object. 
 * It could test addEntry, searchEntry according to entry, name, postal address, email address and note
 * It also could test the toString, hashCode, equals, save address book to a file, read address book from a file.
 * 
 * @author Jing Liu
 * 
 */
public class TestAddressBook {

	private AddressBook addressBook;
	private Entry entry;
	private Name name;
	private String firstName = "Jing";
	private String middleName = "zhao";
	private String lastName = "Liu";
	private PhoneNumber phoneNumber;
	private short areaCode = 123;
	private short prefix = 456;
	private short lineNumber = 7890;
	private EmailAddress emailAddress;
	private String email = "jl5311@nyu.edu";
	private PostalAddress postalAddress;
	private String street = "35 river dr s";
	private String city = "Jersey City";
	private String state = "New Jersey";
	private String zip = "07310";
	private String country = "United States";
	private Note note;
	private String noteText = "NYU student";
	
	/**
	 * build addressBook object, name object, phoneNumber object, emailAddress object, postalAddress object, note object
	 * @throws FormatException
	 */
	@Before
	public void setUp() throws FormatException {
		addressBook = new AddressBook();
		name = new Name.Builder(firstName).middleName(middleName).lastName(lastName).build();
		phoneNumber = new PhoneNumber(areaCode, prefix, lineNumber);
		emailAddress = new EmailAddress(email);
		postalAddress = new PostalAddress.Builder().street(street).city(city).state(state).country(country).zip(zip).build();
		note = new Note(noteText);
		entry = new Entry.Builder(name).phoneNumber(phoneNumber).emailAddress(emailAddress).postalAddress(postalAddress).note(note).build();
		addressBook.addEntry(entry);
	}
	
	@After
	public void tearDown() {		
	}
	
	/**
	 * test whether the searchEntry method whose parameter is Entry can get the excepted result
	 */
	@Test
	public void testsearchEntrybyEntry() {
		List<Entry> entryList = new LinkedList<Entry>();
		entryList.add(entry);
		assertEquals(entryList, addressBook.searchEntry(entry));
	}
	
	/**
	 * test whether the searchEntry method whose name is Entry can get the excepted result
	 */
	@Test
	public void testsearchEntrybyName() {
		List<Entry> entryList = new LinkedList<Entry>();
		entryList.add(entry);
		assertEquals(entryList, addressBook.searchEntry(name));	
		}
	
	/**
	 * test whether the searchEntry method whose parameter is phoneNumber can get the excepted result
	 */
	@Test
	public void testsearchEntrybyPhoneNumber() {
		List<Entry> entryList = new LinkedList<Entry>();
		entryList.add(entry);
		assertEquals(entryList, addressBook.searchEntry(phoneNumber));	
		}
	
	/**
	 * test whether the searchEntry method whose parameter is emailAddress can get the excepted result
	 */
	@Test
	public void testsearchEntrybyEmailAddress() {
		List<Entry> entryList = new LinkedList<Entry>();
		entryList.add(entry);
		assertEquals(entryList, addressBook.searchEntry(emailAddress));	
		}
	
	/**
	 * test whether the searchEntry method whose parameter is postalAddress can get the excepted result
	 */
	@Test
	public void testsearchEntrybyPostalAddress() {
		List<Entry> entryList = new LinkedList<Entry>();
		entryList.add(entry);
		assertEquals(entryList, addressBook.searchEntry(postalAddress));		
		}
	
	/**
	 * test whether the searchEntry method whose parameter is note can get the excepted result
	 */
	@Test
	public void testsearchEntrybyNote() {
		List<Entry> entryList = new LinkedList<Entry>();
		entryList.add(entry);
		assertEquals(entryList, addressBook.searchEntry(note));		
		}
	
	/**
	 * test whether the toString method can get the excepted result
	 */
	@Test
	public void testToString(){
		assertEquals("Jing zhao Liu;123-456-7890;jl5311@nyu.edu;35 river dr s, Jersey City, New Jersey 07310, United States;NYU student\n", addressBook.toString());
	}
	
	/**
	 * test whether Save method can get the excepted result
	 * @throws IOException
	 */
	@Test 
	public void testSave() throws IOException{
		File file = new File("/Users/jingliu/Documents/Study/PQS/text1.txt");
		addressBook.saveAddressBookToFile(file);
	}
	
	/**
	 * test whether the read method can get the excepted result
	 * @throws Exception
	 */
	@Test
	public void testRead() throws Exception{
		File testFileName = new File("/Users/jingliu/Documents/Study/PQS/text.txt");
		addressBook.readAddressBookFromFile(testFileName);
		
		AddressBook addressBook1 = new AddressBook();
		Entry entry1 = new Entry.Builder(name).phoneNumber(phoneNumber).emailAddress(emailAddress).postalAddress(postalAddress).note(note).build();

		addressBook1.addEntry(entry1);
		assertEquals(addressBook1, addressBook);		
	}
	
	/**
	 * test whether the removeEntry method can get the excepted result
	 */
	@Test
	public void testremoveEntry() {
		assertEquals(true, addressBook.removeEntry(entry));		
	}
	
	/**
	 * test if the file for read is not existing, whether the throws Exception can work well
	 * @throws Exception
	 */
	@Test(expected = Exception.class)
	public void testReadOfFormatExecption() throws Exception {
		File testFileName = new File("/Users/jingliu/Documents/Study/PQS/text3.txt");
		addressBook.readAddressBookFromFile(testFileName);		
	}	
}
