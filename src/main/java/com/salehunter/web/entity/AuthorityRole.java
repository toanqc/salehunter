package com.salehunter.web.entity;

/**
 * This class is indicate the user type of the web application. Currently there
 * 3 types of user:
 * <ul>
 * <li>1. Customer : this is the user which is a customer of the website</li>
 * <li>2. Admin : this is the super user, the admin is able to create / register
 * the doctor account.</li>
 * </ul>
 *
 * @author Toan Quach
 * @version 1.0
 */
public enum AuthorityRole {

	ROLE_CUSTOMER, ROLE_ADMIN;
}
