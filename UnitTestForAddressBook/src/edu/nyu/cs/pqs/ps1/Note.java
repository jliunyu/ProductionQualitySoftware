package edu.nyu.cs.pqs.ps1;

/**
 * Note Class is for creating note object in address book entry.
 * 
 * Two notes are equal if and only if their string value are equivalent. The
 * equals method implements an equivalence relation.
 * 
 * @author yixia
 * 
 */
public class Note {

	private String noteText;

	/**
	 * Constructs a new Note with the parameter noteText
	 * 
	 * @param noteText
	 */
	public Note(String noteText) {
		this.noteText = fixEmpty(noteText);
	}

	/**
	 * Compares this note to the specified object. The result is true if and
	 * only if the argument is a Note object and its fields that represent the
	 * same sequence of characters as this object.
	 * 
	 * @param object
	 *            The object to compare this Note against
	 * 
	 * @return true if the given object represents a Note equivalent to this
	 *         Note, false otherwise
	 */
	@Override
	public boolean equals(Object object) {

		// check if object is a reference to Note
		if (object == this) {
			return true;
		}
		// check if object is an instance of Note
		if (!(object instanceof Note)) {
			return false;
		}
		// case object to Note
		Note note = (Note) object;
		return note.noteText.equals(noteText);
	}

	/**
	 * Fix the problem if input parameter is empty.
	 * 
	 * @param field
	 *            The input field
	 * @return field if not empty; otherwise return ""
	 */
	private String fixEmpty(String field) {
		if (field == null || field.length() == 0) {
			return "";
		} else {
			return field;
		}
	}

	/**
	 * Returns a hash code for this note.
	 * 
	 * @return a hash code value for this object.
	 */
	@Override
	public int hashCode() {
		int result = 17;
		result = 31 * result + noteText.hashCode();
		return result;
	}

	/**
	 * Defines this object toString format.
	 * 
	 * @return note
	 */
	@Override
	public String toString() {
		return noteText;
	}

	public void setNote(String noteText) {
		this.noteText = fixEmpty(noteText);
	}

	public String getNote() {
		return noteText;
	}
}
