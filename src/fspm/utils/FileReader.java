package fspm.utils;
import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import fspm.config.Config;
import fspm.config.ModelConfig;
import fspm.models.scenario.Scenario;

public class FileReader {
    private ObjectMapper mapper;
    private Config config;
    private DataStore dataStore;

    public FileReader() {
    }

    public Object getClassFromYAML(String path, Class targetClass) {
        File file = new File(path);
        mapper = new ObjectMapper(new YAMLFactory());

        return mapper.readValue(file, targetClass);
    }

    /**
     * Set the Config instance that will receive the parsed configs from this reader.
     * @param config
     */
    public void setConfigOutput(Config config) {
        this.config = config;
    }

    /**
     * Set the DataStore instance that will receive the parsed data from this reader.
     * @param config
     */
    public void setDataStoreOutput(DataStore dataStore) {
        this.dataStore = dataStore;
    }


    public void parseModel(String path) {
        config.setModelConfig((ModelConfig) getClassFromYAML(path, ModelConfig.class));
    }

    public void parseScenario(String path) {
        config.addScenario(ScenarioConfigDeserializer.deserialize(path));
    }

    public void readData(String path) {

    }


}