package edu.nyu.cs.pqs.ps1;

import static org.junit.Assert.*; 

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * TestPostalAddress Class is for testing TestPostalAddress object. 
 * It could test getStreet, getCity, getState, getCountry, getZip methods
 * It also could test the toString, hashCode, equals methods
 * 
 * @author Jing Liu
 * 
 */
public class TestPostalAddress {
	private PostalAddress postalAddress;
	private String street = "35 river dr s";
	private String city = "Jersey City";
	private String state = "NJ";
	private String zip = "07310";
	
	/**
	 * build a postalAddress
	 * @throws FormatException
	 */
	@Before
	public void setUp() throws FormatException {
		postalAddress = new PostalAddress.Builder().street(street).city(city).state(state).country("United States").zip(zip).build();
	}
	
	@After
	public void tearDown() {		
	}

	/**
	 * test whether the getCountry method can get the excepted result
	 */
	@Test
	public void testgetCountry() {
		postalAddress.setCountry("United States");
		assertEquals("United States", postalAddress.getCountry());
	}
	
	/**
	 * test whether the getState method can get the excepted result
	 */
	@Test
	public void testgetState(){
		postalAddress.setState(state);
		assertEquals("NJ", postalAddress.getState());
	}
	
	/**
	 * test whether the getCity method can get the excepted result
	 */
	@Test
	public void testgetCity(){		
		postalAddress.setCity(city);
		assertEquals("Jersey City", postalAddress.getCity());
	}
	
	/**
	 * test whether the getStreet method can get the excepted result
	 */
	@Test
	public void testgetStreet(){

		postalAddress.setStreet(street);
		assertEquals("35 river dr s", postalAddress.getStreet());
	}
	
	/**
	 * test whether the getZip method can get the excepted result
	 * @throws FormatException
	 */
	@Test
	public void testgetZip() throws FormatException{
		postalAddress.setzip(zip);
		assertEquals("07310", postalAddress.getZip());
	}
	
	/**
	 * test whether the hashCode method can get the excepted result
	 */
	@Test
	public void testHastCode() throws FormatException{
		
		PostalAddress postalAddress1 = new PostalAddress.Builder().street("35 river dr s").city("Jersey City").state("NJ").country("United States").zip("07310").build();	
		Assert.assertTrue(postalAddress1.equals(postalAddress) && postalAddress.equals(postalAddress1));
		Assert.assertTrue(postalAddress1.hashCode() == postalAddress.hashCode());
	}
	
	/**
	 * test whether the toString method can get the excepted result
	 */
	@Test
	public void testToString(){
		assertEquals(street + ", " + city + ", " + state + " " + zip + ", " + "United States", postalAddress.toString());
	}
}
