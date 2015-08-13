package edu.nyu.cs.pqs.ps1;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;
import org.junit.After;

/**
 * TestEntry Class is for testing entry object. 
 * It could test getName, getPhoneNumber, getEmailAddress, getPostalAddress, getNote methods
 * It also could test the toString, hashCode, equals methods
 * 
 * @author Jing Liu
 * 
 */
public class TestEntry {
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
	private String state = "New Jersy";
	private String zip = "07310";
	private String country = "United States";
	private Note note;
	private String noteText = "NYU student";
	
	/**
	 * build entry object
	 * @throws FormatException
	 */
	@Before
	public void setUp() throws FormatException {
		name = new Name.Builder(firstName).middleName(middleName).lastName(lastName).build();
		phoneNumber = new PhoneNumber(areaCode, prefix, lineNumber);
		emailAddress = new EmailAddress(email);
		postalAddress = new PostalAddress.Builder().street(street).city(city).state(state).country(country).zip(zip).build();
		note = new Note(noteText);
		entry = new Entry.Builder(name).phoneNumber(phoneNumber).emailAddress(emailAddress).postalAddress(postalAddress).note(note).build();
	}
	
	@After
	public void tearDown() {		
	}

	/**
	 * test whether the getName method can get the excepted result
	 * @throws FormatException
	 */
	@Test
	public void testGetName() throws FormatException {
		
		entry.setName(name);
		if (name == null){
			throw new FormatException("Name cannot be empty");
		}
		assertEquals(name, entry.getName());
	}
	
	/**
	 * test whether getPhoneNumber method can get excepted result
	 */
	@Test
	public void testGetPhoneNumber(){
		entry.setPhoneNumber(phoneNumber);
		assertEquals(phoneNumber, entry.getPhoneNumber());
	}
	
	/**
	 * test whether getEmailAddress method can get excepted result
	 */
	@Test 
	public void testGetEmailAddress(){
		entry.setEmailAddress(emailAddress);
		assertEquals(emailAddress, entry.getEmailAddress());
	}
	
	/**
	 * test whether the getPostalAddress method can get the excepted result
	 * @throws FormatException
	 */
	@Test
	public void testPostalAddress() throws FormatException{
		entry.setPostalAddress(postalAddress);
		assertEquals(postalAddress, entry.getPostalAddress());
	}
	
	/**
	 * test whether getNote method can get excepted result
	 */
	@Test
	public void testGetNote(){
		entry.setNote(note);
		assertEquals(note, entry.getNote());
	}
	
	/**
	 * test whether toString method can get excepted result
	 */
	@Test
	public void testToString(){
		assertEquals(name.toString() + ";" + phoneNumber.toString() + ";" + emailAddress.toString() + ";" + postalAddress.toString() + ";" + note.toString() + "\n", entry.toString());
	}
	
	/**
	 * test whether equals method can get excepted result
	 * @throws FormatException
	 */
	@Test
	public void testEquals() throws FormatException{
		Name name1;
		name1 = new Name.Builder("Jing").middleName("zhao").lastName("Liu").build();
		PhoneNumber phoneNumber1 = new PhoneNumber(123,456,7890);
		EmailAddress emailAddress1 = new EmailAddress("jl5311@nyu.edu");
		PostalAddress postalAddress1 = new PostalAddress.Builder().street("35 river dr s").city("Jersey City").state("NJ").country("United States").zip("07310").build();
		Note note1 = new Note("NYU student");
		Entry entry1 = entry = new Entry.Builder(name1).phoneNumber(phoneNumber1).emailAddress(emailAddress1).postalAddress(postalAddress1).note(note1).build();
		Assert.assertTrue(entry.equals(entry1) && entry1.equals(entry));
		
		Name name2;
		name2 = new Name.Builder("Jing").middleName("zhao").lastName("Liu").build();	
		PhoneNumber phoneNumber2 = new PhoneNumber(123,456,7890);	
		EmailAddress emailAddress2 = new EmailAddress("jl5311@nyu.edu");
		PostalAddress postalAddress2 = new PostalAddress.Builder().street("35 river dr s").city("Jersey City").state("NJ").country("United States").zip("07310").build();
		Note note2 = new Note("NYU student");
		Entry entry2 = entry = new Entry.Builder(name2).phoneNumber(phoneNumber2).emailAddress(emailAddress2).postalAddress(postalAddress2).note(note2).build();
		Assert.assertTrue(entry2.equals(entry1) && entry1.equals(entry2));
	}
	
	/**
	 * test whether hashCode method can get excepted result
	 * @throws FormatException
	 */
	@Test
	public void testHastCode() throws FormatException{	
		Name name1;
		name1 = new Name.Builder("Jing").middleName("zhao").lastName("Liu").build();
		PhoneNumber phoneNumber1 = new PhoneNumber(123,456,7890);
		EmailAddress emailAddress1 = new EmailAddress("jl5311@nyu.edu");
		PostalAddress postalAddress1 = new PostalAddress.Builder().street("35 river dr s").city("Jersey City").state("NJ").country("United States").zip("07310").build();		
		Note note1 = new Note("NYU student");
		Entry entry1 = entry = new Entry.Builder(name1).phoneNumber(phoneNumber1).emailAddress(emailAddress1).postalAddress(postalAddress1).note(note1).build();

		Assert.assertTrue(entry.equals(entry1) && entry1.equals(entry));
		Assert.assertTrue(entry.hashCode() == entry1.hashCode());
	}
}
