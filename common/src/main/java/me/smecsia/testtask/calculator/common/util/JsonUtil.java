package me.smecsia.testtask.calculator.common.util;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

/**
 * @author Ilya Sadykov
 */
public class JsonUtil {
    private static final ObjectMapper mapper = new ObjectMapper();

    public static <T> T fromJson(String value, Class<T> clazz) throws IOException {
        return mapper.readValue(value, clazz);
    }

    public static String toJson(Object obj) throws IOException {
        return mapper.writeValueAsString(obj);
    }
}
