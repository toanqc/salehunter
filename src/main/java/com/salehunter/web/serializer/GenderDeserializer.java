package com.salehunter.web.serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.salehunter.web.entity.Gender;

/**
 * 
 * @author qct
 *
 */
public class GenderDeserializer extends JsonDeserializer<Gender> {

	@Override
	public Gender deserialize(JsonParser parser, DeserializationContext context)
			throws IOException, JsonProcessingException {
		switch (parser.getText()) {
		case "M":
			return Gender.MALE;
		case "F":
			return Gender.FAMALE;
		default:
			throw new IllegalArgumentException("Unknow value for Gender: " + parser.getText());
		}
	}
}
