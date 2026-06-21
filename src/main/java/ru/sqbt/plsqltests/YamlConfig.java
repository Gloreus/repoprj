package ru.sqbt.plsqltests;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.sqbt.plsqltests.core.DbTypes;
import ru.sqbt.plsqltests.core.ExpectationData;
import ru.sqbt.plsqltests.ora.DbTypesJsonDeserializer;

@Configuration
public class YamlConfig {
    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper mapper =  new ObjectMapper(new YAMLFactory());
        mapper.registerModule(new JavaTimeModule());
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.registerModule(new SimpleModule() {{
            addDeserializer(DbTypes.class, new DbTypesJsonDeserializer());
            addDeserializer(ExpectationData.class, new ExpectationJsonDeserializer());
        }});
        return mapper;
    }
}