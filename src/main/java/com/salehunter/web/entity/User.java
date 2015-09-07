package com.salehunter.web.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 
 * @author qct
 * @version 1.0
 */
@Entity
@Table(name = "User")
public class User extends Model {

	private static final long serialVersionUID = -622855600192016623L;

	@NotBlank
	@Size(max = 32)
	@Email
	@Column(name = "EMAIL", unique = true, nullable = false, length = 32)
	private String email;

	@NotBlank
	@Size(min = 8, max = 128)
	@Column(name = "PASSWORD", nullable = false, length = 128)
	private String password;

	@NotBlank
	@Size(min = 8, max = 128)
	@Transient
	private String confirmPassword;

	@Valid
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "EMAIL", referencedColumnName = "EMAIL")
	private List<Authority> authorities = new ArrayList<Authority>();

	/**
	 * <p>
	 * Constructor for User.
	 * </p>
	 */
	public User() {
		// default constructor
	}

	/**
	 * <p>
	 * Setter for the field <code>id</code>.
	 * </p>
	 *
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * <p>
	 * Getter for the field <code>email</code>.
	 * </p>
	 * 
	 * @return the email
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 * <p>
	 * Setter for the field <code>email</code>.
	 * </p>
	 *
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * <p>
	 * Getter for the field <code>password</code>.
	 * </p>
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * <p>
	 * Getter for the field <code>confirmPassword</code>.
	 * </p>
	 *
	 * @return the confirmPassword
	 */
	public String getConfirmPassword() {
		return confirmPassword;
	}

	/**
	 * <p>
	 * Setter for the field <code>confirmPassword</code>.
	 * </p>
	 *
	 * @param confirmPassword
	 *            the confirmPassword to set
	 */
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	/**
	 * <p>
	 * Setter for the field <code>password</code>.
	 * </p>
	 *
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * <p>
	 * Getter for the field <code>authorities</code>.
	 * </p>
	 *
	 * @return the authorities
	 */
	public List<Authority> getAuthorities() {
		return authorities;
	}

	/**
	 * <p>
	 * Setter for the field <code>authorities</code>.
	 * </p>
	 *
	 * @param authorities
	 *            the authorities to set
	 */
	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}
}
