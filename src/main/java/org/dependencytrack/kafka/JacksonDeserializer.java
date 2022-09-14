package org.dependencytrack.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;
import org.dependencytrack.model.Component;

public class JacksonDeserializer implements Deserializer<Component> {
    @Override
    public Component deserialize(String topic, byte[] data) {
        try {
            return new ObjectMapper().readValue(data, Component.class);
        } catch (Exception e) {
            throw new SerializationException(e);
        }
    }
}
