package utils;
import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import models.config.ConfigFile;

public class FileReader {
    private ObjectMapper mapper;

    public FileReader() {
        
    }

    public Class getClassFromYAML(String path, Class targetClass) {
        File file = new File(path);
        mapper = new ObjectMapper(new YAMLFactory());

        return mapper.readValue(file, targetClass);
    }
}