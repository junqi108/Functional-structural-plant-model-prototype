package fspm.utils;
import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import fspm.config.Config;
import fspm.config.ModelConfig;
import fspm.models.scenario.Scenario;

public class FileReader {
    private Config config;
    private DataStore dataStore;

    private ObjectMapper mapper;

    public FileReader() {
        // Allow shorthand usage
        config = Config.getInstance();
        dataStore = DataStore.getInstance();
    }

    public Object getClassFromYAML(String path, Class targetClass) {
        File file = new File(path);
        mapper = new ObjectMapper(new YAMLFactory());

        return mapper.readValue(file, targetClass);
    }

    public void parseModel(String path) {
        config.setModelConfig((ModelConfig) getClassFromYAML(path, ModelConfig.class));
    }

    public void parseParams(String path) {
        //config.addCategory(path, null);
    }

    public void parseScenario(String path) {
        config.addScenario(ScenarioConfigDeserializer.deserialize(path));
    }

    public void readData(String path) {

    }


}