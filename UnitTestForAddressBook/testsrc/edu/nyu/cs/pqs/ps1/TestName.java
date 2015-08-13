package edu.nyu.cs.pqs.ps1;

import static org.junit.Assert.*; 

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * TestName Class is for testing Name object. 
 * It could test getFirstName, getMiddleName, getLastName methods
 * It also could test the toString, hashCode, equals methods
 * It even could test if the first name is null, whether the throws FormatException can works well
 * 
 * @author Jing Liu
 * 
 */
public class TestName {
	private Name name;
	String firstName = "Jing";
	String middleName = "zhao";
	String lastName = "Liu";
	Name.Builder builder;
	
	/**
	 * build a name object
	 * @throws FormatException
	 */
	@Before
	public void setUp() throws FormatException {
		name = new Name.Builder(firstName).middleName(middleName).lastName(lastName).build();
	}
	
	@After
	public void tearDown() {		
	}
	
	/**
	 * test whether the getFirstName method can get the excepted result
	 * @throws FormatException
	 */
	@Test
	public void testgetFirstName() throws FormatException {
		name.setFirstName(firstName);
		if (name == null){
			throw new FormatException("Name cannot be empty");
		}
		assertEquals("Jing", name.getFirstName());
	}
	
	/**
	 * test whether the getMiddleName method can get the excepted result
	 */
	@Test 
	public void testgetMiddleName(){
		name.setMiddleName(middleName);
		assertEquals("zhao", name.getMiddleName());
	}
	
	/**
	 * test whether the getLastName method can get the excepted result
	 */
	@Test
	public void testgetLastName(){
		name.setLastName(middleName);
		assertEquals("zhao", name.getLastName());
	}
	
/**
 * test whether the hashCode method can work well
 * @throws FormatException
 */
	@Test
	public void testHastCode() throws FormatException{	
		Name name1 = new Name.Builder("Jing").middleName("zhao").lastName("Liu").build();
		Assert.assertTrue(name.equals(name1) && name1.equals(name));
		Assert.assertTrue(name.hashCode() == name1.hashCode());
	}
	
	/**
	 * test whether the equals method can work well
	 * @throws FormatException
	 */
	@Test 
	public void testEquals() throws FormatException{
		Name name1 = new Name.Builder("Jing").middleName("zhao").lastName("Liu").build();
		Assert.assertTrue(name1.equals(name));
	}
	
	/**
	 * test whether the toString method can work well
	 */
	@Test
	public void testToString(){
		assertEquals("Jing zhao Liu", name.toString());
	}
	
	/**
	 * test if the firstName is null when build Name object, whether the throws FormatException can work well
	 * @throws FormatException
	 */
	@Test(expected = FormatException.class)
	public void testBuilderOfFormatExecption() throws FormatException{
		Name name1 = new Name.Builder("").build();
		name1.getFirstName();
	}
	
	/**
	 * test if the firstName is null when set firstName, whether the throws FormatException can work well
	 * @throws FormatException
	 */
	@Test(expected = FormatException.class)
	public void testNameOfFormatExecption() throws FormatException{
		Name name1 = new Name.Builder("Jing").build();
		name1.setFirstName("");
	}
	
}
