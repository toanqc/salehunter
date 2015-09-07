package com.salehunter.web.serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.salehunter.web.entity.Gender;

/**
 * 
 * @author qct
 *
 */
public class GenderSerializer extends JsonSerializer<Gender> {

	@Override
	public void serialize(Gender gender, JsonGenerator genderator, SerializerProvider serializer)
			throws IOException, JsonProcessingException {
		genderator.writeString(gender.getValue());
	}
}
