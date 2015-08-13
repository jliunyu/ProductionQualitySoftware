package com.nyu.jing.ps1;

import java.util.Objects;

/**
 * Define an Entry class
 * @author jingliu
 *
 */
public class Entry {
	private String name;
	private String postalAddress;
	private String phoneNumber;
	private String email;
	private String note;

	public Entry(String name, String postalddress, String phoneNumber,
			String email, String note) {
		this.name = name;
		this.postalAddress = postalddress;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.note = note;
	}

	/**
	 * get the name in the entry
	 * @return the name in the entry
	 */
	public String getName() {
		return name;
	}

	/**
	 * get the postal address in the entry
	 * @return
	 */
	public String getAddress() {
		return postalAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public String getNote() {
		return note;
	}
	
	  @Override
	  public String toString(){
	    return "Name: " + name + "\n" + "Address: " + postalAddress + "\n" + 
	        "Phone: " + phoneNumber + "\n" + "Email: " + email + "\n" + "Note: " + note;
	  }
	  
	  @Override
	  public int hashCode(){
	    return Objects.hash(name.hashCode(), postalAddress.hashCode(), 
	        phoneNumber.hashCode(), email.hashCode(), note.hashCode());
	  }

	  @Override
	  public boolean equals(Object obj){
	    if(this == obj){
	      return true;
	    }
	    if(obj == null){
	      return false;
	    }
	    if(!(obj instanceof Entry)){
	      return false;
	    }
	    Entry other = (Entry)obj;
	    return name.equals(other.name) 
	        && postalAddress.equals(other.postalAddress)
	        && phoneNumber.equals(other.phoneNumber)
	        && email.equals(other.email)
	        && note.equals(other.note);
	  }

}
