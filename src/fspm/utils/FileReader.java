package fspm.utils;
import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

public class FileReader {
    private ObjectMapper mapper;

    public FileReader() {
        
    }

    public Object getClassFromYAML(String path, Class targetClass) {
        File file = new File(path);
        mapper = new ObjectMapper(new YAMLFactory());

        return mapper.readValue(file, targetClass);
    }
}