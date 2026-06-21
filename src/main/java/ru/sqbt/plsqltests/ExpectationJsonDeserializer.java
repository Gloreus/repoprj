package ru.sqbt.plsqltests;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.sqbt.plsqltests.core.ExpectationData;

import java.io.IOException;

public class ExpectationJsonDeserializer extends JsonDeserializer<ExpectationData> {
    @Override
    public ExpectationData deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        ObjectCodec codec = p.getCodec();
        JsonNode node = codec.readTree(p);

        // Получаем полное имя класса из поля @class
        String className = node.get("expectClass").asText();

        try {
            // Загружаем класс по имени
            Class<?> clazz = Class.forName(className);

            // Проверяем, что класс является наследником ExpectationData
            if (!ExpectationData.class.isAssignableFrom(clazz)) {
                throw new IOException("Class " + className + " is not a subclass of ExpectationData");
            }

            // Создаём ObjectMapper для десериализации в конкретный тип
            ObjectMapper mapper = (ObjectMapper) codec;
            return (ExpectationData) mapper.convertValue(node, clazz);
        } catch (ClassNotFoundException e) {
            throw new IOException("Class not found: " + className, e);
        }
    }
}