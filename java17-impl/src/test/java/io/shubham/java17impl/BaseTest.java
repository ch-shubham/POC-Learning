package io.shubham.java17impl;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.springframework.util.ObjectUtils;

public class BaseTest {

    public static ObjectMapper objectMapper;

    protected <T> T stub(Class<T> objectToMock) {
        EasyRandomParameters parameters = new EasyRandomParameters()
                .objectFactory(new RecordFactory());
        parameters.collectionSizeRange(1, 3);
        parameters.stringLengthRange(3, 30);
        EasyRandom generator = new EasyRandom(parameters);
        return generator.nextObject(objectToMock);
    }

    protected ObjectMapper getObjectMapper() {
        if (ObjectUtils.isEmpty(objectMapper)) {
            objectMapper = new ObjectMapper();
        }
        return objectMapper;
    }
}