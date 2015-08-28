package com.salehunter.web.entity;

/**
 * 
 * @author qct
 *
 */
public enum Gender {

	MALE("M"), FAMALE("F");

	private String value;

	private Gender(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}
}
