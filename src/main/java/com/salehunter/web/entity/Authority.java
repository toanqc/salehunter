package com.salehunter.web.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 
 * @author qct
 * @version 1.0
 */
@Entity
@Table(name = "Authority")
public class Authority {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@NotBlank
	@Size(max = 32)
	@Email
	@Column(name = "EMAIL", unique = true, nullable = false, length = 32)
	private String email;

	@Valid
	@NotNull
	@Column(name = "AUTHORITY", nullable = false, length = 32)
	@Enumerated(EnumType.STRING)
	private AuthorityRole authorityRole;

	/**
	 * <p>
	 * Constructor for Authority.
	 * </p>
	 */
	public Authority() {
		// default constructor
	}

	/**
	 * <p>
	 * Getter for the field <code>id</code>.
	 * </p>
	 *
	 * @return the id
	 */
	public Long getId() {
		return id;
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
		return email;
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
	 * Getter for the field <code>authorityRole</code>.
	 * </p>
	 *
	 * @return the authorityRole
	 */
	public AuthorityRole getAuthorityRole() {
		return authorityRole;
	}

	/**
	 * <p>
	 * Setter for the field <code>authorityRole</code>.
	 * </p>
	 *
	 * @param authorityRole
	 *            the authorityRole to set
	 */
	public void setAuthorityRole(AuthorityRole authorityRole) {
		this.authorityRole = authorityRole;
	}
}
