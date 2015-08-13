package edu.nyu.cs.pqs.ps1;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * TestNote Class is for testing Note object. 
 * It could test getNote method
 * It also could test the toString, hashCode, equals methods
 * 
 * @author Jing Liu
 * 
 */
public class TestNote {
	private Note note;
	private String noteText = "Student";
	
	/**
	 * build a note object
	 * @throws FormatException
	 */
	@Before
	public void setUp() throws FormatException {
		note = new Note(noteText);
	}

	@After
	public void tearDown() {		
	}
	
	/**
	 * test whether getNote method can get the right result
	 */
	@Test
	public void testgetNote() {
		note.setNote(noteText);
		assertEquals(noteText, note.getNote());	
		note.setNote("");
		note.setNote(null);
	}
	
	/**
	 * test whether toString method can get the right result
	 */
	@Test
	public void testToString(){
		assertEquals(noteText, note.toString());
	}
	
	/**
	 * test whether hashCode method can get the right result
	 */
	@Test
	public void testHastCode(){
		Note note1 = new Note("NYU student");
		Note note2 = new Note("NYU student");
		Assert.assertTrue(note1.equals(note2) && note2.equals(note1));
		Assert.assertTrue(note1.hashCode() == note2.hashCode());
	}
	
	/**
	 * test whether equals method can get the right result
	 */
	@Test 
	public void testEquals() throws FormatException{
		Note note1 = new Note("Student");		
		Assert.assertTrue(note1.equals(note));
	}
}


