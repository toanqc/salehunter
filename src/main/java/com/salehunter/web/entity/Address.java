package com.salehunter.web.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 
 * @author qct
 * @version 1.0
 */
@Entity
@Table(name = "Address")
public class Address extends Model implements Serializable {

	private static final long serialVersionUID = 3012381205351883526L;

	@NotBlank
	@Size(max = 128)
	@Column(name = "STREET_1", nullable = false, length = 128)
	private String street1;

	@Column(name = "STREET_2", length = 128)
	private String street2;

	@Column(name = "CITY", length = 128)
	private String city;

	@NotBlank
	@Size(max = 10)
	@Column(name = "ZIP", nullable = false, length = 10)
	private String zip;

	@NotBlank
	@Size(max = 128)
	@Column(name = "COUNTRY", nullable = false, length = 128)
	private String country;

	@NotBlank
	@Size(max = 32)
	@Column(name = "STATE", length = 32)
	private String state;

	/**
	 * @return the street1
	 */
	public String getStreet1() {
		return street1;
	}

	/**
	 * @param street1
	 *            the street1 to set
	 */
	public void setStreet1(String street1) {
		this.street1 = street1;
	}

	/**
	 * @return the street2
	 */
	public String getStreet2() {
		return street2;
	}

	/**
	 * @param street2
	 *            the street2 to set
	 */
	public void setStreet2(String street2) {
		this.street2 = street2;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city
	 *            the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the zip
	 */
	public String getZip() {
		return zip;
	}

	/**
	 * @param zip
	 *            the zip to set
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country
	 *            the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

}
