package fspm.config;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;

/**
 * Defines the required methods adapters must implement to be compatible with the Config class
 * @author  Ou-An Chuang
 * @since   15-12-2022
 */
public interface ConfigAdapter {
    void setParamConfig(String filePath);
    void setModelConfig(String filePath);
    void setOrganConfig(String filePath);

    /**
     * Generic set config using a file of any metaclass type.
     * @param filePath
     */
    void setConfig(String filePath);
    
}
