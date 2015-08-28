package com.salehunter.web.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.salehunter.web.entity.Gender;

/**
 * 
 * @author qct
 *
 */
@Converter
public class GenderConverter implements AttributeConverter<Gender, String> {

	@Override
	public String convertToDatabaseColumn(Gender attribute) {
		return attribute.getValue();
	}

	@Override
	public Gender convertToEntityAttribute(String dbData) {
		switch (dbData) {
		case "M":
			return Gender.MALE;
		case "F":
			return Gender.FAMALE;
		default:
			throw new IllegalArgumentException("Unknow value for Gender: " + dbData);
		}
	}

}
