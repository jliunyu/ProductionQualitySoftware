package edu.nyu.cs.pqs.ps1;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * TestPhoneNumber Class is for testing PhoneNumber object. 
 * It could test getAreaCode, getPrefix, getLineNumber and getPhoneNUmber methods
 * It also could test the toString, hashCode, equals methods
 * 
 * @author Jing Liu
 * 
 */
public class TestPhoneNumber {
	private PhoneNumber phoneNumber;
	private int areaCode = 111;
	private int prefix = 222;
	private int lineNumber = 2222;
	
	/**
	 * build a phoneNumber object
	 * @throws FormatException
	 */
	@Before
	public void setUp() throws FormatException {
		phoneNumber = new PhoneNumber(areaCode, prefix, lineNumber);
	}

	@After
	public void tearDown() {		
	}
	
/**
 * test Whether the getAreaCode method can get excepted result
 */
	@Test
	public void testgetAreaCode() {
		phoneNumber.setAreaCode(areaCode);
		assertEquals(areaCode, phoneNumber.getAreaCode());
	}
	
	/**
	 * test Whether the getPrefix method can get excepted result
	 */
	@Test
	public void testgetPrefix(){		
		phoneNumber.setPrefix(prefix);
		assertEquals(prefix, phoneNumber.getPrefix());
	}
	
	/**
	 * test Whether the getLineNumber method can get excepted result
	 */
	@Test
	public void testgetLineNumber(){
		phoneNumber.setLineNumber(lineNumber);
		assertEquals(lineNumber, phoneNumber.getLineNumber());
	}
	
	/**
	 * test Whether the getPhoneNumber method can get excepted result
	 */
	@Test 
	public void testgetPhoneNumber(){
		assertEquals((long)(areaCode * Math.pow(10, 7) + prefix * Math.pow(10, 4) + lineNumber), phoneNumber.getPhoneNumber());
	}
	
	/**
	 * test Whether the equals method can get excepted result
	 */
	@Test 
	public void testEquals(){	
		Assert.assertTrue(new PhoneNumber(areaCode, prefix, lineNumber).equals(phoneNumber));
	}
	
	/**
	 * test Whether the hashCode method can get excepted result
	 */
	@Test 
	public void testHashCode(){		
		PhoneNumber number = new PhoneNumber(areaCode, prefix, lineNumber);
		Assert.assertTrue(number.equals(phoneNumber) && phoneNumber.equals(number));
		Assert.assertTrue(number.hashCode() == phoneNumber.hashCode());
	}
	
	/**
	 * test Whether the toString method can get excepted result
	 */
	@Test
	public void testToString(){
		assertEquals(areaCode + "-" + prefix + "-" + lineNumber, phoneNumber.toString());
	}
}


