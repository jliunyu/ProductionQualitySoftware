package edu.nyu.cs.pqs.ps1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * PostalAddress Class is for creating postal address object in address book
 * entry. PostalAddress object accepts five fields to create an name: street,
 * city, state, zip and country. All of these fields are optional. The zip code
 * should be number or '-'. Default country value is "United States". Builder
 * Pattern is used in designing this class.
 * 
 * Two postal addresses are equal if and only if their non-empty fields are
 * equivalent. The equals method implements an equivalence relation.
 * 
 * The toString format of the object name is "street, city, state zip, country".
 * 
 * @author yixia
 * 
 */
public class PostalAddress {

	private String street;
	private String city;
	private String state;
	private String zip;
	private String country;

	// The Constant zipPattern should be number or '-'
	private final static Pattern zipPattern = Pattern.compile("^([-0-9]+)$");

	/**
	 * The Class Builder used as builder of Name class. Use Builder Pattern
	 * here.
	 * 
	 */
	public static class Builder {

		// No Required parameter

		// optional parameters - initialized to default values
		private String street = "";
		private String city = "";
		private String state = "";
		private String zip = "";
		// Default country is United States.
		private final static String defaultCountry = "United States";
		private String country = defaultCountry;

		/**
		 * Fix the problem if input parameter is empty.
		 * 
		 * @param field
		 *            The input field
		 * @return field if not empty; otherwise return ""
		 */
		private static String fixEmpty(String field) {
			if (field == null || field.length() == 0) {
				return "";
			} else {
				return field;
			}
		}

		/**
		 * Fix the problem if input country is empty.
		 * 
		 * @param field
		 *            The input field
		 * @return field if not empty; otherwise return default country value
		 */
		private static String fixEmptyCountry(String country) {
			if (country == null || country.length() == 0) {
				return defaultCountry;
			} else {
				return country;
			}
		}

		/**
		 * Check if zipcode format is correct. Return "" if input zip is empty,
		 * and throw exception if zipcode format violates zip pattern.
		 * 
		 * @param zip
		 *            The input zipcode
		 * @return "" if input zip is empty, and throw exception if zipcode
		 *         format violates zip pattern; otherwise return input zip
		 * @throws FormatException
		 *             if zip format is not correct
		 */
		private static String zipCheck(String zip) throws FormatException {
			if (zip == null || zip.length() == 0) {
				return "";
			}
			// match zip with zipcode Pattern
			Matcher match = zipPattern.matcher(zip);
			if (match.find()) {
				return zip;
			} else {
				throw new FormatException("zipcode format is not correct!");
			}

		}

		/**
		 * The builder's setter method for optional parameter street
		 * 
		 * @param street
		 *            optional field street
		 * @return the builder itself
		 */
		public Builder street(String street) {
			this.street = fixEmpty(street);
			return this;
		}

		/**
		 * The builder's setter method for optional parameter city
		 * 
		 * @param city
		 *            optional field city
		 * @return the builder itself
		 */
		public Builder city(String city) {
			this.city = fixEmpty(city);
			return this;
		}

		/**
		 * The builder's setter method for optional parameter state
		 * 
		 * @param state
		 *            optional field state
		 * @return the builder itself
		 */
		public Builder state(String state) {
			this.state = fixEmpty(state);
			return this;
		}

		/**
		 * The builder's setter method for optional parameter zip
		 * 
		 * @param zip
		 *            optional field zip
		 * @return the builder itself
		 * @throws FormatException
		 *             if zip format is not correct
		 */
		public Builder zip(String zip) throws FormatException {
			this.zip = zipCheck(zip);
			return this;
		}

		/**
		 * The builder's setter method for optional parameter country
		 * 
		 * @param country
		 *            optional field country
		 * @return the builder itself
		 */
		public Builder country(String country) {
			this.country = fixEmptyCountry(country);
			return this;
		}

		/**
		 * Builds an instance of PostalAddress
		 * 
		 * @return an instance of PostalAddress
		 */
		public PostalAddress build() {
			return new PostalAddress(this);
		}
	}

	/**
	 * Instantiates a new PostalAddress.
	 * 
	 * @param builder
	 *            The builder pattern
	 */
	private PostalAddress(Builder builder) {
		this.street = builder.street;
		this.city = builder.city;
		this.state = builder.state;
		this.zip = builder.zip;
		this.country = builder.country;
	}

	/**
	 * Compares this postal address to the specified object. The result is true
	 * if and only if the argument is a PostalAddress object and its non-empty
	 * fields that represent the same sequence of characters as this object.
	 * 
	 * @param object
	 *            The object to compare this PostalAddress against
	 * 
	 * @return true if the given object represents a PostalAddress equivalent to
	 *         this PostalAddress, false otherwise
	 */
	@Override
	public boolean equals(Object object) {

		// check if object is a reference to postalAddress
		if (object == this) {
			return true;
		}
		// check if object is an instance of postalAddress
		if (!(object instanceof PostalAddress)) {
			return false;
		}
		// case object to postalAddress
		PostalAddress postalAddress = (PostalAddress) object;
		// compare non-empty field
		if (postalAddress.street.length() != 0
				&& (!postalAddress.street.equals(street))) {
			return false;
		} else if (postalAddress.city.length() != 0
				&& (!postalAddress.city.equals(city))) {
			return false;
		} else if (postalAddress.state.length() != 0
				&& (!postalAddress.state.equals(state))) {
			return false;
		} else if (postalAddress.zip.length() != 0
				&& (!postalAddress.zip.equals(zip))) {
			return false;
		} else {
			// country has default value, cannot be empty
			return postalAddress.country.equals(country);
		}
	}

	/**
	 * Returns a hash code for this postal address.
	 * 
	 * @return a hash code value for this object.
	 */
	@Override
	public int hashCode() {
		int result = 17;
		result = 31 * result + street.hashCode();
		result = 31 * result + city.hashCode();
		result = 31 * result + state.hashCode();
		result = 31 * result + zip.hashCode();
		result = 31 * result + country.hashCode();
		return result;
	}

	/**
	 * Defines this object toString format.
	 * 
	 * @return a string in the format of "street, city, state zip, country"
	 */
	@Override
	public String toString() {
		return street + ", " + city + ", " + state + " " + zip + ", " + country;
	}

	/**
	 * Sets the country name.
	 * 
	 * @param country
	 *            the new country name
	 */
	public void setCountry(String country) {
		this.country = Builder.fixEmptyCountry(country);
	}

	/**
	 * Sets the state name.
	 * 
	 * @param state
	 *            the new state name
	 */
	public void setState(String state) {
		this.state = Builder.fixEmpty(state);
	}

	/**
	 * Sets the city name.
	 * 
	 * @param city
	 *            the new city name
	 */
	public void setCity(String city) {
		this.city = Builder.fixEmpty(city);
	}

	/**
	 * Sets the street name.
	 * 
	 * @param street
	 *            the new street name
	 */
	public void setStreet(String street) {
		this.street = Builder.fixEmpty(street);
	}

	/**
	 * Sets the zip.
	 * 
	 * @param zip
	 *            the new zip
	 * @throws FormatException
	 *             thrown if format is not correct
	 */
	public void setzip(String zip) throws FormatException {
		this.zip = Builder.zipCheck(zip);
	}

	/**
	 * Gets the country.
	 * 
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * Gets the state.
	 * 
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * Gets the city.
	 * 
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Gets the street.
	 * 
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * Gets the zip.
	 * 
	 * @return the zip
	 */
	public String getZip() {
		return zip;
	}

}
