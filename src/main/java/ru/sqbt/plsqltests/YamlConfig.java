package ru.sqbt.plsqltests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.sqbt.plsqltests.core.DbTypes;
import ru.sqbt.plsqltests.ora.DbTypesJsonDeserializer;

@Configuration
public class YamlConfig {
    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper mapper =  new ObjectMapper(new YAMLFactory());
        mapper.registerModule(new SimpleModule() {{
            addDeserializer(DbTypes.class, new DbTypesJsonDeserializer());
        }});
        return mapper;
    }
}