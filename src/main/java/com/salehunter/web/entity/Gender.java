package com.salehunter.web.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.salehunter.web.serializer.GenderDeserializer;
import com.salehunter.web.serializer.GenderSerializer;

/**
 * 
 * @author qct
 * @version 1.0
 */
@JsonSerialize(using = GenderSerializer.class)
@JsonDeserialize(using = GenderDeserializer.class)
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
