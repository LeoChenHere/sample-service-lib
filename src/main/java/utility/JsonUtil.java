package utility;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

public class JsonUtil {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static String toJsonString(Object object) {
        try {
            return OBJECT_MAPPER.writeValueAsString(object);
        } catch (JsonProcessingException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static <T> T parseJson(String json, Class<T> tClass) {
        try {
            return OBJECT_MAPPER.readValue(json, tClass);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static <T> List<T> parseList(String json, Class<T> tClass) {
        JavaType javaType = OBJECT_MAPPER.getTypeFactory().constructParametricType(List.class, new Class[]{tClass});

        try {
            return (List)OBJECT_MAPPER.readValue(json, javaType);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static JsonNode string2Json(String data) {
        try {
            return OBJECT_MAPPER.readTree(data);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
