/**
 * 
 */
package com.salehunter.web.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import com.salehunter.web.converter.GenderConverter;

/**
 * @author qct
 * @version 1.0
 */
@Entity
@Table(name = "Account")
public class Account extends Model {

	private static final long serialVersionUID = 202063969026347451L;

	@NotBlank
	@Size(max = 10)
	@Column(name = "ACCOUNT_ID", length = 10)
	private String accountId;

	@NotBlank
	@Size(max = 32)
	@Column(name = "FIRST_NAME", nullable = false, length = 32)
	private String firstName;

	@NotBlank
	@Size(max = 32)
	@Column(name = "LAST_NAME", nullable = false, length = 32)
	private String lastName;

	@Valid
	@NotNull
	@Column(name = "GENDER", nullable = false, length = 1)
	@Convert(converter = GenderConverter.class)
	private Gender gender;

	@NotBlank
	@Size(max = 12)
	@Column(name = "PHONE", nullable = false, length = 14)
	private String phone;

	@NotBlank
	@Size(max = 32)
	@Column(name = "EMAIL", nullable = false, length = 32)
	private String email;

	@Valid
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "ADDRESS_ID")
	private Address address;

	@Valid
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "USER_ID")
	private User user;

	/**
	 * @return the accountId
	 */
	public String getAccountId() {
		return accountId;
	}

	/**
	 * @param accountId
	 *            the accountId to set
	 */
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the gender
	 */
	public Gender getGender() {
		return gender;
	}

	/**
	 * @param gender
	 *            the gender to set
	 */
	public void setGender(Gender gender) {
		this.gender = gender;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone
	 *            the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
}
