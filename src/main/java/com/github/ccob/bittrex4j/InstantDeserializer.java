package com.github.ccob.bittrex4j;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.Instant;

public class InstantDeserializer extends JsonDeserializer<Instant> {

    @Override
    public Instant deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        String value = p.getValueAsString();
        Instant result = null;
        if (value != null) {
            if (value.matches("[0-9]{12,}")){
                result = Instant.ofEpochMilli(Long.parseLong(value));
            } else {
                String isoString = value + "Z";
                result = Instant.parse(isoString);
            }
        }
        return result;
    }
}