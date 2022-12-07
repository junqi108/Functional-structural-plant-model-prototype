package fspm.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import fspm.config.ParamContainer;

import java.io.File;

public class ParamConfigDeserializer {
    public static JsonNode deserialize(String pathname) {
        File configFile = new File(pathname);

        ObjectMapper mapper = new ObjectMapper();
        JsonNode tree = mapper.readTree(configFile);

        return tree;
    }
}
