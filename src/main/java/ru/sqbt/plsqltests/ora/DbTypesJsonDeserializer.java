package ru.sqbt.plsqltests.ora;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import ru.sqbt.plsqltests.core.DbTypes;

import java.io.IOException;

public class DbTypesJsonDeserializer extends JsonDeserializer<DbTypes> {
    @Override
    public DbTypes deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String typeName = p.getText();
        try {
            return OracleTypes.valueOf(typeName);
        } catch (IllegalArgumentException e) {
            throw new IOException("Unknown database type: " + typeName, e);
        }
    }
}