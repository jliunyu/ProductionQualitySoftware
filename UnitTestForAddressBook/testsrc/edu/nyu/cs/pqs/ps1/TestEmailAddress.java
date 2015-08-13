package edu.nyu.cs.pqs.ps1;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * TestEmailAddress Class is for testing EmailAddress object. 
 * It could test getEmailAddress, toString, hashCode and equals methods
 * 
 * @author Jing Liu
 * 
 */
public class TestEmailAddress {
	private EmailAddress emailAddress;
	private String email = "jl5311@nyu.edu";
	
	/**
	 * build a emailAddress object
	 * @throws FormatException
	 */
	@Before
	public void setUp() throws FormatException {
		emailAddress = new EmailAddress(email);
	}

	@After
	public void tearDown() {		
	}
	
	/**
	 * test whether the getEmailAddress method can get the excepted result
	 */
	@Test
	public void testgetEmailAddress() {
		emailAddress.setEmailAddress(email);
		assertEquals(email, emailAddress.getEmailAddress());		
	}
	
	/**
	 * test whether the toString method can get the excepted result
	 */
	@Test
	public void testToString(){
		assertEquals(email, emailAddress.toString());
	}
	
	/**
	 * test whether the hashCode method can get the excepted method
	 */
	@Test
	public void testHastCode(){		
		EmailAddress emailAddress1 = new EmailAddress(email);
		Assert.assertTrue(emailAddress1.equals(emailAddress) && emailAddress.equals(emailAddress1));
		Assert.assertTrue(emailAddress1.hashCode() == emailAddress.hashCode());
	}
	
	/**
	 * test whether the equals method can get the excepted method
	 */
	@Test 
	public void testEquals(){
		EmailAddress emailAddress1 = new EmailAddress(email);		
		Assert.assertTrue(emailAddress.equals(emailAddress1));
	}
}


